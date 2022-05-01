<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Ville</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<table style="border: 1px solid black;text-align: center;">
 	<thead>
 		<tr>
 			<td>Code commune</td>
 			<td>Nom commune</td>
 			<td>Code postale</td>
 			<td>Libelle</td>
 			<td>Ligne 5</td>
 			<td>Longitude</td>
 			<td>Latitude</td>
 		</tr>
 	</thead>
 		<tr>
 			 <td> ${sessionScope.villeSelec.getCode_commune()}</td>
         	 <td> ${sessionScope.villeSelec.getNom_commune()}</td>
         	 <td> ${sessionScope.villeSelec.getCode_postale()}</td>
         	 <td> ${sessionScope.villeSelec.getLibelle()}</td>
         	 <td> ${sessionScope.villeSelec.getLigne5()}</td>
         	 <td> ${sessionScope.villeSelec.getLongitude()}</td>
         	 <td> ${sessionScope.villeSelec.getLatitude()}</td>
         </tr>
 </table>         
 <p></p>
    <form method="post" action="/TWIC_Client_test/pageVille?code_commune=?${villeSelec.getCode_commune() }">
		  <label for="code">Code commune :</label>
		  <input type="text" id="code" name="code" value="${sessionScope.villeSelec.getCode_commune()}"><br><br>
		  <label for="nom">Nom commune : </label>
		  <input type="text" id="nom" name="nom" value="${sessionScope.villeSelec.getNom_commune()}"><br><br>
		  <label for="postale">Code Postale : </label>
		  <input type="text" id="postale" name="postale" value="${sessionScope.villeSelec.getCode_postale()}"><br><br>
		  <label for="libelle">Libelle : </label>
		  <input type="text" id="libelle" name="libelle" value="${sessionScope.villeSelec.getLibelle()}"><br><br>
		  <label for="ligne5">Ligne 5 : </label>
		  <input type="text" id="ligne5" name="ligne5" value="${sessionScope.villeSelec.getLigne5()}"><br><br>
		  <label for="longitude">Longitude : </label>
		  <input type="text" id="longitude" name="longitude" value="${sessionScope.villeSelec.getLongitude()}"><br><br>
		  <label for="latitude">Latitude : </label>
		  <input type="text" id="latitude" name="latitude" value="${sessionScope.villeSelec.getLatitude()}"><br><br>
		  <input type="submit" value="Submit">
	</form>

</body>
</html>