<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<title>Cadastro de Artista</title>
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
				<label>Ano de Origem:</label> <input type="number"
					name="anodeorigem" value="ciro@gmail.com.br" class="form-control">
			</div>
			<div class="form-group">
				<label>Tipo:</label> <input type="email" name="senha"
					value="ciro@gmail.com.br" class="form-control">
			</div>
			<div class="form-group">
				<label>Em atividade:</label> <select name="setor"
					class="form-control">
					<option value="true">Sim</option>
					<option value="false">Não</option>
					</select>
			</div>
			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>