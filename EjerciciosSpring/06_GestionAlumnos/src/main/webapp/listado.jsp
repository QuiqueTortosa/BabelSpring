<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Alumno,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<Alumno> alumnos=(ArrayList<Alumno>)request.getAttribute("productos");
	%>
	<center>
		<table border='1'><tr><th>Nombre</th><th>Precio</th><th>Stock</th></tr>
			<%
			for(int i=0;i<alumnos.size();i++) {
					Alumno pd=alumnos.get(i);
			%>
				<tr><td><%=pd.getNombre()%></td><td><%=pd.getCursos() %></td><td><%=pd.getNota() %></td></tr>	
			<%}%>
		
		</table>
		<br>
		<a href='datos.jsp'>Volver</a>
	</center>
</body>
</html>