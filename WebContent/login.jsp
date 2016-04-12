<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<fieldset>
	
	<form action="LoginController" method="post">
	
		<label>Nom  </label> <input type="text" value="${utilisateur}" name="utilisateur" /><span style="color: blu"> ${utilisateurErreur}</span><br />
        <input type="submit" value="LogIN" name="action" />
	</form>
</fieldset>
</body>
</html>