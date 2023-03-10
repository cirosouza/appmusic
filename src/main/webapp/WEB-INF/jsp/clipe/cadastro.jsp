<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<title>Cadastro de Clipe</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

	<div class="container">
		<form action="/clipe/incluir" method="post">
			<div class="form-group">
				<label>Nome:</label> <input type="text" name="nome"
					value="Wasted Years" class="form-control">
			</div>
			<div class="form-group">
				<label>Duração:</label> <input type="number" name="duracao"
					value="5" class="form-control">
			</div>
			<div class="form-group">
				<label>Ano de Gravação:</label> <input type="number"
					name="anoDeGravacao" value="2015" class="form-control">
			</div>
			<div class="form-group">
				<label>Diretor:</label> <input type="text"
					name="diretor" value="Adrian Smith" class="form-control">
			</div>

			<div class="form-group">
				<label>Link do Vídeo:</label> <input type="text" name="linkVideo"
					value="https://www.youtube.com/watch?v=Ij99dud8-0A" class="form-control">
			</div>

			<div class="form-group">
				<label>Nº de Figurantes:</label> <input type="number"
					name="numeroDeAtoresFigurantes" value="0" class="form-control">
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>