<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/AjoutAmiServlet">
		<label for="login">Login</label>
			<input type="text" class="form-control" id="login" name="login">
			<br>
			
			<button type="submit">Ajouter</button>
	</form>
</body>
</html>