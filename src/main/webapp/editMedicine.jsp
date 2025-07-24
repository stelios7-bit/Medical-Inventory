<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.Medicine" %>

<%@ include file="header.jsp" %>

<%
    // Get the medicine object that the servlet passed in the request
    Medicine med = (Medicine) request.getAttribute("medicine");

    // If for some reason the object is null, redirect back to the main page
    if (med == null) {
        response.sendRedirect("MedicineServlet");
        return;
    }
%>

<div class="card shadow-sm mb-4">
    <div class="card-header">
        <h2 class="h5 mb-0"><i class="fa-solid fa-pencil"></i> Edit Medicine Details</h2>
    </div>
    <div class="card-body">
        <form action="MedicineServlet" method="POST">
            <%-- Hidden inputs to tell the servlet what to do and which item to update --%>
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="itemId" value="<%= med.getItem_id() %>">

            <div class="row">
                 <div class="col-md-6 mb-3">
                    <label for="itemIdDisplay" class="form-label">Item ID</label>
                    <input type="text" class="form-control" id="itemIdDisplay" value="<%= med.getItem_id() %>" disabled>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="itemName" class="form-label">Item Name</label>
                    <input type="text" class="form-control" id="itemName" name="itemName" value="<%= med.getItem_name() %>" required>
                </div>
            </div>
             <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="batchNumber" class="form-label">Batch Number</label>
                    <input type="text" class="form-control" id="batchNumber" name="batchNumber" value="<%= med.getBatch_number() %>" required>
                </div>
                 <div class="col-md-6 mb-3">
                    <label for="expDate" class="form-label">Expiry Date</label>
                    <input type="date" class="form-control" id="expDate" name="expDate" value="<%= med.getExp_date() %>" required>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="quantity" class="form-label">Quantity</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" value="<%= med.getQuantity() %>" min="0" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="suppName" class="form-label">Supplier Name</label>
                    <input type="text" class="form-control" id="suppName" name="suppName" value="<%= med.getSupp_name() %>" required>
                </div>
            </div>
            <button type="submit" class="btn btn-success"><i class="fa-solid fa-check"></i> Save Changes</button>
            <a href="MedicineServlet" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>