<%@page import="java.util.List"%>
<%@page import="dto.GrupoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grupo - Integrantes</title>
</head>
<body>

<table border="1">

<thead> <tr>
		<td>Grupo </td>
		<td>LU</td>
		<td>Nombre</td>
		</tr>
</thead>

<%
	for(GrupoDTO gd: (List<GrupoDTO>) request.getAttribute("listgrupo") ){
%>
<tr>
	<td><%= gd.getNumero() %></td>
	<td><%= gd.getNombre() %></td>
</tr>
	
<%} %>
	

</table>
</body>
</html>