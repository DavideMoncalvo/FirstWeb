<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage de la date du jour</title>
</head>
<body>
	<h1>
		${dateDuJour} <br /> il est ${heureDuJour}
	</h1>
	<h2>
		Les données mesurées par le capteur sont: <br /> ${clim.app }<br />
		${clim.getTemperature()}<br /> ${clim.pression}<br />
		${clim.humidite}<br />
	</h2>
</body>
</html>