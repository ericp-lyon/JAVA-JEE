<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="menu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h2>Ajouter un article</h2>

		


		<form method="post"
			action="http://localhost:8080/JEECommande/ajoutarticle">
					<div>
			<label for="designation">Designation :</label> <input type="text"
				id="designation" name="designation" value="${designationSaisi}" />
		</div><br>
		
		<div>
			<label for="prixU">Prix Unitaire (TTC en €) :</label> <input type="text"
				id="prixU" name="prixU" value="${prixUSaisi}" />
		</div><br>

		<div>
			<label for="stock">Stock :</label> <input type="text" id="stock"
				name="stock" value="${stockSaisi}" />
		</div><br>
			<div>
				<input type="submit" value="Ajouter" class="sansLabel" />
			</div>
			<br>
		</form>

		
	</div>

</body>
</html>