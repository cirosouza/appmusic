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

		<h3>Listagem de Artistas</h3>

		<form action="/artista/cadastro">
            <input type="submit" value="Novo" />
        </form>


		<c:if test="${not empty artista }">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

	<c:if test="${empty artistas }">
		<h5>Não existem artistas cadastrados!</h5>
	</c:if>

	<c:if test="${not empty artistas }">
		<h5>Quantidade de artistas cadastrados: ${artistas.size()}</h5>
	</c:if>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Ano de Origem</th>
				<th>Tipo</th>
				<th>Ativo</th>
				<th>Usuario</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${artistas }">
				<tr>
					<td>${a.id }</td>
					<td>${a.nome }</td>
					<td>${a.anoDeOrigem }</td>
					<td>${a.tipo }</td>
					<td>${a.isAtivo() }</td>
					<td>${a.usuario.nome}</td>
					<th><a href="/artista/${a.id }/excluir">excluir</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>