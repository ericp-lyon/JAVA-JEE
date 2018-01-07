<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>

<div>
		<h3> Bonjour, veuillez vous identifier:</h3>
		<h4>${sessionko}</h4>
	</div>
	<div>
		<form method="post"
			action="http://localhost:8080/JEECommande/accueiluser">

			<label for="nom">Nom :</label> <input type="text" id="nom" name="nom"
				value="${nomSaisi}" /> <label for="mdp">Mot de passe</label> <input
				type="password" id="mdp" name="mdp" value="${mdpSaisi}" /> <input
				type="submit" value="soumettre" class="sanslabel" />
		</form>
		

	</div>


</body>
</html>