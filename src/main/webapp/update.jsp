<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<a href="dashboard" class="navbar-brand mx-2 text-warning">Back to Dashboard</a>
		</div>
		
		<ul class="navbar-nav">
			<li>
				<a href="logout" class="nav-link mx-2">Doctor Logout</a>
			</li>
		</ul>
	</header>

	<main style="margin-top:2%" class="mx-5">
		<div class="col-6 mx-auto">
			<form action="updatePatient">
				<h2>Update Patient</h2>
				
				<input type="text" name="uid" value="<c:out value='${pt.id }'/>" hidden>
				
				<div class="form-group mb-2 row">
					<label class="col-sm-2 col-form-label">Name</label>
					<input type="text" name="uname" class="form-control border-primary" value="<c:out value='${pt.name }'/>">
				</div>
				
				<div class="form-group mb-2 row">
					<label class="col-sm-2 col-form-label">Email</label>
					<input type="email" name="uemail" class="form-control border-primary" value="<c:out value='${pt.email }'/>">
				</div>
				
				<div class="form-group mb-2 row">
					<label class="col-sm-2 col-form-label">Age</label>
					<input type="number" name="uage" class="form-control border-primary" value="<c:out value='${pt.age }'/>">
				</div>
				
				<div class="form-group mb-2 row">
					<label class="col-sm-2 col-form-label">City</label>
					<input type="text" name="ucity" class="form-control border-primary" value="<c:out value='${pt.city }'/>">
				</div>
				
				<div class="form-group mb-2 row">
					<label class="col-sm-2 col-form-label">Gender</label>
					<input type="text" name="ugender" class="form-control border-primary" value="<c:out value='${pt.gender }'/>">
				</div>
				
				<div class="form-group mb-2 row">
					<input type="submit" class="btn btn-warning" value="Update Patient">
				</div>
			</form>
		</div>
	</main>
	
	<footer class="fixed-bottom bg-primary">
		<p class="text-center text-light">2024 &copy; Krishan Ranaweera</p>
	</footer>
</body>
</html>