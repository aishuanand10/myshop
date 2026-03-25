<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
    <!-- Optional: Add Bootstrap for better styling -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Customer Directory</h2>
    
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Username</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>DOB</th>
                <th>Mobile</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate through the 'customers' list sent from the servlet --%>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.username}</td>
                    <td>${customer.firstName} ${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.dob}</td>
                    <td>${customer.mobile}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <a href="/register" class="btn btn-primary">Add New Customer</a>
</body>
</html>
