<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	 
	 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page d'accueil</title>
</head>
<body>

<form method="post"
		action="http://localhost:8080/ProjetApache/personne/menu">
	<div>
		<label for="user">User *</label> <input type="text" id="user"
			name="user" value="${userSaisi}" /><input type="submit" value="Soumettre"
			class="sansLabel" />
	</div>
	<br>
</form>
${session.invalidate}
</body>
</html>