<%@page import="com.beans.Ville"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Ville</title>
</head>
<body>
	<h1>Modifier la ville</h1>
	<%
	Ville villeModif = (Ville) session.getAttribute("villeModif");
	%>

	<form action="ville" method="post">

		<p>Code Commune :</p>
		<input type="text" id=Code_Commune_INSEE name="Code_Commune_INSEE"
			value="<%=villeModif.getCode_Commune_INSEE()%>">

		<p>Nom commune :</p>
		<input type="text" id="Nom_commune" name="Nom_commune"
			value="<%=villeModif.getNom_commune()%>"> 
			
			<p>Code postal :</p>
		<input type="text" id="Code_postal" name="Code_postal"
			value="<%=villeModif.getCode_postal()%>"> 
			
			<p>Libelle :</p>
		<input type="text" id="libelle" name="libelle"
			value="<%=villeModif.getLibelle_acheminement()%>"> 
			
			<p>Longitude :</p>
		<input type="text" id="Longitude" name="Longitude"
			value="<%=villeModif.getLongitude()%>"> 
			
			<p>Latitude :</p>
		<input type="text" id="Latitude" name="Latitude"
			value="<%=villeModif.getLatitude()%>"> 
			
			
			
			
			<input type="submit" value="Modifier" />
	</form>
	
	<form method="post" action="listeVilles">
		<input type="submit" value="RETOUR" />
	</form>

</body>
</html>