<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Student Form</title>

</head>

<body>

<c:choose>

    <c:when test="${editMode}">

        <h2>Update Student</h2>

    </c:when>

    <c:otherwise>

        <h2>Student Registration Form</h2>

    </c:otherwise>

</c:choose>


<form action="/saveStudent" method="post">


    <!-- REGISTRATION NUMBER -->

    <label>Registration Number:</label>

    <input type="number"
           name="regno"
           value="${student.regno}"
           required
           <c:if test="${editMode}">readonly</c:if>
    >

    <br><br>


    <!-- NAME -->

    <label>Name:</label>

    <input type="text"
           name="name"
           value="${student.name}"
           required>

    <br><br>


    <!-- CGPA -->

    <label>CGPA:</label>

    <input type="number"
           name="cgpa"
           value="${student.cgpa}"
           step="0.01"
           min="0"
           max="10"
           required>

    <br><br>


    <c:choose>

        <c:when test="${editMode}">

            <input type="submit"
                   value="Update Student">

        </c:when>

        <c:otherwise>

            <input type="submit"
                   value="Add Student">

        </c:otherwise>

    </c:choose>


</form>


<br>

<a href="/students">
    View All Students
</a>

</body>

</html>