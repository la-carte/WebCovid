<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes amis</title>
</head>
<body>
	<jsp:useBean id="current_user" class="BeanPackage.UserBean"
		scope="session" />


	<%
	
	%>

	Votre liste d'amis
	<ul>
		<%
			for (int i = 0; i < current_user.getFriends().size(); i++) {
		%>
		<li><%=current_user.getFriends().get(i)%></li>
		<%
			}
		%>
	</ul>
	Vos requêtes d'amis
	<ul>
		<%
			for (int i = 0; i < current_user.getFriendsRequest().size(); i++) {
		%>
		<li><%=current_user.getFriendsRequest().get(i)%></li>
		<form method="post"
			action="${pageContext.request.contextPath}/AcceptFriend">
			<button type="submit">Accepter</button>
		</form>
		<form method="post"
			action="${pageContext.request.contextPath}/RefuseFriend">
			<button type="submit">Refuser</button>
		</form>
		<%
			}
		%>
	</ul>

</body>
</html>