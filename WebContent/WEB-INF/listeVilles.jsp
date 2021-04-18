<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Liste de Villes</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<form action="ville" method="post">
	<div>
		<div>
			<c:set var="nombreVille" scope="session"
				value="${ listeVilles.size() }" />
			<c:set var="parPage" scope="session" value="50" />
			<c:set var="pageStart" value="${param.start}" />
			<!-- ${param.start} -->

			<c:if test="${empty pageStart or pageStart < 0}">
				<c:set var="pageStart" value="0" />
			</c:if>
			<c:if test="${nombreVille < pageStart}">
				<c:set var="pageStart" value="${pageStart - 50}" />
			</c:if>


			<table class="table table-striped table-bordered" style="width: 100%">
				<tbody>
					<tr>
						<th>Code Commune INSEE</th>
						<th>Nom Commune</th>
						<th>Code Postal</th>
						<th>Libelle</th>
						<th>Modifier</th>
					</tr>

					<c:forEach var="current" items="${listeVilles}" varStatus="status"
						begin="${pageStart}" end="${pageStart + parPage - 1}">

						<tr>
							<td>${current.getCode_Commune_INSEE()}</td>
							<td>${current.getNom_commune()}</td>
							<td>${current.getCode_postal()}</td>
							<td>${current.getLibelle_acheminement()}</td>
							<td>
							<button name="modif"
									value="${current.getCode_Commune_INSEE()}">Modifier</button></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
		

		<ul class="pagination justify-content-center">

			<li class="page-item"><a class="page-link" href="?start=0">First
					page</a></li>
			<li class="page-item"><a class="page-link"
				href="?start=${pageStart - 50}">Previous</a></li>
			<a class="page-link">Page ${Math.round((pageStart/50) + 1)} /
				${Math.round((nombreVille/50) + 1)}</a>
			<li class="page-item"><a class="page-link"
				href="?start=${pageStart + 50}">Next</a></li>
			<li class="page-item"><a class="page-link"
				href="?start=${nombreVille - 1}">Last page</a></li>
		</ul>
	</div>
</form>

		


	<form method="post" action="home">
		<input type="submit" value="RETOUR" />
	</form>

</body>
</html>
<!-- 
<body>
	<table class="table table-striped table-bordered" style="width:100%">
		<tr>
			<th>Code Commune INSEE</th>
			<th>Nom Commune</th>
			<th>Code Postal</th>
			<th>Libelle</th>
		</tr>

		<c:forEach items="${listeVilles}" var="current"  varStatus="status">
			<tr>
				<td>${current.getCode_Commune_INSEE()}</td>
				<td>${current.getNom_commune()}</td>
				<td>${current.getCode_postal()}</td>
				<td>${current.getLibelle_acheminement()}</td>
			</tr>
		</c:forEach>
	</table>
	<form method="post" action="listeVilles">
		<input type="submit" value="<-" />
	</form>
	<form method="post" action="listeVilles">
		<input type="submit" value="->" />

	</form>
-->