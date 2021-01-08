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
	<div class="container">
		<p>Mes activités :</p>
		<br>
		<ul>
			<%
				for (int i = 0; i < current_user.getActivities().size(); i++) {
			%>
			<li><%=current_user.getActivities().get(i).getName()%></li>
			<li><%=current_user.getActivities().get(i).getDate()%></li>
			<li><%=current_user.getActivities().get(i).getHdebut()%></li>
			<li><%=current_user.getActivities().get(i).getHfin()%></li>
			<br>
			<%
				}
			%>
		</ul>
		<form method="post"
			action="${pageContext.request.contextPath}/JSP_Pages/newActivité.jsp">
			<button type="submit" class="btn btn-primary">Ajouter une activité</button>
		</form>
	</div>
</body>
</html>