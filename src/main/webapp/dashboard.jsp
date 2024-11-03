<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
      if(session.getAttribute("doctor")==null){
    	  response.sendRedirect("index.jsp");
      }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page </title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
	<header class="navbar navbar-dark bg-primary">
		<div>
			<a href="./index.jsp" class="navbar-brand mx-2">HMS</a>
		</div>
		
		<ul class="navbar-nav">
			<li>
				<a href="logout" class="nav-link mx-2">Doctor Logout</a>
			</li>
		</ul>
	</header>

	<main style="margin-top:2%" class="mx-5">
		<div class="row">
			<div class="container">
				<h3 class="text-start mx-2">Welcome to Doctor Dashboard</h3>
			</div>
			
			<div class="text-start">
				<a href="insert.jsp" class="btn btn-primary btn-sm mx-2">Add New Patient</a>
			</div>
			
			<table class="table mt-2">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Age</th>
						<th>City</th>
						<th>Gender</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pts" items="${pts }">
						<tr>
							<td><c:out value="${pts.id }"></c:out></td>
							<td><c:out value="${pts.name }"></c:out></td>
							<td><c:out value="${pts.email }"></c:out></td>
							<td><c:out value="${pts.age }"></c:out></td>
							<td><c:out value="${pts.city }"></c:out></td>
							<td><c:out value="${pts.gender }"></c:out></td>
							<td>
								<a href="update?id=<c:out value='${pts.id }'/>" class="btn btn-success btn-sm">Update</a>
								<a href="delete?id=<c:out value='${pts.id }'/>" class="btn btn-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</main>
	
	<footer class="fixed-bottom bg-primary">
		<p class="text-center text-light">2024 &copy; Krishan Ranaweera</p>
	</footer>
</body>
</html>