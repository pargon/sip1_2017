<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Seguimiento de TP</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse bg-primary navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<p class="navbar-text">
					<strong>Módulo de Grupos de WebCampus</strong>
				</p>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="VerEntregables">Seguimiento de
						TP</a></li>
				<!-- 			<li><a href="VerEntregables">Seguimiento de TP</a></li> -->
				<li><a href="#">Estructura de TP</a></li>
				<!-- 			<li class="active"><a href="VerGrupos">Administración de Grupos</a></li> -->
				<li><a href="VerGrupos">Administración de Grupos</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<table class="table table-condensed">
			<thead>
				<tr>
					<!-- 				<td class="text-right">Seleccione Grupo: </td> -->
					<th><select class="form-control" title="Seleccione grupo:"
						id="listaGrupos" name="listaGrupos">
							<c:forEach var="grupo" items="${grupos}">
								<option value="${grupo.nroGrupo}">Grupo N° ${grupo.nroGrupo}</option>
							</c:forEach>
					</select></th>
					<th><button class="btn btn-primary btnVerLista">Buscar</button></th>
				</tr>
			</thead>
		</table>
		<br>
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
						<form id='frmAgregarObs' action='EvolucionTPObsEntregable'
							method='get'>
							<input type='text' name='idEntregable'
								class="idEntregable hidden"> <input type="text"
								name="obs" id="obs" class="form-control">
						</form>
					</div>
					<div class="modal-footer text-center">
						<div class="pull-center">
							<button type='submit'
								class='btn btn-default btnAgregarObsAEntregable'
								data-dismiss="modal">Agregar</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancelar</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--  Modal Para Editar Obs a Entregables -->

		<div id="modalEditObsEntregables" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar Ult. Observación</h4>
					</div>
					<div class="modal-body">
						<form id='frmEditarObs' action='EvolucionTPObsEntregable'
							method='get'>
							<input type='text' name='idEntregable'
								class="idEntregable hidden"> <input type="text"
								name="obs" id="obsNew" class="form-control">
						</form>
					</div>
					<div class="modal-footer text-center">
						<div class="pull-center">
							<button type='submit'
								class='btn btn-default btnEditarObsAEntregable'
								data-dismiss="modal">Editar</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancelar</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--  Modal Para Setear Estado a Entregables -->

		<div id="modalSetStsEntregables" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Estado Entregable</h4>
					</div>
					<div class="modal-body">
						<form id='frmSetSts' action='EvolucionTPObsEntregable'
							method='get'>
							<input type='text' name='idEntregable'
								class="idEntregable hidden"> <select
								class="form-control estado" name="estado" id="estado"
								title="Seleccione estado">
								<option value="APROBADO">Aprobado</option>
								<option value="CON_CORRECIONES">Con Correcciones</option>
							</select>
						</form>
					</div>
					<div class="modal-footer text-center">
						<div class="pull-center">
							<button type='submit'
								class='btn btn-default btnSetStsAEntregable'
								data-dismiss="modal">Cambiar</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancelar</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--  Modal Para ver historial de Observaciones de Entregables -->


		<div id="modalListadoObs" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Historial de Observaciones</h4>
					</div>
					<input type='text' name='idEntregable' class="idEntregable hidden">
					<div class="modal-body">
						<p>Aca se genera la tabla por ajax.</p>
					</div>
					<div class="modal-footer text-center">
						<div class="pull-center">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Salir</button>
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