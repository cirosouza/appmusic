<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>AppMusic</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

	<div class="container">

		<h1>Projeto de Bloco</h1>

		<p>O sistema AppMusic é um repositório para registrar e persistir
			em banco de dados registros de produções audiovisuais de artistas
			musicais, oferecendo a possibilidade de associar as mídias ao artista
			que compôs e executou o material e à gravadora/produtora que realizou
			a produção do produto. A aplicação possui telas para listagem e
			cadastro de todas as entidades e um botão para excluir as entidades
			específicas na visão de lista.</p>

	</div>
</body>
</html>