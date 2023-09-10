<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="title">Registration</div>
		<form action="regForm" method="post">
			<div class="user-details">
				<div class="input-box">
					<span class="details">Full Name</span>
					<input type="text" placeholder="Enter your full name" name="name1" />
				</div>
				<div class="input-box">
					<span class="details">Email</span>
					<input type="text" placeholder="Enter your email" name="email" />
				</div>
				<div class="input-box">
					<span class="details">Password</span>
					<input type="password" placeholder="Enter password" name="pass1" />
				</div>
				<div class="input-box">
					<span class="details">Mobile</span>
					<input type="password" placeholder="Enter your mobile number" name="mob1" />
				</div>
				<div class="gender-details">
				<input type ="radio" name="gender" value="Male" id="dot-1">
				<input type ="radio" name="gender" value="Female" id="dot-2">
					<span class="gender-title">Gender</span>
					<div class="category">
						<label for="dot-1">
							<span class="dot one"></span>
							<span class="gender1">Male</span>
						</label>
						<label for="dot-2">
							<span class="dot two"></span>
							<span class="gender">Female</span>
						</label>
					</div>
				</div>
				<div class="button">
					<input type="submit" value="Register">
				</div>
				<div class="register-link">
				<p>Already have an account? <a href="login.jsp">LogIn</a></p>
			</div>
			</div>
		</form>
	</div>
</body>
</html>