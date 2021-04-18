<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Distance</title>
</head>
<body>
	<h1>Calcul de distance entre 2 villes</h1>


	<form class= "distance" method="post" action="distance">
		<label for="ville1-select">Choisissez une ville de départ :</label> <select
			name="ville1" id="ville1-select">
			<option value="">--Choisissez une ville de départ--</option>
			<c:forEach items="${listeVilles}" var="current" varStatus="status">
				<option name="villeDepart" value="${current.getCode_Commune_INSEE()}">${current.getNom_commune()}(${current.getCode_postal()})</option>
			</c:forEach>
		</select> 
		
		</br>
		</br> 
				
		<label for="ville2-select">Choisissez une ville d'arrivée :
		</label> <select name="ville2" id="ville2-select" onchange="">
			<option value="">--Choisissez une ville d'arrivée--</option>
			<c:forEach items="${listeVilles}" var="current" varStatus="status">
				<option name="villeArrivee" value="${current.getCode_Commune_INSEE()}">${current.getNom_commune()}(${current.getCode_postal()})</option>
			</c:forEach>
		</select>


		<p>La distance entre ${depart} et ${arrivee} est de : ${distance} km</p>

		<input type="submit" value="Calculer" />
	</form>

	<form method="post" action="home">
		<input type="submit" value="RETOUR" />
	</form>
</body>
</html>