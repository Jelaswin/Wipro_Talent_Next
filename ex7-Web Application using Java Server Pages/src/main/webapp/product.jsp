<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Product Inventory</title>
</head>
<body>

<h2>Product Inventory Management</h2>

<form action="inventory.jsp" method="post">

    Product ID:
    <input type="text" name="productId" required>
    <br><br>

    Product Name:
    <input type="text" name="productName" required>
    <br><br>

    Unit Price:
    <input type="number" name="unitPrice" step="0.01" required>
    <br><br>

    Quantity:
    <input type="number" name="quantity" required>
    <br><br>

    Supplier Name:
    <input type="text" name="supplierName" required>
    <br><br>

    <input type="submit" value="Generate Report">

</form>

</body>
</html>