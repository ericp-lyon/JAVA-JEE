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
		<h3>Bonjour ${sessionScope.nomOk},votre mot de passe est
			${sessionScope.mdpOk}.</h3>
		<h4>Sur quel support souhaitez vous travailler?</h4>

	</div>
	<br>

	<div>
		Article:
		<form method="get"
			action="http://localhost:8080/JEECommande/ajoutarticle">
			<%--  appel la vue pour affichage--%>
			<input type="submit" value="ajout" class="sansLabel" />
		</form>
		<form method="get"
			action="http://localhost:8080/JEECommande/supprimerarticle">
			<input type="submit" value="supprimer" class="sansLabel" />
		</form>
		<br>

	</div>

	<div>
		Commande:
		<form method="get"
			action="http://localhost:8080/JEECommande/commandemenu">

			<input type="submit" value="ajout" class="sansLabel" />
		</form>
		<form method="get"
			action="http://localhost:8080/JEECommande/supprimercommande">
			<input type="submit" value="supprimer" class="sansLabel" />
		</form>
	</div>
	<br>



	<div>
		Client:
		<form method="get"
			action="http://localhost:8080/JEECommande/ajoutclient">
			<input type="submit" value="ajout" class="sansLabel" />
		</form>
		<form method="get"
			action="http://localhost:8080/JEECommande/supprimerclient">
			<input type="submit" value="supprimer" class="sansLabel" />
		</form>
	</div>
	<br>

	<div>
		Utilisateur:
		<form method="get" action="http://localhost:8080/JEECommande/deco">
			<input type="submit" value="Deconnexion" class="sansLabel" />
		</form>
	</div>

</body>
</html>