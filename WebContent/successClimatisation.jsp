<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
  	<h2>
		Les données mesurées par le capteur  ${app} sont: <br /> 
		temperature : ${temperature}<br />
	    pression : ${pression}<br />
		taux humidite : ${humidite}<br />
	</h2>
</body>
</html>