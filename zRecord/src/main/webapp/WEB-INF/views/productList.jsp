<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Carousel Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<!-- Bootstrap core CSS -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/main.css" rel="stylesheet">
<link href="./resources/css/carousel.css" rel="stylesheet">


</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="home">AZ Records</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="home">Home</a></li>
							<li><a href="productList">Product</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Dropdown <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="productList">product</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li><a href="#">One more separated link</a></li>
								</ul></li>
							<li style="float: right;"><a href="login">Login</a></li>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>


	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>All Products</h1>

				<p class="lead">Checkout all the awesome products available now!</p>
			</div>

			<table class="table table-striped table-hover">
				<thead>
					<tr class="bg-success">
						<th>Photo Thumb</th>
						<th>Product Name</th>
						<th>Category</th>
						<th>Condition</th>
						<th>Price</th>
					</tr>
				</thead>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><img src="#" alt="image" /></td>
						<td>${product.productName}</td>
						<td>${product.productCategory}</td>
						<td>${product.productCondition}</td>
						<td>${product.productPrice}USD</td>
					</tr>
				</c:forEach>
			</table>

			<!-- FOOTER -->
			<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>

			<p>
				&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot;
				<a href="#">Terms</a>
			</p>
			</footer>
		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
	<script>
		window.jQuery
				|| document
						.write('<script src="./resources/js/jquery-1.11.3.min.js"><\/script>')
	</script>
	<script src="./resources/js/bootstrap.min.js"></script>

	<!-- <script type=”text/javascript” src=”https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js”></script> -->

</body>
</html>