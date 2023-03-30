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

		<form action="/album/cadastro">
			<input type="submit" value="Novo" />
		</form>


		<c:if test="${not empty mensagem }">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${empty albuns }">
			<h5>Não existem albuns cadastrados!</h5>
		</c:if>

		<c:if test="${not empty albuns }">
			<h5>Quantidade de albuns cadastrados: ${albuns.size()}</h5>
		</c:if>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Duração</th>
					<th>Ano de Gravação</th>
					<th>Número de Músicas</th>
					<th>Tipo</th>
					<th>Tempo de Conteudo Bonus</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="alb" items="${albuns }">
					<tr>
						<td>${alb.id }</td>
						<td>${alb.nome }</td>
						<td>${alb.duracao }</td>
						<td>${alb.anoDeGravacao }</td>
						<td>${alb.numeroDeMusicas }</td>
						<td>${alb.tipo }</td>
						<td>${alb.tempoConteudoBonus }</td>
						<th><a href="/album/${alb.id }/excluir">excluir</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>