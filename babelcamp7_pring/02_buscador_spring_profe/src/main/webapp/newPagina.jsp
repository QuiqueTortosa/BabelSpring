<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="AddPag" method="POST" >
			Direcci�n: <input type="text" name="direccion"/><br/><br/>
			Tematica: <input type="text" name="tematica"/><br/><br/>
			Descripci�n: <input type="text" name="descripcion"/><br/><br/>
			<input type="submit" value="a�adir"/>		
		</form>
		<a href="datos.jsp" target="_parent"><button>Volver</button></a>
	</center>
</body>
</html>