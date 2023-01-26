<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bienvenido</title>
	</head>
	<body>
		<h1>Bienvenido</h1>
		<hr>
		<h3>Hemos llegado</h3>
		
		<p>
			Usuario: <security:authentication property="principal.username"/>
			<br/>
			<br/>
			Rol: <security:authentication property="principal.authorities"/>
		</p>
		<br/>
		<!-- link para administradores -->
		<security:authorize access="hasRole('ADMINISTRADOR')">
		<p>
			<a href="${pageContext.request.contextPath}/administradores">Ir a zona de administradores</a>
		</p>
		</security:authorize>
		<!-- link para ayudantes -->
		
		<security:authorize access="hasRole('AYUDANTE')">
		<p>
			<a href="${pageContext.request.contextPath}/ayudantes">Ir a zona de ayudantes</a>
		</p>
		</security:authorize>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout"/>
		</form:form>
	</body>
</html>