<%@page import="com.firstboot.beans.Users" %>
<%@page import="java.util.List" %>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container">
<table class="table table-bordered">
  <thead>
    <tr class="table-dark">
      <th scope="col">id</th>
      <th scope="col">Username</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
      <th scope="col">City</th>
      <th scope="col">Salary</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${currentUser}">
    <tr>
      <td><c:out value="${user.uId }"></c:out></td>
      <td><c:out value="${user.userName }"></c:out></td>
      <td><c:out value="${user.email }"></c:out></td>
      <td><c:out value="${user.password }"></c:out></td>
      <td><c:out value="${user.city }"></c:out></td>
      <td><c:out value="${user.salary }"></c:out></td>
      <td><c:out value="${user.date }"></c:out></td>
      
    </tr>
   </c:forEach>
  </tbody>
</table>
</div>

</body>
</html>