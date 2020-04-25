<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JackRev Company Home Page</title>
</head>
<body>
	<h1>JackRev Company Home Page</h1>
	<hr>
	<p>Welcome to the JackRev Company Page</p>

	<hr>
	<!-- display user name and role -->
	User :
	<security:authentication property="principal.username" />
	<br>
	<br> Role(s) :
	<security:authentication property="principal.authorities" />

	<hr>

	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to/leaders ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (Only for Manager peeps)
		</p>
	</security:authorize>


	<security:authorize access="hasRole('ADMIN')">

		<!-- Add a link to point to/systems ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				Meeting</a> (Only for Admin peeps)
		</p>
	</security:authorize>

	<hr>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>
</html>