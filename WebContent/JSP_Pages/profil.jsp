<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>profil</title>
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
	<div class="container">
		<h1>Bienvenue sur votre profil !</h1>

		Login :
		<%=current_user.getLogin()%><br> Mot de passe :
		<%=current_user.getPassword()%><br> Nom :
		<%=current_user.getNom()%><br> Prénom :
		<%=current_user.getPrenom()%><br> Date de Naissance :
		<%=current_user.getDate()%><br>

		<form method="post"
			action="${pageContext.request.contextPath}/JSP_Pages/modificationProfil.jsp">
			<button type="submit">Modifier le profil</button>
		</form>
		<form method="post"
			action="${pageContext.request.contextPath}/JSP_Pages/ajoutAmis.jsp">
			<button type="submit">Ajouter des amis</button>
		</form>
		<form method="post"
			action="${pageContext.request.contextPath}/NotificationCovidServlet">
			<button type="submit" class="btn btn-danger">J'ai la
				Covid-19</button>
		</form>
		<form method="post"
			action="${pageContext.request.contextPath}/JSP_Pages/amis.jsp">
			<button type="submit">Mes amis</button>
		</form>
		<form method="post"
			action="${pageContext.request.contextPath}/JSP_Pages/activite.jsp">
			<button type="submit">Mes activités</button>
		</form>
		<%
			for (int i = 0; i < current_user.getFriends().size(); i++) {
		%>
		<%
			if (current_user.getFriends().get(i).isToCovid()== true) {
		%>
		<b>Attention ! un ami à vous à recemment eu la Covid-19, veuillez
			aller vous faire dépister !</b>
		<%
			}
		}
		%>
	</div>
</body>
</html>