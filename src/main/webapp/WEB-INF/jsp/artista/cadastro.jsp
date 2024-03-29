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
		<form action="/artista/incluir" method="post">
			<div class="form-group">
				<label>Nome:</label> <input type="text" name="nome"
					value="IronMaiden" class="form-control">
			</div>
			<div class="form-group">
				<label>Ano de Origem:</label> <input type="number"
					name="anoDeOrigem" value="1979" class="form-control">
			</div>
			<div class="form-group">
				<label>Tipo:</label> <input type="text" name="tipo"
					value="banda" class="form-control">
			</div>
			<div class="form-group">
				<label>Em atividade:</label> <select name="ativo"
					class="form-control">
					<option value="true">Sim</option>
					<option value="false">N�o</option>
					</select>
			</div>
			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>