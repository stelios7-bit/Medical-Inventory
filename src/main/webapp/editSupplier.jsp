<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.Supplier" %>

<%@ include file="header.jsp" %>

<%
    Supplier sup = (Supplier) request.getAttribute("supplier");
    if (sup == null) {
        response.sendRedirect("SupplierServlet");
        return;
    }
%>

<div class="card shadow-sm mb-4">
    <div class="card-header">
        <h2 class="h5 mb-0"><i class="fa-solid fa-pencil"></i> Edit Supplier</h2>
    </div>
    <div class="card-body">
        <form action="SupplierServlet" method="POST">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="supplierId" value="<%= sup.getSupplierId() %>">
            
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="supplierName" class="form-label">Supplier Name</label>
                    <input type="text" class="form-control" id="supplierName" name="supplierName" value="<%= sup.getSupplierName() %>" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="contactPerson" class="form-label">Contact Person</label>
                    <input type="text" class="form-control" id="contactPerson" name="contactPerson" value="<%= sup.getContactPerson() %>">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= sup.getEmail() %>">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="phone" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="<%= sup.getPhone() %>">
                </div>
            </div>
            <button type="submit" class="btn btn-success"><i class="fa-solid fa-check"></i> Save Changes</button>
            <a href="SupplierServlet" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>