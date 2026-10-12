<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Student Management</title>

</head>

<body>

<h2>Student Management System</h2>

<!-- SEARCH -->

<h3>Search Student</h3>

<form action="/search" method="get">

    <label>Registration Number:</label>

    <input type="number"
           name="regno"
           required>

    <input type="submit"
           value="Search">

</form>

<br>

<a href="/students">Show All Students</a>

<hr>


<!-- MESSAGE -->

<c:if test="${not empty message}">

    <p>
        <b>${message}</b>
    </p>

</c:if>


<!-- STUDENT TABLE -->

<h3>Student List</h3>

<table border="1" cellpadding="10">

<tr>

    <th>Registration Number</th>

    <th>Name</th>

    <th>CGPA</th>

    <th>Actions</th>

</tr>


<c:forEach var="student" items="${students}">

<tr>

    <td>
        ${student.regno}
    </td>

    <td>
        ${student.name}
    </td>

    <td>
        ${student.cgpa}
    </td>

    <td>

        <!-- UPDATE -->

        <a href="/editStudent/${student.regno}">
            Edit
        </a>

        &nbsp; | &nbsp;

        <!-- DELETE -->

        <a href="/deleteStudent/${student.regno}"
           onclick="return confirm('Are you sure you want to delete this student?');">

            Delete

        </a>

    </td>

</tr>

</c:forEach>

</table>


<br>

<a href="/">Add New Student</a>

</body>

</html>