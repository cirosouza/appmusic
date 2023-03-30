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

	<div class="form-group">
		<label>CEP:</label> <input type="text" name="cep" value="${endereco.cep}" class="form-control">
	</div>
	<div class="form-group">
		<label>Logradouro:</label> <input type="text" value="${endereco.logradouro}" name="logradouro"
			class="form-control">
	</div>
	<div class="form-group">
		<label>Complemento:</label> <input type="text" value="${endereco.complemento}" name="complemento"
			class="form-control">
	</div>
		<div class="form-group">
		<label>Bairro:</label> <input type="text" value="${endereco.bairro}" name="bairro"
			class="form-control">
	</div>
	<div class="form-group">
		<label>Localidade:</label> <input type="text" value="${endereco.localidade}" name="localidade"
			class="form-control">
	</div>
	<div class="form-group">
		<label>UF:</label> <input type="text" name="uf" value="${endereco.uf}" class="form-control">
	</div>

</body>
</html>