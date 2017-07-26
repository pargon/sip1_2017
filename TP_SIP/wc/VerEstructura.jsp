<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Seguimiento de TP</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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