<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
						<%if(current_user != null){ %>
						href="${pageContext.request.contextPath}/DeconnexionServlet">Deconnexion</a>
					<a class="nav-link active" aria-current="page"
						href="${pageContext.request.contextPath}/JSP_Pages/profil.jsp">Profil</a>
					<%
						}
					%>
					<a class="nav-link"></a>
				</div>
			</div>
		</div>
	</nav>
<div class="row" style="margin-top: 60px">
		<div class="col-md-12"></div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<form method="post"
				action="${pageContext.request.contextPath}/ModificationServlet">
				<div class="form">
					<label for="login">Login</label> <input type="text"
						class="form" id="login" name="login"
						placeholder="Enter a login">
				</div>
				<br>
				<div class="form">
					<label for="password">Password</label> <input type="password"
						class="form" id="password" name="password"
						placeholder="Enter password">
				</div>
				<br>
				<div class="form-group">
					<label for="name">Name</label> <input type="text"
						class="form" id="name" name="name"
						placeholder="Enter name">
				</div>
				<br>
				<div class="form-group">
					<label for="surname">Surname</label> <input type="text"
						class="form" id="surname" name="surname"
						placeholder="Enter surname">
				</div>
				<br>
				<div class="form-group">
					<label for="date">Date of Birth</label> <input type="date"
						class="form" id="date" name="date">
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