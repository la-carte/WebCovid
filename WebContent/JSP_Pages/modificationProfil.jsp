<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="current_user" class="BeanPackage.UserBean" scope="session"/>
<form method="post" action="${pageContext.request.contextPath}/ModificationServlet">
		<label for="login">Login</label>
			<input type="text" class="form-control" id="login" name="login" value="<%=current_user.getLogin() %>">
			<br>
		
			<label for="password">Password</label>
			<input type="text" class="fort-control" id="password" name="password" value="<%=current_user.getPassword() %>">
			<br>
		
			<label for="name">Name</label>
			<input type="text" class="fort-control" id="name" name="name" value="<%=current_user.getNom() %>">
			<br>
		
			<label for="surname">Surname</label>
			<input type="text" class="fort-control" id="surname" name="surname" value="<%=current_user.getPrenom() %>">
			<br>
		
			<label for="password">Date of Birth</label>
			<input type="date" class="fort-control" id="date" name="date" value="<%=current_user.getDate() %>">
			<br>
		
			<button type="submit">Submit</button>
	</form>
			
	<form method="post" action="${pageContext.request.contextPath}/JSP_Pages/profil.jsp">
		<button type="submit">Modifier</button>
	</form>
</body>
</html>