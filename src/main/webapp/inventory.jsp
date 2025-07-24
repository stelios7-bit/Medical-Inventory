<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.entity.Medicine" %>

<%@ include file="header.jsp" %>

<%-- Add New Medicine Form --%>
<div class="card shadow-sm mb-4">
    <div class="card-header">
        <h2 class="h5 mb-0"><i class="fa-solid fa-plus"></i> Add New Medicine</h2>
    </div>
    <div class="card-body">
        <form action="MedicineServlet" method="POST">
            <input type="hidden" name="action" value="add">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="itemName" class="form-label">Item Name</label>
                    <input type="text" class="form-control" id="itemName" name="itemName" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="batchNumber" class="form-label">Batch Number</label>
                    <input type="text" class="form-control" id="batchNumber" name="batchNumber" required>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label for="expDate" class="form-label">Expiry Date</label>
                    <input type="date" class="form-control" id="expDate" name="expDate" required>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="quantity" class="form-label">Quantity</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" min="0" required>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="suppName" class="form-label">Supplier Name</label>
                    <input type="text" class="form-control" id="suppName" name="suppName" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary"><i class="fa-solid fa-floppy-disk"></i> Save Item</button>
        </form>
    </div>
</div>


<%-- Current Inventory Table --%>
<hr class="my-4">

<div class="card shadow-sm">
    <div class="card-header">
        <h2 class="h5 mb-0"><i class="fa-solid fa-clipboard-list"></i> Current Inventory</h2>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Item Name</th>
                        <th>Batch No.</th>
                        <th>Expiry Date</th>
                        <th>Quantity</th>
                        <th>Supplier</th>
                        <th>Last Updated</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- SCRIPTLET CODE STARTS HERE --%>
                    <%
                        // 1. DECLARE A COUNTER VARIABLE before the loop starts.
                        int rowNumber = 1;

                        List<Medicine> medicineList = (List<Medicine>) request.getAttribute("medicineList");
                        if (medicineList != null && !medicineList.isEmpty()) {
                            for (Medicine med : medicineList) {
                    %>
                                <tr>
                                    <%-- 2. DISPLAY THE COUNTER instead of the real ID. --%>
                                    <td><%= rowNumber %></td>

                                    <%-- The rest of the data remains the same --%>
                                    <td><%= med.getItem_name() %></td>
                                    <td><%= med.getBatch_number() %></td>
                                    <td><%= med.getExp_date() %></td>
                                    <td><%= med.getQuantity() %></td>
                                    <td><%= med.getSupp_name() %></td>
                                    <td><%= med.getLast_updated() %></td>
                                    <td>
                                        <%-- The Edit and Delete buttons STILL USE THE REAL ID --%>
                                        <a href="MedicineServlet?action=loadForEdit&itemId=<%= med.getItem_id() %>" class="btn btn-warning btn-sm" title="Edit Item">
                                            <i class="fa-solid fa-pencil"></i>
                                        </a>
                                        <form action="MedicineServlet" method="POST" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this item?');">
                                            <input type="hidden" name="action" value="delete">
                                            <input type="hidden" name="itemId" value="<%= med.getItem_id() %>">
                                            <button type="submit" class="btn btn-danger btn-sm" title="Delete Item">
                                                <i class="fa-solid fa-trash"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                    <%
                                // 3. INCREMENT THE COUNTER at the end of each loop.
                                rowNumber++;
                            } 
                        } else {
                    %>
                            <tr>
                                <td colspan="8" class="text-center">No items found in inventory.</td>
                            </tr>
                    <%
                        } 
                    %>
                     <%-- SCRIPTLET CODE ENDS HERE --%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>