<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LIST</title>
</head>
<body>
<c:choose>
 <c:when test = "${not empty sessionScope.utilisateur}"> 
<h3>${sessionScope.utilisateur} est connecté</h3>
<a href= "LogoutController"> LogOUT </a> <br/>
</c:when>
 <c:otherwise> 
<a href= "LoginController"> LogIN </a> <br/>
</c:otherwise>
</c:choose>
<a href= "ClimatisationController"> saisie climatisation </a> <br/>
	<h3>List dans le ficher climatisation:</h3>
	 <table border="1">
            <tr>
                <th>Appareil</th>
                <th>Temperature °C </th>
                <th>Pression hPa </th>
                <th>Humidite % </th>
            </tr>
            <c:forEach var="clim" items="${listClim}" >
                <tr>
                    <td>${clim.app}</td> 
                    <td>${clim.temperature}</td> 
                    <td>${clim.pression}</td>
                    <td>${clim.humidite}</td>
                </tr>
            </c:forEach>
              </table>

	<span style="color: BLUE"> ${rechercheDataErreur}</span><br/>

</body>
</html>