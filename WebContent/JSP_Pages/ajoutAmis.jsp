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
	<br>
<form method="post" action="${pageContext.request.contextPath}/AjoutAmiServlet">
		<label for="login">Login</label>
			<input type="text" class="form" id="login" name="login">
			
			<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>