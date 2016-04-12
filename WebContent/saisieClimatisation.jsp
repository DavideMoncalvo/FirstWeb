<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src= "jquery.js"></script>
<script type="text/javascript" src= "Climatisation.js"></script>

</head>
<link href="Climatisation.css" rel="stylesheet" type="text/css"/>
<body>
 <c:if test = "${not empty sessionScope.utilisateur}"> 
<h3>Vous étes : ${sessionScope.utilisateur}</h3>
<a href= "LogoutController"> LogOUT </a> <br/>
</c:if>
 <c:if test = "${not empty sessionScope.utilisateur}"> 
 <a href= "LoginController"> LogIN </a> <br/>
</c:if>
<a href= "ListClimatisationController"> List des Climatisations </a> <br/>

<fieldset>
	<h3>Entrez les info de l'appareil :</h3>
	<br />
	<form action="ClimatisationController" method="Post">
	
		<label>Nom App : </label> <input id ="sourceNbId" type="text" value="${app }" name="app" />
		<span style="color: BLUE"> ${appErreur}</span>
		<span id="nbId" style="color: RED"> </span><br />
		
		<label>Temperature : </label> <input type="text" value="${temperature} "name="temperature" /> <span style="color: BLUE"> ${temperatureErreur}</span><br />
        <label>Pression : </label> <input type="text" value="${pression}" name="pression" /> <span style="color: BLUE">${pressionErreur}</span><br /> 
        <label>Humidite : </label> <input type="text" value="${humidite}" name="humidite" /> <span style="color: BLUE"> ${humiditeErreur}</span><br/>
        <input type="submit" value="enregistrer" name="action" /><span style="color: BLUE"> ${sauvegardeErreur}</span><br/>
	</form>
</fieldset>
</body>
</html>