<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="menu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supprimer un article</title>
</head>
<body>

	<div>
		<h2>Supprimer un article</h2>




		<form method="post"
			action="http://localhost:8080/JEECommande/supprimerarticle">
			<div>
				<label for="designation">Designation :</label> <input type="text"
					id="designation" name="designation" value="${designationSaisi}" />
			</div><br>


			<input type="submit" value="supprimer" class="sansLabel" /></form>
			
	</div>
	<br>
	
	

</body>
</html>