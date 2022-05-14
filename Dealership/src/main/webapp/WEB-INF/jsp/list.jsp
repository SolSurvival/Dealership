<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>Student Portal</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/cover/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="cover.css" rel="stylesheet">
</head>


<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Vehicle Inventory</h3>
				<!--<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="/sign-up">Sign Up</a> <a class="nav-link"
						href="/login">Login</a> <a class="nav-link" href="#">Contact</a>
				</nav>-->
			</div>
		</header>

		<main role="main" class="inner cover">
			<h1 class="cover-heading">Vehicle Inventory, Hello<c:if test="${person.fullName != null}"> ${person.fullName}</c:if></h1>
			<table>
			<form:form action="profile" method="get">
			  <tr>
			    <th>Make</th>
			    <th>Model</th>
			    <th>Year</th>
			    <th>Description</th>
			    <th>Days On The Lot</th>
			    <th>Vehicle Profile Link</th>
			  </tr>
				<c:forEach var="vehicle" items="${vehicleInventory}">
		          <tr>
				    <td>${vehicle.make}</td>
				    <td>${vehicle.model}</td>
				    <td>${vehicle.year}</td>
				    <td>${vehicle.description}</td>
				    <td>${vehicle.daysOnLot}</td>
				    <td>
				    	<c:choose>
						    <c:when test="${person.id != null}">
						        <a type="submit" href="/profile/${person.id}?vehicleId=${vehicle.id}">SEE PROFILE</a>
						    </c:when>    
						    <c:otherwise>
						        <a type="submit" href="/profile?vehicleId=${vehicle.id}">SEE PROFILE</a>
						    </c:otherwise>
						</c:choose>
				    </td>
				  </tr> 
	            </c:forEach>
			    </form:form>
			</table>
		</main>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>
					Cover template for <a href="https://getbootstrap.com/">Bootstrap</a>,
					by <a href="https://twitter.com/mdo">@mdo</a>.
				</p>
			</div>
		</footer>
	</div>


</body>

</html>
