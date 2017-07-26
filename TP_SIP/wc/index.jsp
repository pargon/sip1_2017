<%@page import="java.util.List"%>
<%@page import="dto.GrupoDTO"%>
<%@page import="dto.AlumnoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Módulo de Grupos de WebCampus</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form action="VerGrupos" method="get">
		<div class="row">
			<div class="col-sm-4">Administración de Grupos</div>
			<div class="col-sm-4"><input type="submit" class="btn btn-primary" name="action" value="Ir"></div>
		</div>
	</form>
	<br>
	<form action="VerEntregables" method="get">
		<div class="row">
			<div class="col-sm-4">Seguimiento de TP</div>
			<div class="col-sm-4"><input type="submit" class="btn btn-primary" name="action" value="Ir"></div>
		</div>
</body>
</html>