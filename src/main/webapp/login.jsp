<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>

<div class="container">
		<div class="heading d-flex justify-content-center">
			<h2>Login here</h2><br/>
		</div>
		<form action="login" method="post">
			<div class="form-group">
				<label for="formGroupExampleInput2">User Name</label> <input
					type="text" class="form-control" id="formGroupExampleInput2"
					name="lName" placeholder="UserName">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Password</label> <input
					type="password" class="form-control" id="formGroupExampleInput2"
					name="lPassword" placeholder="Password">
			</div>
			
			<div class="btn d-flex justify-content-center">
				<button type="submit" class="btn btn-success">Submit</button>
			</div>

		</form>
	</div>


</body>
</html>