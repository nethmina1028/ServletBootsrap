<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
         <header class="navbar navbar-dark bg-primary">
		<div>
			<a href="./index.jsp" class="navbar-brand mx-2">HMS</a>
		</div>
		
		
	</header>

	<main style="margin-top:8%">
		<h1 class="text-center">Doctor Login</h1>
		
		<form class="w-25 mx-auto" action="loginDoctor">
			<div class="form-outline mb-4">
				<label class="form-label">Username</label>
				<input type="text" class="form-control border-primary" name="uname" placeholder="Enter your username..">
			</div>
			
			<div class="form-outline mb-5">
				<label class="form-label">Password</label>
				<input type="password" class="form-control border-primary" name="upass" placeholder="Enter your password..">
			</div>
			
			<input type="submit" class="btn btn-primary" value="Login">
		</form>
	</main>
	
	<footer class="fixed-bottom bg-primary">
		<p class="text-center text-light">2024 &copy; nethmina</p>
	</footer>
</body>
</html>