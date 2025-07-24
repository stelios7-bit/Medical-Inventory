package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DAO.SupplierDAO;
import com.entity.Supplier;

@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        SupplierDAO dao = new SupplierDAO();

        if ("loadForEdit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("supplierId"));
            Supplier supplier = dao.getSupplierById(id);
            request.setAttribute("supplier", supplier);
            request.getRequestDispatcher("editSupplier.jsp").forward(request, response);
        } else {
            List<Supplier> supplierList = dao.getAllSuppliers();
            request.setAttribute("supplierList", supplierList);
            request.getRequestDispatcher("manageSuppliers.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        SupplierDAO dao = new SupplierDAO();

        switch (action) {
            case "add":
                addSupplier(request, response, dao);
                break;
            case "update":
                updateSupplier(request, response, dao);
                break;
            case "delete":
                deleteSupplier(request, response, dao);
                break;
            default:
                response.sendRedirect("SupplierServlet");
                break;
        }
    }

    private void addSupplier(HttpServletRequest request, HttpServletResponse response, SupplierDAO dao) throws ServletException, IOException {
        String name = request.getParameter("supplierName");
        String contact = request.getParameter("contactPerson");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Supplier newSupplier = new Supplier(0, name, contact, email, phone);
        
        try {
            dao.addSupplier(newSupplier);
            response.sendRedirect("SupplierServlet");
        } catch (SQLException e) {
            String userMessage;
            // Check for the specific phone number constraint error
            if (e.getMessage().contains("chk_phone_format")) {
                userMessage = "Invalid phone number. It must be up to 10 digits with no letters or special characters.";
            } else if (e.getMessage().contains("chk_email_format")) {
                userMessage = "Invalid email format. Please provide a valid email address.";
            } else {
                userMessage = "An unexpected error occurred while saving.";
            }
            request.setAttribute("errorMessage", userMessage);
            request.getRequestDispatcher("manageSuppliers.jsp").forward(request, response);
        }
    }

    private void updateSupplier(HttpServletRequest request, HttpServletResponse response, SupplierDAO dao) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("supplierId"));
        String name = request.getParameter("supplierName");
        String contact = request.getParameter("contactPerson");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Supplier supplier = new Supplier(id, name, contact, email, phone);
        
        try {
            dao.updateSupplier(supplier);
            response.sendRedirect("SupplierServlet");
        } catch (SQLException e) {
            String userMessage;
            // Check for the specific phone number constraint error
            if (e.getMessage().contains("chk_phone_format")) {
                userMessage = "Invalid phone number. It must be up to 10 digits with no letters or special characters.";
            } else if (e.getMessage().contains("chk_email_format")) {
                userMessage = "Invalid email format. Please provide a valid email address.";
            } else {
                userMessage = "An unexpected error occurred while updating.";
            }
            request.setAttribute("errorMessage", userMessage);
            request.setAttribute("supplier", supplier); // Pass the object back to re-populate the form
            request.getRequestDispatcher("editSupplier.jsp").forward(request, response);
        }
    }
    private void deleteSupplier(HttpServletRequest request, HttpServletResponse response, SupplierDAO dao) throws IOException {
        int id = Integer.parseInt(request.getParameter("supplierId"));
        dao.deleteSupplier(id);
        response.sendRedirect("SupplierServlet");
    }
}