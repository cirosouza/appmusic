<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<title>Cadastro de Shows</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

	<div class="container">
		<form action="/show/incluir" method="post">
			<div class="form-group">
				<label>Nome:</label> <input type="text" name="nome"
					value="Iron Maiden Rock in Rio" class="form-control">
			</div>
			<div class="form-group">
				<label>Duração:</label> <input type="number" name="duracao"
					value="120" class="form-control">
			</div>
			<div class="form-group">
				<label>Ano de Gravação:</label> <input type="number"
					name="anoDeGravacao" value="2002" class="form-control">
			</div>
			<div class="form-group">
				<label>Local de Gravação:</label> <input type="text"
					name="localDeGravacao" value="Rio de Janeiro" class="form-control">
			</div>

			<div class="form-group">
				<label>Nº Músicas:</label> <input type="number" name="numeroDeMusicasPerformadas"
					value="19" class="form-control">
			</div>

			<div class="form-group">
				<label>Produção:</label> <input type="text"
					name="producao" value="Kevin Shirley" class="form-control">
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>