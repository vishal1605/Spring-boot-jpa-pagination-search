<%@page import="com.firstboot.beans.Users" %>
<%@page import="java.util.List" %>
<%@page import="org.springframework.data.domain.Pageable" %>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<style>
.active{
background-color: skyblue;
color: white;
}
</style>
</head>
<body>
<div class="head text-center mb-3">
<h1>All Data</h1>
</div><br/>
<div class="new text-center mb-3">
<h1>Add new details</h1>
<a href="/">Add new</a>
</div><br/>
<div class="search-container m-4" style="position: relative;">
<form class="form-inline" action="/view/search" method="post">
  <div class="form-group mx-sm-3 mb-2">
    <input type="text" class="form-control" id="inputPassword2" name="query" placeholder="search here" style="width: 500px">
  </div><span>Search by</span>&nbsp;
  <select class="form-control" id="form_option" name="options">
      <option value="userName">userName</option>
      <option value="email">email</option>
      <option value="city">city</option>
    </select>&nbsp;&nbsp;
  <button type="submit" class="btn btn-primary mb-2">Search</button>&nbsp;
  <button type="reset" class="btn btn-primary mb-2">Clear</button>
</form>
<!-- <div class="search-result" style="box-shadow: 5px 5px 10px gray; border:1px solid black;
 position: absolute; width: 100%; top:45px; background-color: white; padding: 10px;">
<p>lojbjhbsjh jha shxbuabdij kmsd jsnudbudnd;lkmakdnkA X kmsojqsnksnjbchbindxjk</p>
<h1>Result of search</h1>
</div> -->

</div>
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
      <th scope="col">Delete</th>
      <th scope="col">Edit</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="user" items="${AllUsers.content}">
    <tr>
      <td><c:out value="${user.uId}"></c:out></td>
      <td><c:out value="${user.userName}"></c:out></td>
      <td><c:out value="${user.email}"></c:out></td>
      <td><c:out value="${user.password}"></c:out></td>
      <td><c:out value="${user.city}"></c:out></td>
      <td><c:out value="${user.salary}"></c:out></td>
      <td><c:out value="${user.date}"></c:out></td>
      <td><a href="/delete/${user.uId}">Delete</a></td>
      <td><a href="/updateform/${user.uId}">Edit</a></td>
    </tr>
   </c:forEach>
  </tbody>
</table>
<!-- ===============Pagination starts from here=================== -->
<%

int p=(int)session.getAttribute("Pages");
/* System.out.println(p); */
%>
<div class="pagination d-flex justify-content-center mb-3">
<nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:if test="${Pages != 1}">
    <li class="page-item"><a class="page-link" href="/view/${page-1}">Previous</a></li>
     </c:if>
     <c:forEach begin="1" end="${totalPages}" var="page">
    <li class="page-item"><a class="page-link ${Pages==page ? 'active' : ''}"  href="/view/${page}">${page}</a></li>
    </c:forEach>
    <c:if test="${Pages != totalPages}">
    <li class="page-item"><a class="page-link " href="/view/${page+1}">Next</a></li>
    </c:if>
  </ul>
</nav>
</div>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>