<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Cadastro de Produtoras</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

	<div class="container">
		<form action="/produtora/incluir" method="post">
			<div class="form-group">
				<label>Nome:</label> <input type="text" name="nome"
					value="EMI Group" class="form-control">
			</div>
			<div class="form-group">
				<label>Pais:</label> <input type="text" name="pais"
					value="Reino Unido" class="form-control">
			</div>
			<div class="form-group">
				<label>Ano de Cria��o:</label> <input type="number"
					name="anoDeCriacao" value="1931" class="form-control">
			</div>

			<div class="form-group">
				<label>Artista:</label> <select name="artista"
					class="form-control">
					<c:forEach var="a" items="${artistas}">
						<option value="${a.id}">${a.nome}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label>Midias:</label>
				<c:forEach var="m" items="${midias}">
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							name="midias" value="${m.id}" class="form-check-input">
							${m.nome}
						</label>
					</div>
				</c:forEach>
			</div>
			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>