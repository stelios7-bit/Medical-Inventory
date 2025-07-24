package com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MedicineDAO;
import com.entity.Medicine;

@WebServlet("/MedicineServlet")
public class MedicineServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        MedicineDAO dao = new MedicineDAO();

        if ("loadForEdit".equals(action)) {
         
            try {
                int id = Integer.parseInt(request.getParameter("itemId"));
                Medicine medicineToEdit = dao.getMedicineById(id);
                request.setAttribute("medicine", medicineToEdit);
                request.getRequestDispatcher("editMedicine.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("MedicineServlet"); 
            }
            
        } else {
           
            List<Medicine> medicineList = dao.getAllMedicines();
            request.setAttribute("medicineList", medicineList);
            request.getRequestDispatcher("inventory.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        MedicineDAO dao = new MedicineDAO();

        if (action == null) {
            response.getWriter().println("No action specified.");
            return;
        }

        try {
            switch (action) {
                case "add":
                    
                    String itemName = request.getParameter("itemName");
                    String batchNumber = request.getParameter("batchNumber");
                    Date expDate = Date.valueOf(request.getParameter("expDate")); 
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    String suppName = request.getParameter("suppName");
                    
                   
                    Medicine newMed = new Medicine(0, itemName, batchNumber, expDate, quantity, suppName, new Date(System.currentTimeMillis()));
                    dao.addMedicine(newMed);
                    
                    response.sendRedirect("MedicineServlet");
                    break;

                case "delete":
                   
                    int idToDelete = Integer.parseInt(request.getParameter("itemId"));
                    Medicine medToDelete = new Medicine(idToDelete, null, null, null, 0, null, null);
                    dao.deleteMedicine(medToDelete);
                    response.sendRedirect("MedicineServlet");
                    break;
			    
                case "update":
                    
                    int itemId = Integer.parseInt(request.getParameter("itemId"));
                    String itemName1 = request.getParameter("itemName");
                    String batchNumber1 = request.getParameter("batchNumber");
                    Date expDate1 = Date.valueOf(request.getParameter("expDate"));
                    int quantity1 = Integer.parseInt(request.getParameter("quantity"));
                    String suppName1 = request.getParameter("suppName");

                    Medicine updatedMed = new Medicine(itemId, itemName1, batchNumber1, expDate1, quantity1, suppName1, new Date(System.currentTimeMillis()));
                   
                    dao.updateMedicine(updatedMed);
                    response.sendRedirect("MedicineServlet");
                    break;

                default:
                    response.getWriter().println("Unknown action specified.");
                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid number format.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("A processing error occurred", e);
        }
    }
}
