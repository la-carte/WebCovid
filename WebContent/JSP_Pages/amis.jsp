<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Mes amis</title>
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
		Votre liste d'amis
		<ul>
			<%
				for (int i = 0; i < current_user.getFriends().size(); i++) {
			%>
			<li><%=current_user.getFriends().get(i).getLogin()%></li>
			<%
				}
			%>
		</ul>
		Vos requêtes d'amis
		<%
			for (int i = 0; i < current_user.getFriendsRequest().size(); i++) {
		%>
		<form method="post"
			action="${pageContext.request.contextPath}/AcceptFriendServlet">
			<label for="login"><ul>
					<li><%=current_user.getFriendsRequest().get(i)%></li>
				</ul></label> <input type="hidden" id="login" name="login" value="<%=current_user.getFriendsRequest().get(i)%>">
			<button type="submit" class="btn btn-primary">Accepter</button>
		</form>
		<form method="post"
			action="${pageContext.request.contextPath}/RefuseFriendServlet">
			<button type="submit" class="btn btn-danger">Refuser</button>
		</form>
		<%
			}
		%>
	</div>
</body>
</html>