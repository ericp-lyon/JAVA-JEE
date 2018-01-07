
<!-- la seule balise jsp -->



<%@ page import="beans.*"%>
<!--  bien penser à faire l'import -->


<!-- le reste c'est du html -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ma page vues en JSP</title>
</head>
<body>
	<h1>Hello World depuis vues.jsp</h1>
	<%--

	<c:out value="hello c'est ok" />
	<br>


	<c:out value="${1 lt 2 && 2 > 1}" />
	<br>

	
	<h2>Changer le nom de la personne</h2>
	<br>
 	
 <c:set target="${perso}" property="nom" value="JUJU" />
 <c:out value="${perso.nom} ${perso.prenom}" />
	<br>

	<c:if test="${3>2 and 2>1 }"> c'est facile </c:if>
	<br>
	<br>
--%>
	<%--
	<h3>tester une note:</h3>

	Voici votre appréciation en fonction de votre note:
	<br>
	<c:choose>

		<c:when test="${0<= note && note<10 }">Votre note est entre 0 et 10 c'est un echec </c:when>
		<c:when test="${10<=note && note<12 }">Votre note est entre 10 et 12 c'est assez bien</c:when>
		<c:when test="${12<=note && note<15}">Votre note est entre 12 et 15 c'est bien</c:when>
		<c:otherwise>Votre note est supérieur à 15 c'est parfait</c:otherwise>
	</c:choose>
	<br>
	<br> test de chiffre
	<br>
--%>
	<%--
<%--boucle for--%>
	<%-- affiche 0 1 2 3 4 5 6 7 8 9 10 --%>
	<%--
	<c:forEach var="i" begin="0" end="10" step="1">
		<c:out value="${i} " />
	</c:forEach>--%>

	<%--receptionne les valeurs envoyé de la servlet, les comparent, affichage jusqu'au plus grand--%>
	<%--
	<c:out value="${nbr1}" />
	<c:out value="${nbr2}" />
	<br>
	<c:choose>
		<c:when test="${nbr1<nbr2}">
			<c:forEach var="i" begin="0" end="${nbr2}" step="1">
				<c:out value="${i} " />
			</c:forEach>
		</c:when>
		<c:when test="${nbr2<nbr1}">
			<c:forEach var="i" begin="0" end="${nbr1}" step="1">
				<c:out value="${i} " />
			</c:forEach>
		</c:when>
		<c:otherwise> Erreur </c:otherwise>
	</c:choose>
	<br>--%>
	<%--OU sinon avec une expression ternaire--%>
	<%--
	<c:forEach var="i" begin="0" end="${nbr1>nbr2 ? nbr1 : nbr2}" step="1">
		<c:out value="${i}" />
	</c:forEach>--%>


	<%--prendre 2 chiffres et faire le produit de chaque chiffre et ne garder que les nombres impairs:<br>
		
			<c:forEach var="i" begin="1" end="${nbr2}" step="2">
				<c:forEach var="j" begin="1" end="${nbr1}" step="2">
					<c:out value="${i*j}" />
				</c:forEach>
			</c:forEach>
	--%>

	<%-- 	 faire afficher les indices et alterner affichage nom et prénom en alternance si on met .index ca demarre de 0 si on met .count ca démarre à 1<br>

<c:forEach items="${ personnes}" var="element" varStatus="status">
	
	<c:out value="${status.index}"/>
	
	<c:choose>
		<c:when test="${status.count%2 !=0}"><c:out value="${element['nom']}"/><br></c:when>
	<c:otherwise><c:out value="${element['prenom']}"/><br></c:otherwise>
	</c:choose>
	
</c:forEach>

--%>


	<%-- attention de ne pas confondre attribut transmis depuis la servlet au parametre de l'url que lon peut recup depuis la jsp
permet de changer le nom ou le prenom en fontion de l'indice

<c:set target="${personnes.get(param.id)}" property="nom" value="${!empty param.nom ? param.nom : personnes.get(param.id).nom }"/>
<c:set target="${personnes.get(param.id)}" property="prenom" value="${!empty param.prenom ? param.prenom : personnes.get(param.id).prenom }"/>
<c:out value="${personnes.get(param.id).nom}"/>

<c:forEach items="${ personnes}" var="element" varStatus="status">
	
	<c:out value="${status.index}"/>
	
	<c:choose>
		<c:when test="${status.count%2 !=0}"><c:out value="${element['nom']}"/><br></c:when>
	<c:otherwise><c:out value="${element['prenom']}"/><br></c:otherwise>
	</c:choose>
	
</c:forEach>
--%>
<%--permet de rajouter un lien en implémantant le parametre de l'url --%>
<%--	<h3>affichage du nom et prenom de la personne avec id dans l'URL</h3><br>
	<c:out value="${personnes.get(param.id).nom} ${personnes.get(param.id).prenom}" /><br><br>
	


	<c:url value="/Index" var="lien">
		<c:param name="id" value="${param.id+1 }"></c:param>
	</c:url>
	<a href="${lien}">personne suivante </a>
--%>


<%--permet de rajouter un lien en implémantant le parametre de l'url et de revenir en arriere à la fin sans connaitre 
a l'anvance la longueur du tableau--%>

<h3>affichage du nom et prenom de la personne avec id dans l'URL</h3><br>
	<c:out value="${personnes.get(param.id).nom} ${personnes.get(param.id).prenom}" /><br><br>

<c:set var="taille" value="${fn:length(personnes)}"/>
<c:set var="id" value="${taille==param.id+1 ? 0 : param.id+1}"/>



	<c:url value="/Index" var="lien">
		<c:param name="id" value="${id}"/>
	</c:url>
	<a href="${lien}">personne suivante </a>


	<br>
	<br>






</body>
</html>