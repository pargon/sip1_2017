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
		<td>Asigna NotaA</td>				
		<td>Asigna NotaB</td>
		<td>Asigna NotaFinal</td>
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
		<td><input type="submit" name="action" value="NotaA"></td>
		<td><input type="submit" name="action" value="NotaB"></td>
		<td><input type="submit" name="action" value="NotaFinal"></td>		
</tr>
		
<%} %>
<%} %>
	

</table>
</body>
</html>