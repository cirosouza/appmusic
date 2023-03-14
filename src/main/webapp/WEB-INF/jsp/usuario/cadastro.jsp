<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
<title>Cadastro de Usuário</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

	<div class="container">
		<form action="usuario/incluir" method="post">
			<div class="form-group">
				<label>Nome:</label> <input type="text" name="nome"
					value="Ciro Maia" class="form-control">
			</div>
			<div class="form-group">
				<label>Senha:</label> <input type="password" name="senha"
					value="ciro@gmail.com.br" class="form-control">
			</div>
			<div class="form-group">
				<label>E-mail:</label> <input type="email" name="email"
					value="ciro@gmail.com.br" class="form-control">
			</div>
			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>