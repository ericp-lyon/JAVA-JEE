<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ include file="menu.jsp"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un client</title>
</head>
<body>

	<div>
		<h2>Ajouter un client</h2>
		<form method="post"
			action="http://localhost:8080/JEECommande/ajoutclient">
			<div>
				<label for="nomClient">Nom du client :</label> <input type="text"
					id="nomClient" name="nomClient" value="${nomSaisi}" />
			</div>
			<br>

			<div>
				<label for="prenomClient">Prénom du client :</label> <input
					type="text" id="prenomClient" name="prenomClient"
					value="${prenomUSaisi}" />
			</div>
			<br>

			<div>
				<input type="submit" value="Ajouter" class="sansLabel" />
			</div>
			<br>
		</form>

	</div>

</body>
</html>