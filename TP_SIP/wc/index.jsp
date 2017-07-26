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
	<nav class="navbar navbar-inverse bg-primary navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <p class="navbar-text"><strong>Módulo de Grupos de WebCampus</strong></p>
	    </div>
	    <ul class="nav navbar-nav">
<!-- 			<li class="active"><a href="VerEntregables">Seguimiento de TP</a></li> -->
			<li><a href="VerEntregables">Seguimiento de TP</a></li>
			<li><a href="#"> Estructura de TP</a></li>
<!-- 			<li class="active"><a href="VerGrupos">Administración de Grupos</a></li> -->
			<li><a href="VerGrupos">Administración de Grupos</a></li>
  		</ul>
	  </div>
	</nav>

</body>
</html>