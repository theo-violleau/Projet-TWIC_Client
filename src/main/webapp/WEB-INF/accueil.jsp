<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>
    <body>
    <%@ include file="Menu.jsp" %>
    <p><c:out value="Bonjour !" /></p>
    
    


    
    <form method="post" action="Accueil">
    	<label for="city-select">Choisissez une ville:</label>
        <select name="city-select" id="city-select" size = "1">
            	<c:forEach items="${villes}" var="ville">
          			<option name="ville1"value="${ville.getNom_commune()}">${ville.getNom_commune()}</option>
         		</c:forEach>
		</select>

		<label for="city-select2">Choisissez une deuxième ville:</label>
		<select name="city-select2" id="city-select2" size = "1">
           		 <c:forEach items="${villes}" var="ville">
          			<option value="${ville.getNom_commune()}">${ville.getNom_commune()}</option>
         		</c:forEach>
		</select>
		<input type="submit" value="Calculer"/>
	</form>
	
	<c:if test="${ !empty sessionScope.distance }">
		<p style="color: red;">La distance entre ${ sessionScope.ville1String } et ${ sessionScope.ville2String } est de ${sessionScope.distance} kilomètres</p>
	</c:if>
         
    </body>
</html>