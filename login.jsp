<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/index-styles.css"> 
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
	<div class="wrapper">
		<form action="LoginForm" method="post">
			<h1>Login</h1>
			<div class ="input-box">
				<input type="text" placeholder="Full Name" name="name1" required>
				<i class='bx bxs-user'></i>
			</div>
			<div class ="input-box">
				<input type="password" placeholder="Password" name="pass1"required>
				<i class='bx bxs-lock-alt'></i>
			</div>
			<button type="submit" class="btn">Login</button>
			<div class="register-link">
				<p>Don't have an account? <a href="register.jsp">Register</a></p>
			</div>
		</form>
	</div>

</body>
</html>