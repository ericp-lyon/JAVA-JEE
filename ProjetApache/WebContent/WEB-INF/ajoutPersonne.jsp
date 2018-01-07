
<%@ page import="beans.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ include file="menu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout Personne</title>
</head>
<body>

	<form method="post"
		action="http://localhost:8080/ProjetApache/personne/ajout">
		<div>Formulaire d’ajout d’une Personne</div>
		

		<div>
			<label for="nom">Nom *</label> <input type="text" id="nom" name="nom"
				value="${nomSaisi}" />${nomIncorrect}</div>
	
		<div>
			<label for="prenom">Prenom *</label> <input type="text" id="prenom"
				name="prenom" value="${prenomSaisi}" />${prenomIncorrect}</div>
	<input type="submit" value="Ajout" class="sansLabel" />

	</form>


</body>
</html>