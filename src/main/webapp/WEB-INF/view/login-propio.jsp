<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<style>
			.formatoError{
				color:red;
			}
		</style>
	</head>
	<body>
		<h2 style="text-align:center">Página de login</h2>
		<form:form action="${pageContext.request.contextPath}/authenticacionUsuario" method="POST">
			<p>
				Usuario: <input type="text" name="username"/>
			</p>
			<p>
				Contraseña: <input type="password" name="password"/>
			</p>
			<p>
				<input type="submit" name="Entrar"/>
			</p>
			<c:if test="${param.error!=null}">
				<strong class="formatoError">Usuario o contraseña incorrectos</strong>
			</c:if>
		</form:form>
	</body>
</html>