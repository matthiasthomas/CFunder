<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="#">

<title>CFunder</title>

<!-- CSS
    ================================================== -->
<link
	href="${pageContext.request.contextPath}/css/font/font-awesome.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/lib/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">

<h1>
	<%
		if (request.getAttribute("Error") != null) {
	%>
	<%=request.getAttribute("Error")%>
	<%
		}
	%>
</h1>
</head>
<!-- NAVBAR
    ================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">
			<div class="navbar navbar-inverse navbar-static-top"
				role="navigation">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><img
							src="${pageContext.request.contextPath}/css/img/logo.png"></a>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
							<li><a href="${pageContext.request.contextPath}/projects">Projects</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Category <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">Music</a></li>
									<li><a href="#">High Tech</a></li>
									<li><a href="#">Category2</a></li>
									<li><a href="#">Category3</a></li>
									<li><a href="#">Category4</a></li>
								</ul></li>
							<li><a data-toggle="modal" data-target="#modalLogin">Log
									in</a></li>
							<li><a href="${pageContext.request.contextPath}/user/register">Register</a></li>
							<li><a href="${pageContext.request.contextPath}/user/login">Login</a></li>
							<li><a href="${pageContext.request.contextPath}/user/logout">Logout</a>
						</ul>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">
								<i class="fa fa-search"></i>
							</button>
						</form>
					</div>

				</div>
			</div>

		</div>
	</div>
	<!-- /.navbar -->


	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img src="${pageContext.request.contextPath}/css/img/caroussel1.jpg"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Welcome to Sup Crowdfunder</h1>
						<p>"A way for every creative person to control their destiny"
						</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Register
								today</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/css/img/caroussel2.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Discover Projects</h1>
						<p>Passion, ideas, and ambition abound. Start exploring!</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Explore
								projects</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.carousel -->
	<div class="container marketing">