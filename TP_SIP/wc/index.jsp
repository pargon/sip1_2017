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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Módulo de Grupos de WebCampus</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse bg-primary navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <p class="navbar-text"><strong>Módulo de Grupos de WebCampus</strong></p>
		  <!-- <a class="navbar-brand" href="#">WebSiteName</a> -->
	    </div>
	    <ul class="nav navbar-nav">
	    	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Trabajo Práctico <span class="caret"></span></a>
        		<ul class="dropdown-menu">
				  <!-- <li class="active"><a href="VerEntregables">Seguimiento de TP</a></li> -->
		          <li><a href="VerEntregables">Seguimiento de TP</a></li>
		          <li><a href="#">Estructura de TP</a></li>
        		</ul>
      		</li>
      		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Grupos<span class="caret"></span></a>
        		<ul class="dropdown-menu">
			    	<!-- <li class="active"><a href="VerGrupos"><large>Administración de Grupos</large></a></li> -->
      				<li><a href="VerGrupos">Administración de Grupos</a></li>
        		</ul>
      		</li>
	    </ul>
	  </div>
	</nav>
</body>
</html>