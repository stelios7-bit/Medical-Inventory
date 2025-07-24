<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.entity.Supplier" %>

<%@ include file="header.jsp" %>

<%-- Add New Supplier Form --%>
<div class="card shadow-sm mb-4">
    <div class="card-header">
        <h2 class="h5 mb-0"><i class="fa-solid fa-user-plus"></i> Add New Supplier</h2>
    </div>
    <div class="card-body">
    <%-- Display Error Message if it exists --%>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
    <div class="alert alert-danger" role="alert">
        <%= errorMessage %>
    </div>
<%
    }
%>

<form action="SupplierServlet" method="POST">
    <%-- Rest of your form... --%>
        <form action="SupplierServlet" method="POST">
            <input type="hidden" name="action" value="add">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="supplierName" class="form-label">Supplier Name</label>
                    <input type="text" class="form-control" id="supplierName" name="supplierName" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="contactPerson" class="form-label">Contact Person</label>
                    <input type="text" class="form-control" id="contactPerson" name="contactPerson">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="phone" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="phone" name="phone">
                </div>
            </div>
            <button type="submit" class="btn btn-primary"><i class="fa-solid fa-floppy-disk"></i> Save Supplier</button>
        </form>
    </div>
</div>

<%-- Current Suppliers Table --%>
<hr class="my-4">

<div class="card shadow-sm">
    <div class="card-header">
        <h2 class="h5 mb-0"><i class="fa-solid fa-truck-fast"></i> Current Suppliers</h2>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Supplier Name</th>
                        <th>Contact Person</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
    <%
        // 1. DECLARE A COUNTER VARIABLE
        int rowNumber = 1;

        List<Supplier> supplierList = (List<Supplier>) request.getAttribute("supplierList");
        if (supplierList != null && !supplierList.isEmpty()) {
            for (Supplier sup : supplierList) {
    %>
                <tr>
                    <%-- 2. DISPLAY THE COUNTER instead of the real ID --%>
                    <td><%= rowNumber %></td>

                    <td><%= sup.getSupplierName() %></td>
                    <td><%= sup.getContactPerson() %></td>
                    <td><%= sup.getEmail() %></td>
                    <td><%= sup.getPhone() %></td>
                    <td>
                        <%-- Actions still use the REAL supplierId --%>
                        <a href="SupplierServlet?action=loadForEdit&supplierId=<%= sup.getSupplierId() %>" class="btn btn-warning btn-sm" title="Edit Supplier">
                            <i class="fa-solid fa-pencil"></i>
                        </a>
                        <form action="SupplierServlet" method="POST" style="display:inline;" onsubmit="return confirm('Are you sure?');">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="supplierId" value="<%= sup.getSupplierId() %>">
                            <button type="submit" class="btn btn-danger btn-sm" title="Delete Supplier">
                                <i class="fa-solid fa-trash"></i>
                            </button>
                        </form>
                    </td>
                </tr>
    <%
                // 3. INCREMENT THE COUNTER
                rowNumber++;
            }
        } else {
    %>
            <tr>
                <td colspan="6" class="text-center">No suppliers found.</td>
            </tr>
    <%
        }
    %>
</tbody>
            </table>
        </div>
    </div>
</div>