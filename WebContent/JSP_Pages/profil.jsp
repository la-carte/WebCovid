<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profil</title>
</head>
<body>
<h1>Bienvenue sur votre profil ! </h1>

<jsp:useBean id="current_user" class="BeanPackage.UserBean" scope="session"/>
Login : <%= current_user.getLogin() %><br>

Mot de passe : <%= current_user.getPassword() %><br>

Nom : <%= current_user.getNom() %><br>

Prénom : <%= current_user.getPrenom() %><br>

Date de Naissance : <%= current_user.getDate() %><br>

<form method="post" action="${pageContext.request.contextPath}/JSP_Pages/modificationProfil.jsp">
		<button type="submit">Modifier le profil</button>
</form>
<form method="post" action="${pageContext.request.contextPath}/DeconnexionServlet">
		<button type="submit">Deconnexion</button>
</form>

</body>
</html>