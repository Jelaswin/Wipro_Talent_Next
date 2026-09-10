<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String productId = request.getParameter("productId");
    String productName = request.getParameter("productName");
    double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String supplierName = request.getParameter("supplierName");

    double totalValue = unitPrice * quantity;

    String stockStatus;

    if (quantity == 0) {
        stockStatus = "Out of Stock";
    } else if (quantity < 10) {
        stockStatus = "Low Stock";
    } else {
        stockStatus = "In Stock";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Inventory Report</title>
</head>
<body>

<h2>Product Inventory Report</h2>

<table border="1" cellpadding="10">

    <tr>
        <th>Product ID</th>
        <td><%= productId %></td>
    </tr>

    <tr>
        <th>Product Name</th>
        <td><%= productName %></td>
    </tr>

    <tr>
        <th>Unit Price</th>
        <td><%= unitPrice %></td>
    </tr>

    <tr>
        <th>Quantity</th>
        <td><%= quantity %></td>
    </tr>

    <tr>
        <th>Supplier Name</th>
        <td><%= supplierName %></td>
    </tr>

    <tr>
        <th>Total Inventory Value</th>
        <td><%= totalValue %></td>
    </tr>

    <tr>
        <th>Stock Status</th>
        <td><%= stockStatus %></td>
    </tr>

</table>

<br>

<a href="product.jsp">Add Another Product</a>

</body>
</html>