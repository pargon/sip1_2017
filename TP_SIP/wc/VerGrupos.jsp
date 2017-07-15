<%@page import="java.util.List"%>
<%@page import="dto.GrupoDTO"%>
<%@page import="dto.AlumnoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Administración de Grupos</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


	<div class="container">
		<h2>Administración de Grupos</h2>
		<div class="alert alert-success" id="success-alert">
			<strong>Success! </strong>
			<div class="mensaje"></div>
		</div>
		<table class="table table-bordered table-condensed">
			<caption class="info">
				<div class="col-sm-3">
					<strong>Grupo N° </strong>
				</div>
				<div class="col-sm-3">
					<strong>Estado TP Final: </strong>
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-info" value="Agregar Alumno">
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-info" value="Eliminar Grupo">
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-info" value="Puntuar DocFinal">
				</div>
			</caption>
			<thead>
				<th><th><strong>Grupo </strong></th>
						<th><strong>Estado</strong></th>
						<th><strong>Título TP</strong></th>
						<th><strong>LU Alumno</strong></th>
						<th><strong>Ape. Alumno</strong></th>
						<th><strong>Nom. Alumno</strong></th>
						<th><strong>Nota A</strong></th>
						<th><strong>Nota B</strong></th>
						<th><strong>Estado TP</strong></th>
						<th><strong>Fecha Doc.Final</strong></th>
						<th><strong>Nota Doc.Final</strong></th>
						<th><strong>Opciones</strong></th>
					</th>
				</thead>
				<tbody>
					<%
						for (GrupoDTO gd : (List<GrupoDTO>) request.getAttribute("listgrupo")) {
					%>
					<%
						for (AlumnoDTO ad : gd.getIntegrantes()) {
					%>
					<tr id="<%=gd.getNroGrupo()%>" data-lu="<%=ad.getLu()%>">
						<td><%=gd.getNroGrupo()%></td>
						<td><%=gd.getEstadoTP()%></td>
						<td><%=gd.getTituloTP()%></td>
						<td><%=ad.getLu()%></td>
						<td><%=ad.getApellido()%></td>
						<td><%=ad.getNombre()%></td>
						<td><%=ad.getNotaA()%></td>
						<td><%=ad.getNotaB()%></td>
						<td><%=gd.getEstadoTP()%></td>
						<td><%=gd.getFechaEntregaDocFinal()%></td>
						<td><%=gd.getNotaDocFinal()%></td>	
						<td><input type="submit"
						class="btn btn-info btnPuntuarPrototipo"
						value="Puntuar Prototipado" /></td>				
					</tr>
					
					<%
											}
										%>
					<%
						}
					%>					
				</tbody>
			</table>
	</div>
	
	

	
	
	<!-- Modal -->
<div class="modal fade" id="modalAdmGrupo" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
       <form id='frmLlenarGrupo' action='CambiarNotaA' method='get'>
       <input type='text' name='nroGrupo' class="nroGrupo hidden">
       <input type='text' name='lu' class="lu hidden">
              <input type='text' name='tipoNota' class="tipoNota hidden">
              <table class='table table-condensed'>
					<tr>
					<td class="valueTitle"></td>
					<td><input type='text' class='valueNota' name='valueNota' /></td>
					</tr>
					</table>		
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default"
						data-dismiss="modal">Cancelar</button>
        <button type='submit' class='btn btn-default btnPuntuarNota'
						data-dismiss="modal">Puntuar</button>
      </div>
    </div>
  </div>
</div>
	
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
<script type="text/javascript">
	$(document).ready(function() {
		$("#success-alert").hide();
		$(".btnPuntuarNota").click(function showAlert() {
			$(".mensaje").text("Nota A Actualizada Correctamente");
			$("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
				$("#success-alert").slideUp(500);
			});
		});
	});

	$(".btnPuntuarPrototipo").click(function() {
		$(".nroGrupo").val($(this).closest('tr').attr('id'));
		$(".lu").val($(this).closest('tr').data('lu'));
		$(".tipoNota").val("notaA");
		$(".modal-title").text("Ingresar Nota");
		$(".valueTitle").text("Nota A");
		$('#modalAdmGrupo').modal();
	});
	$(".btnPuntuarNota").click(function(e) {
		e.preventDefault();
		var valNotaA = $('.valueNota').val();
		var nroGrupo = $('.nroGrupo').val();
		var lu = $('.lu').val();
		var tipoNota = $('.tipoNota').val();
		$.ajax({
			type : 'GET',
			url : "/TP_SIP/AsignarNota",
			data : {
				nroGrupo : nroGrupo,
				valueNota : valNotaA,
				lu : lu,
				tipoNota :tipoNota
			},
			success : function(data) {
				
			}
		});
	});
</script></body>

				  
</html>