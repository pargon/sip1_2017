<%@page import="java.util.List"%>
<%@page import="dto.GrupoDTO"%>
<%@page import="dto.AlumnoDTO"%>
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
		<td>Estado</td>
		<td>Título TP</td>
		<td>LU Alumno</td>
		<td>Ape. Alumno</td>
		<td>Nom. Alumno</td>
		<td>Nota A</td>
		<td>Nota B</td>
		<td>Estado TP</td>
		<td>Fecha Doc.Final</td>
		<td>Nota Doc.Final</td>
		</tr>
</thead>

<%
	for(GrupoDTO gd: (List<GrupoDTO>) request.getAttribute("listgrupo") ){
%>
<tr>
<%
		for(AlumnoDTO ad: gd.getIntegrantes() ){			
%>
		<td><%= gd.getNroGrupo() %></td>
		<td><%= gd.getEstadoTP() %></td>
		<td><%= gd.getTituloTP() %></td>
		<td><%= ad.getLu() %></td>
		<td><%= ad.getApellido() %></td>
		<td><%= ad.getNombre()  %></td>
		<td><%= ad.getNotaA()  %></td>
		<td><%= ad.getNotaB()  %></td>
		<td><%= gd.getEstadoTP() %></td>
		<td><%= gd.getFechaEntregaDocFinal() %></td>
		<td><%= gd.getNotaDocFinal() %></td>
		
</tr>

<%} %>
<%} %>

</table>
<form action="AdmGrupo" method="get">
<table border="1">
	<tr><td>Nro. Grupo:</td><td><input type="text" name="nrogrupo"/></td></tr>
	<tr><td>LU:</td><td><input type="text" name="lu"/></td></tr>
	<tr><td>Nota A:</td><td><input type="text" name="valnotaA"/></td></tr>	
	<tr><td>Nota B:</td><td><input type="text" name="valnotaB"/></td></tr>	
	<tr><td>Nota Doc.Final:</td><td><input type="text" name="valnotafinal"/></td></tr>	
	<tr><td colspan="2"><input type="submit" value="Puntuar"/></td></tr>
</table>
	
</body>
</html>