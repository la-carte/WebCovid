<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
</head>
<body>
	<h1>You are logged in Admin !</h1>

	<form method="post"
		action="${pageContext.request.contextPath}/JSP_Pages/profil.jsp">
		<button type="submit">Mon profil</button>
	</form>
	<form method="post"
		action="${pageContext.request.contextPath}/DeconnexionServlet">
		<button type="submit">Deconnexion</button>
	</form>
</body>
</html>