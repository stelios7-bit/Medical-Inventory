<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medical Inventory - Health Pharma Inc.</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Font Awesome for Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>
    
    <!-- Custom Styles -->
    <style>
        body {
            background-color: #f8f9fa; /* Light grey background */
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
        }
        .navbar-brand {
            font-weight: 600;
            color: #2c3e50 !important;
        }
        .card-header {
            background-color: #e9ecef;
            font-weight: 500;
        }
        .btn-primary {
            background-color: #0056b3;
            border-color: #0056b3;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .table thead th {
             background-color: #343a40;
             color: #ffffff;
        }
    </style>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
        <div class="container">
            <a class="navbar-brand" href="MediHome.jsp">
                <i class="fa-solid fa-pills"></i>
                Health Pharma Inc.
            </a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="MediHome.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="MedicineServlet">Inventory</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main class="container mt-4 mb-5">