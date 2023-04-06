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

		<h3>Listagem de Usuários</h3>

		<c:if test="${not empty mensagem }">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>



		<c:if test="${empty usuarios }">
			<h5>Não existem usuários cadastrados!</h5>
		</c:if>

		<c:if test="${not empty usuarios }">
			<h5>Quantidade de usuarios cadastrados: ${usuarios.size()}</h5>
		</c:if>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Admin</th>
					<th>Endereço</th>
					<th>Artistas</th>
					<th>Midias</th>
					<th>Produtora</th>
					<c:if test="${usuario.admin }">
						<th></th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${usuarios }">
					<tr>
						<td>${u.id }</td>
						<td>${u.nome }</td>
						<td>${u.email }</td>
						<td>${u.admin }</td>
						<td>${u.endereco }</td>
						<td>${u.artistas.size() }</td>
						<td>${u.midias.size() }</td>
						<td>${u.produtoras.size() }</td>
						<c:if test="${usuario.admin && !u.admin}">
							<th><a href="/usuario/${u.id }/excluir">excluir</a></th>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>