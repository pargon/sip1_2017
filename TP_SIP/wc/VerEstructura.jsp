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
<title>Seguimiento de TP</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
	body {
        padding-top: 70px; /* 60px to make the container go all the way to the bottom of the topbar */
	}
</style>
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
				  <li class="active"><a href="VerEntregables">Seguimiento de TP</a></li>
				  <!-- <li><a href="VerEntregables">Seguimiento de TP</a></li> -->
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

	<div class="container">

		<select class="form-control" title="Seleccione grupo:"
			id="listaGrupos" name="listaGrupos">
			<c:forEach var="grupo" items="${grupos}">
				<option value="${grupo.nroGrupo}">Grupo: ${grupo.nroGrupo}</option>
			</c:forEach>
		</select>
		<button class="btn btn-primary btnVerLista">Mostrar</button>

		<div id="tablaLista"></div>


	<!--  Modal Para Agregar Obs a Entregables -->

	<div id="modalObsEntregables" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Agregar Observación</h4>
				</div>
				<div class="modal-body">
					<form id='frmAgregarObs' action='EvolucionTPObsEntregable' method='get'>
						<input type='text' name='idEntregable' class="idEntregable hidden">
						<input type="text" name="obs" id="obs" class="form-control">
					</form>
				</div>
				<div class="modal-footer text-center">
					<div class="pull-center">
						<button type='submit'
							class='btn btn-default btnAgregarObsAEntregable'
							data-dismiss="modal">Agregar</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	</div>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sEstructura.js"></script>

</body>


</html>