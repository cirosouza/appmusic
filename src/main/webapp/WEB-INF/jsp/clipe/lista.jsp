<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>AppMusic</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

	<div class="container">

		<h3>Listagem de Clipes</h3>

		<form action="/clipe/cadastro">
			<input type="submit" value="Novo" />
		</form>


		<c:if test="${not empty clipe }">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${empty clipes }">
			<h5>Não existem clipes cadastrados!</h5>
		</c:if>

		<c:if test="${not empty clipes }">
			<h5>Quantidade de clipes cadastrados: ${clipes.size()}</h5>
		</c:if>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Duração</th>
					<th>Ano de Gravação</th>
					<th>Diretor</th>
					<th>Link do Vídeo</th>
					<th>Nº de Figurantes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${clipes}">
					<tr>
						<td>${c.id }</td>
						<td>${c.nome }</td>
						<td>${c.duracao }</td>
						<td>${c.anoDeGravacao }</td>
						<td>${c.diretor }</td>
						<td><a href="${c.linkVideo }">link</a></td>
						<td>${c.numeroDeAtoresFigurantes }</td>
						<th><a href="/clipe/${c.id }/excluir">excluir</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>