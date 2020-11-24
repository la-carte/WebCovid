<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil du site Covid </title>
</head>
<body>
	<h1>Bienvenue sur le site web Covid</h1>
	
	
	<form method="post" action="${pageContext.request.contextPath}/InscriptionServlet">
		<label for="login">Login</label>
			<input type="text" class="form-control" id="login" name="login">
			<br>
		
			<label for="password">Password</label>
			<input type="text" class="fort-control" id="password" name="password">
			<br>
		
			<label for="name">Name</label>
			<input type="text" class="fort-control" id="name" name="name">
			<br>
		
			<label for="surname">Surname</label>
			<input type="text" class="fort-control" id="surname" name="surname">
			<br>
		
			<label for="password">Date of Birth</label>
			<input type="date" class="fort-control" id="date" name="date">
			<br>
		
			<button type="submit">Submit</button>
	</form>
			
	<form method="post" action="${pageContext.request.contextPath}/JSP_Pages/connexion.jsp">
		<button type="submit">Se connecter</button>
	</form>

</body>
</html>