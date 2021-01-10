<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>404</title>
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
					<%
						if (current_user.getLogin() == null) {
					%>
					<a class="nav-link active" aria-current="page" href="connexion.jsp">Connexion</a>
					<%
						}
					%>
					<%
						if (current_user.getLogin() != null) {
					%>
					<a class="nav-link active" aria-current="page"
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
<h1>Ahhhhhhhhhhhhhhh! This page doesn't exist </h1>

<p> Not to worry. You can either headback to our homepage, or sit there and listen to a goat scream like a human.</p>

<iframe width="560" height="315" src="https://www.youtube.com/embed/jRxSRyrTANY?start=3" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</body>
</html>