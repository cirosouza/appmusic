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

		<h3>Listagem de Albuns</h3>

		<c:if test="${empty midias }">
			<h5>NÃo existem albuns cadastrados!</h5>
		</c:if>

		<c:if test="${not empty midias }">
			<h5>Quantidade de midias cadastrados: ${midias.size()}</h5>
		</c:if>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Duração</th>
					<th>Ano de Gravação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${midias }">
					<tr>
						<td>${m.id }</td>
						<td>${m.nome }</td>
						<td>${m.duracao }</td>
						<td>${m.anoDeGravacao }</td>
						<th><a href="/midia/${m.id }/excluir">excluir</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>