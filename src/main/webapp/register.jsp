<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register please</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container">
		<div class="heading d-flex justify-content-center">
			<h2>Registration form</h2><br/>
		</div>
		<!-- <div class="alert alert-danger text-center p-0 mb-0" role="alert">
				
			</div> -->
		<div class="alert alert-danger text-center " role="alert">
				${failedMsg}
			</div>
			<a href="view/1">View All Data</a><br/>
			<a href="loginForm">Click to login</a>
		<br />
		<form action="register" method="post">
			<div class="form-group">
				<label for="formGroupExampleInput">Username</label> <input
					type="text" class="form-control" id="formGroupExampleInput"
					name="uName" placeholder="Username" autocomplete="name">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Email</label> <input
					type="email" class="form-control" id="formGroupExampleInput2"
					name="uEmail" placeholder="Email" autocomplete="email">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Password</label> <input
					type="password" class="form-control" id="formGroupExampleInput2"
					name="uPassword" placeholder="Password">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">City</label> <input
					type="text" class="form-control" id="formGroupExampleInput2"
					name="city" placeholder="City">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Salary</label> <input
					type="text" class="form-control" id="formGroupExampleInput2"
					name="salary" placeholder="Last month salary">
			</div>
			<div class="btn d-flex justify-content-center">
				<button type="submit" class="btn btn-success">Submit</button>
			</div>

		</form>
	</div>


</body>
</html>