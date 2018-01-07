<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="menu.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commande</title>
</head>
<body>

	<div>
		<h2>Commande</h2>
		<form 
			method="post"
			action="http://localhost:8080/JEECommande/ajoutcommande">
			
			
			<div>
				<label for="date">date :</label> <input
					type="text" id="date" name="date"
					value="${dateSaisi}" />
			</div>
			<div>
				<label for="id">id :</label> 
					<select id="select">
					<option value="tab">${lesCommandes}</option>
				</select>
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