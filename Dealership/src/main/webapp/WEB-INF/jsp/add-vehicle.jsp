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
				<h3 class="masthead-brand">Add Vehicle</h3>
				<!--<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="/sign-up">Add Vehicle</a> <a class="nav-link"
						href="/login">Login</a> <a class="nav-link" href="#">Contact</a>
				</nav>-->
			</div>
		</header>

		<main role="main" class="inner cover">
			<form:form modelAttribute="vehicle" action="addVehicle" method="post">
				<div class="form-group col-md-6">
					<label for="inputName">Year</label>
					<form:input path="year" type="text" class="form-control" id="intputMake" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Make</label>
					<form:input path="make" type="text" class="form-control" id="intputMake" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Model</label>
					<form:input path="model" type="text" class="form-control" id="intputModel" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Description</label>
					<form:input path="description" type="text" class="form-control" id="intputDescription" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Age of Vehicle</label>
					<form:input path="age" type="date" class="form-control" id="intputDescription" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Price</label>
					<form:input path="price" type="number" class="form-control" id="intputDescription" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputName">Picture</label>
					<form:input path="pictureUrl" type="text" class="form-control" id="intputDescription" />
				</div>
				<form:button type="submit" class="btn btn-primary">Submit</form:button>
			</form:form>
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
