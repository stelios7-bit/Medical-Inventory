<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.entity.Medicine" %>

<%@ include file="header.jsp" %>

<div class="card shadow-sm">
    <div class="card-header">
        <h2 class="h5 mb-0"><i class="fa-solid fa-calendar-times text-danger"></i> Expiry Report (Next 90 Days)</h2>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Batch No.</th>
                        <th>Expiry Date</th>
                        <th>Quantity</th>
                        <th>Supplier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Medicine> expiringList = (List<Medicine>) request.getAttribute("expiringList");
                        if (expiringList != null && !expiringList.isEmpty()) {
                            for (Medicine med : expiringList) {
                    %>
                                <tr class="table-warning">
                                    <td><%= med.getItem_name() %></td>
                                    <td><%= med.getBatch_number() %></td>
                                    <td><strong><%= med.getExp_date() %></strong></td>
                                    <td><%= med.getQuantity() %></td>
                                    <td><%= med.getSupp_name() %></td>
                                </tr>
                    <%
                            } 
                        } else {
                    %>
                            <tr>
                                <td colspan="5" class="text-center">No items are expiring in the next 90 days.</td>
                            </tr>
                    <%
                        } 
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>