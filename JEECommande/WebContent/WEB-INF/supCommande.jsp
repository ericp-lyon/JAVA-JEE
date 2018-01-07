<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="menu.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supprimer une commande</title>
</head>
<body>

<div>
		<h2>Supprimer une commande</h2>
		<form method="post"
			action="http://localhost:8080/JEECommande/supprimercommande">
			<div>
				<label for="date">Date :</label> <input type="text" id="date"
					name="date" value="${dateSaisi}" />
			</div>

			<div>
				<label for="client">Client :</label> <input type="text" id="client"
					name="client" value="${clientSelect}" />
			</div>
			<br>
			<div>
				<select id="select">
					<option value="${tab}"></option>
					<option value="valeur2" selected>Valeur 2</option>
					<option value="valeur3">Valeur 3</option>
				</select> <input type="submit" value="Supprimer" class="sansLabel" />
			</div>
			<br>
		</form>


	</div>

</body>
</html>