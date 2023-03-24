<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<title>Cadastro de Album</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

	<div class="container">
		<form action="/album/incluir" method="post">
			<div class="form-group">
				<label>Nome:</label> <input type="text" name="nome"
					value="Powerslave" class="form-control">
			</div>
			<div class="form-group">
				<label>Duração:</label> <input type="number" name="duracao"
					value="51" class="form-control">
			</div>
			<div class="form-group">
				<label>Ano de Gravação:</label> <input type="number"
					name="anoDeGravacao" value="1984" class="form-control">
			</div>
			<div class="form-group">
				<label>Numero de Musicas:</label> <input type="number"
					name="numeroDeMusicas" value="19" class="form-control">
			</div>
			<div class="form-group">
				<label>Tipo:</label> <input type="text" name="tipo" value="LP"
					class="form-control">
			</div>
			<div class="form-group">
				<label>Tempo de Conteudo Bonus:</label> <input type="number"
					name="tempoConteudoBonus" value="0" class="form-control">
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>