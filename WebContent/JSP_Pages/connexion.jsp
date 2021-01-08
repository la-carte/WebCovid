<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<jsp:useBean id="current_user" class="BeanPackage.UserBean"
		scope="session" />
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link active" aria-current="page" href="accueil.jsp">Accueil</a>
					<a class="nav-link active" aria-current="page"
					<%if(current_user == null){ %>
						href="${pageContext.request.contextPath}/DeconnexionServlet">Deconnexion</a>
						<%} %>
					<a class="nav-link"></a>
				</div>
			</div>
		</div>
	</nav>
	<div class="container">
	<div class="row" style="margin-top: 30px">
		<div class="col-md-12">
			<h1>Identifiez Vous</h1>
		</div>
	</div>
	<div class="row" style="margin-top: 30px">
		<div class="col-md-12">
			<form method="post"
				action="${pageContext.request.contextPath}/ConnexionServlet">
				<div class="form-group">
					<label for="login">Login </label> <input type="text"
						class="form" id="login" name="login"
						placeholder="Enter your login">
				</div>

				<div class="form-group">
					<label for="password">Password </label> <input type="password"
						class="form" id="password" name="password"
						placeholder="Enter your password">
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-danger">Reset</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>