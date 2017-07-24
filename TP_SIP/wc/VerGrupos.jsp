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

<title>Administración de Grupos</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="alert alert-success text-center" id="success-alert"
		style="position: fixed; bottom: 0px; right: 0px; width: 50%; z-index: 9999; border-radius: 2px solid">
		<strong>Éxito! </strong>
		<div class="mensaje"></div>
	</div>
	<div class="container">
		<h2 class="text-center">Administración de Grupos</h2>
		<div class="panel-group">
			<c:forEach var="grupo" items="${listgrupo}">
				<div class="panel panel-primary" id="${grupo.nroGrupo}"
					style="margin-bottom: 30px;">
					<div class="panel-heading clearfix">
						<div class="col-sm-3">
							<strong>Grupo N° ${grupo.nroGrupo}</strong>
						</div>
						<div class="col-sm-3">
							<c:set var="notaTPFinal" scope="session"
								value="${grupo.notaDocFinal}" />
							<c:if test="${empty notaTPFinal or notaTPFinal == 0}">
								<strong>Calificación TP Final: NO DISPONIBLE</strong>
							</c:if>
							<c:if
								test="${notaTPFinal > 3 and not empty notaTPFinal and notaTPFinal != 0}">
								<strong>Calificación TP Final: SUFICIENTE</strong>
							</c:if>
							<c:if
								test="${notaTPFinal < 3 and not empty notaTPFinal and notaTPFinal != 0}">
								<strong>Calificación TP Final: INSUFICIENTE</strong>
							</c:if>
						</div>
						<div class="btn-group pull-right">
							<button type="button" class="btn btn-info">Agregar
								Alumno</button>
							<button type="button" class="btn btn-info btnNotaFinalClick">Puntuar
								Doc. Final</button>
						</div>
					</div>
					<div class="panel-body">
						<table class="table table-bordered table-condensed">
							<thead>
								<th><strong>Alumno</strong></th>
								<th><strong>Legajo</strong></th>
								<th><strong>Calificación Prototipado</strong></th>
								<th><strong>Calificación Exposición</strong></th>
								<th><strong></strong></th>
							</thead>
							<tbody>
								<c:forEach var="alumno" items="${grupo.integrantes}">
									<tr class="trNroGrupo" id="${grupo.nroGrupo}"
										data-lu="${alumno.lu}">
										<td>${alumno.apellido},${alumno.nombre}</td>
										<td>${alumno.lu}</td>
										<td>${alumno.notaA}</td>
										<td>${alumno.notaB}</td>
										<td class="text-center">
											<div class="dropdown">
												<button class="btn btn-info dropdown-toggle" type="button"
													data-toggle="dropdown">
													Acciones <span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a class="btnPuntuarPrototipo">Calificar
															Prototipado</a></li>
													<li><a class="btnPuntuarExposicion">Calificar
															Exposición</a></li>
													<li><a href="#">Eliminar Alumno</a></li>
												</ul>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="modal fade" id="modalAdmGrupo" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body">
					<form id='frmLlenarGrupo' action='CambiarNotaA' method='get'>
						<input type='text' name='nroGrupo' class="nroGrupo hidden">
						<input type='text' name='lu' class="lu hidden"> <input
							type='text' name='tipoNota' class="tipoNota hidden">
						<div class="form-group">
							<label class="valueTitle" name="valueTitle">Select list:</label>
							<select class="form-control valueNota" name="valueNota"
								id="valueNota" title="Seleccione nota">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4" selected="selected">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer text-center">
					<div class="pull-center">
						<button type='submit' class='btn btn-default btnPuntuarNota'
							data-dismiss="modal">Calificar</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-------------------------------------MODAL Nota Doc Final------------------------------------------------>

	<!-- Modal -->
	<div id="modalNotaFinal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Ingresar Nota</h4>
				</div>
				<div class="modal-body">
					<input type='text' name='nroGrupoFinal'
						class="nroGrupoFinal hidden">
					<div class="form-group">
						<label class="valueTitle" name="valueTitle">Ingrese Nota
							de Documento Final</label> <select class="form-control valueNotaFinal"
							name="valueNotaFinal" id="valueNotaFinal" title="Seleccione nota">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4" selected="selected">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
					</div>
				</div>
				<div class="modal-footer text-center">
					<div class="pull-center">
						<button type='submit' class='btn btn-default btnPuntuarNotaFinal'
							data-dismiss="modal">Calificar</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					</div>
				</div>
			</div>

		</div>
	</div>




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sGrupos.js"></script>

</body>


</html>