
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update details</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css">
</head>
<body>
<%-- <%
Users u=(Users)request.getAttribute("updateUser");
out.println(u);

%> --%>

<div class="head1 text-center mb-3">
<h1>Update here</h1>
</div><br/>
<div class="container">
<form action="${pageContext.request.contextPath }/updated" method="post">
			<div class="form-group">
			<input type="text" hidden value="${updateUser.uId }" name="id"><br/>
				<label for="formGroupExampleInput">Username</label> <input
					type="text" class="form-control" id="formGroupExampleInput"
					name="uName" value="${updateUser.userName }" autocomplete="name">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Email</label> <input
					type="email" class="form-control" id="formGroupExampleInput2"
					name="uEmail" value="${updateUser.email }" autocomplete="email">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Password</label> <input
					type="password" class="form-control" id="formGroupExampleInput2"
					name="uPassword" value="${updateUser.password }">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">City</label> <input
					type="text" class="form-control" id="formGroupExampleInput2"
					name="city" value="${updateUser.city }">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Salary</label> <input
					type="text" class="form-control" id="formGroupExampleInput2"
					name="salary" value="${updateUser.salary }">
			</div>
			<div class="btn d-flex justify-content-center">
				<button type="submit" class="btn btn-success">Update & Save</button>
			</div>


		</form>
</div>


</body>
</html>