package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MedicineDAO;
import com.entity.Medicine;

@WebServlet("/ExpiryReportServlet")
public class ExpiryReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        MedicineDAO dao = new MedicineDAO();
        List<Medicine> expiringList = dao.getExpiringMedicines();
        request.setAttribute("expiringList", expiringList);
        request.getRequestDispatcher("expiryReport.jsp").forward(request, response);
    }
}
