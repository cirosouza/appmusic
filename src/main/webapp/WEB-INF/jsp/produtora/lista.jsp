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

		<h3>Listagem de Produtoras</h3>

		<form action="/produtora">
			<input type="submit" value="Novo" />
		</form>


		<c:if test="${not empty mensagem }">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${empty produtoras }">
			<h5>Não existem produtoras cadastrados!</h5>
		</c:if>

		<c:if test="${not empty produtoras }">
			<h5>Quantidade de produtoras cadastradas: ${produtoras.size()}</h5>
		</c:if>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Pais</th>
					<th>Ano de Criacao</th>
					<th>Artistas</th>
					<th>Midias</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${produtoras}">
					<tr>
						<td>${p.id }</td>
						<td>${p.nome }</td>
						<td>${p.pais }</td>
						<td>${p.anoDeCriacao }</td>
						<td>${p.artista.nome }</td>
						<td>${p.midias.size() }</td>
						<th><a href="/produtora/${p.id }/excluir">excluir</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>