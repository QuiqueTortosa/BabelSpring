<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet">
</head>
<body>
			<h1>Acceso al Cajero</h1>
			<div>
				<form action="Cuenta" method="post">
					<h2>Numero de Cuenta</h2>
					<span><input type="number" name="nmCuenta" placeholder="Numero De Cuenta" required /></span>
					<h2>Acceder</h2>
					<span><input type="submit" value="Acceder" /></span>
				</form>
			</div>
</body>
</html>