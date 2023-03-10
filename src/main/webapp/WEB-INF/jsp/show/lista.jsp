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

		<h3>Listagem de Shows</h3>

		<form action="/show/cadastro">
			<input type="submit" value="Novo" />
		</form>


		<c:if test="${not empty show }">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${empty shows }">
			<h5>Não existem shows cadastrados!</h5>
		</c:if>

		<c:if test="${not empty shows }">
			<h5>Quantidade de show cadastrados: ${shows.size()}</h5>
		</c:if>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Duração</th>
					<th>Ano de Gravação</th>
					<th>Local de Gravação</th>
					<th>Nº Músicas</th>
					<th>Produção</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${shows}">
					<tr>
						<td>${s.id }</td>
						<td>${s.nome }</td>
						<td>${s.duracao }</td>
						<td>${s.anoDeGravacao }</td>
						<td>${s.localDeGravacao }</td>
						<td>${s.numeroDeMusicasPerformadas }</td>
						<td>${s.producao }</td>
						<th><a href="/show/${s.id }/excluir">excluir</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>