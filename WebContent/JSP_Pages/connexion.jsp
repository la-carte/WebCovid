<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/ConnexionServlet">
		<label for="login">Login</label>
			<input type="text" class="form-control" id="login" name="login">
			<br>
		
			<label for="password">Password</label>
			<input type="text" class="fort-control" id="password" name="password">
			<br>
			
			<button type="submit">Submit</button>
	</form>
</body>
</html>