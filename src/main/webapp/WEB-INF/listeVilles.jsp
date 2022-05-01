<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
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
 		<c:forEach items="${sessionScope.villesPage}" var="ville">
 			<tr>
         	 <td> ${ville.getCode_commune()}</td>
         	
         	 <td style="padding: 10px;"><a href="/TWIC_Client_test/pageVille?nomVille=${ville.getNom_commune()}">${ville.getNom_commune()}</a></td>
         	 
         	 <td> ${ville.getCode_postale()}</td>
         	 <td> ${ville.getLibelle()}</td>
         	 <td> ${ville.getLigne5()}</td>
         	 <td> ${ville.getLongitude()}</td>
         	 <td> ${ville.getLatitude()}</td>
          	</tr>
  		</c:forEach>
 </table>
 
		<p>Page ${sessionScope.page}/68</p>
		
	<c:forEach var="i" begin="0" end="68" step="1">
	     <a href="/TWIC_Client_test/listeVilles?page=${i}">${i}</a>
	</c:forEach>
</body>
</html>