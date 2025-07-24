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

// This servlet is mapped to a new URL
@WebServlet("/ExpiryReportServlet")
public class ExpiryReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Create an instance of the DAO
        MedicineDAO dao = new MedicineDAO();
        
        // 2. Call the new method to get only the expiring medicines
        List<Medicine> expiringList = dao.getExpiringMedicines();
        
        // 3. Set the list as an attribute to be used by the JSP
        request.setAttribute("expiringList", expiringList);
        
        // 4. Forward the request to a new JSP page that will display the report
        request.getRequestDispatcher("expiryReport.jsp").forward(request, response);
    }
}