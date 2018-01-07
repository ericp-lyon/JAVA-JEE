
<%@ page import="beans.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>


	<div>
		<h3>Bonjour, ${sessionScope.user}</h3>
	</div>
	<br>

	<form method="get"
		action="http://localhost:8080/ProjetApache/personne/ajout">
		<div>
			<input type="submit" value="Ajouter" class="sansLabel" />
		</div>
		<br>
		</form>
		
		<form method="get"
			action="http://localhost:8080/ProjetApache/personne/modif">
			<div>
				<input type="submit" value="Modifier" class="sansLabel" />
			</div>
			<br>
			</form>
			<form method="get"
				action="http://localhost:8080/ProjetApache/personne/suppr">
				<div>
					<input type="submit" value="Supprimer" class="sansLabel" />
				</div>
				<br>
				</form>
</body>
</html>