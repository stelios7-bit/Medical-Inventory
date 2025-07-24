<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

<%-- Hero Section --%>
<div class="px-4 py-5 my-5 text-center">
    <i class="fa-solid fa-hospital-user fa-3x text-primary mb-4"></i>
    <h1 class="display-5 fw-bold">Medical Inventory Management</h1>
    <div class="col-lg-6 mx-auto">
        <p class="lead mb-4">
            Welcome to the Harsh Pharma inventory system. Manage your stock efficiently, track expiry dates, and handle suppliers with ease.
        </p>
        <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
            <a href="MedicineServlet" class="btn btn-primary btn-lg px-4 gap-3">
                <i class="fa-solid fa-boxes-stacked"></i> Manage Inventory
            </a>
        </div>
    </div>
</div>

<%-- Feature Cards Section --%>
<div class="row g-4 py-5 row-cols-1 row-cols-lg-3">

    <div class="col d-flex align-items-start">
        <div class="icon-square text-dark flex-shrink-0 me-3">
            <i class="fa-solid fa-pills fa-2x text-success"></i>
        </div>
        <div>
            <a href="MedicineServlet" class="text-decoration-none text-dark">
                <h2>Add Stock</h2>
            </a>
            <p>Quickly add new medicine batches to your inventory with all necessary details like batch number and supplier.</p>
        </div>
    </div>

    <div class="col d-flex align-items-start">
        <div class="icon-square text-dark flex-shrink-0 me-3">
            <i class="fa-solid fa-calendar-times fa-2x text-danger"></i>
        </div>
        <div>
            <a href="ExpiryReportServlet" class="text-decoration-none text-dark">
                <h2>Track Expiry</h2>
            </a>
            <p>Keep a close watch on expiry dates to ensure patient safety and reduce waste. The system highlights items nearing expiry.</p>
        </div>
    </div>

    <div class="col d-flex align-items-start">
        <div class="icon-square text-dark flex-shrink-0 me-3">
            <i class="fa-solid fa-truck-fast fa-2x text-info"></i>
        </div>
        <div>
            <a href="SupplierServlet" class="text-decoration-none text-dark">
                <h2>Manage Suppliers</h2>
            </a>
            <p>Maintain a record of your suppliers and the items they provide for streamlined procurement and communication.</p>
        </div>
    </div>
    
</div>

<%@ include file="footer.jsp" %>