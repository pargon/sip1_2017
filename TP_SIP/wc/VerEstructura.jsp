<%@page import="dto.EntregableGrupoDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.EntregableGrupoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trabajo Práctico - Evolución del TP</title>
</head>
<body>
<form action="EvolucionTP" method="get">
<table border="1">
	<tr>
	<td>Nro. Grupo:</td><td><input type="text" name="nrogrupo"/></td>
	<td></td><td></td>
	<td></td><td></td>
	</tr>
	<tr>
	<td>Fecha Entrega:</td><td><input type="text" name="fentrega"/></td>
	<td>Iteracion:</td><td><input type="text" name="iter"/></td>
	<td>Etapa:</td><td><input type="text" name="etapa"/></td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit" value="Filtrar"/></td>
	<td></td><td></td>
	<td></td><td></td>
	</tr>
</table>
</form>

<table border="1">

<thead> <tr>
		<td>Iteración</td>
		<td>Etapa</td>
		<td>Entregable</td>
		<td>Fecha Carga</td>
		<td>Fecha a entregar</td>
		<td>Estado</td>
		<td>Observaciones</td>
		<td>Fecha Obs.</td>
		<td>Archivo</td>
		</tr>
</thead>

<%
	if (request.getAttribute("listevo") != null)
	{
	for(EntregableGrupoDTO egdto: (List<EntregableGrupoDTO>) request.getAttribute("listevo") ){
%>
<tr>
		<td><%= egdto.getNombreIteracion() %></td>
		<td><%= egdto.getNombreEtapa() %></td>
		<td><%= egdto.getNombreEntregable() %></td>
		<td><%= egdto.getFechaCarga() %></td>
		<td><%= egdto.getFechaEntrega() %></td>		
		<td><%= egdto.getEstado() %></td>
		<td><%= egdto.getComentario() %></td>
		<td><%= egdto.getFechaObs() %></td>
		<td><%= egdto.getNombreArchivo() %></td>
</tr>

<%} }%>

</table>

</body>
</html>