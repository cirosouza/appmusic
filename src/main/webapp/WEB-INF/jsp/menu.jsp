<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">AppMusic</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<c:if test="${not empty usuario}">
				<li><a href="/usuario/lista">Usuario</a></li>
				<li><a href="/artista/lista">Artista</a></li>
				<li><a href="/midia/lista">Mídia</a></li>
				<li><a href="/album/lista">Album</a></li>
				<li><a href="/clipe/lista">Clipe</a></li>
				<li><a href="/show/lista">Show Gravado</a></li>
				<li><a href="/produtora/lista">Produtora</a></li>
			</c:if>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty usuario}">
				<li><a href="/usuario"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
			<c:if test="${not empty usuario}">
				<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>
						Logout, ${usuario.nome}</a></li>
			</c:if>
		</ul>
	</div>
</nav>