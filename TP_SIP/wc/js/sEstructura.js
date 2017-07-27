function getAppPath() {
	var pathArray = location.pathname.split('/');
	var appPath = "/";
	for (var i = 1; i < pathArray.length - 1; i++) {
		appPath += pathArray[i] + "/";
	}
	return appPath;
}

var nombreProy = getAppPath();

$(document.body).on('click', '.addObs', function() {
	$(".idEntregable").val($(this).closest('tr').attr('id'));
	$("#modalObsEntregables").modal();
});

$(document.body).on('click', '.editObs', function() {
	$(".idEntregable").val($(this).closest('tr').attr('id'));
	$("#modalEditObsEntregables").modal();
});

$(document.body).on('click', '.setSts', function() {
	$(".idEntregable").val($(this).closest('tr').attr('id'));
	$("#modalSetStsEntregables").modal();
});

$(".btnVerLista").click(function(e) {
	e.preventDefault();
	var nroGrupo = $('#listaGrupos').val();

	$.ajax({
		type : 'GET',
		url : nombreProy + "EvolucionTP",
		data : {
			nroGrupo : nroGrupo,
			fechaEntregar : null,
			iteracion : null,
			etapa : null
		},
		success : function(data) {
			lala(data);	
		}
	});
});


function lala(data)
{
	$("#tablaLista").html(data);
	$(".btnFiltrarEntregables").click(function(e) {
		e.preventDefault();
		var nroGrupo = $('#listaGrupos').val();
		var fechaEntregar = $('.fechaEntregar').val();
		var iteracion = $('.iteracion').val();
		var etapa = $('#etapa').val();

		$.ajax({
			type : 'GET',
			url : nombreProy + "EvolucionTP",
			data : {
				nroGrupo : nroGrupo,
				fechaEntregar : fechaEntregar,
				iteracion : iteracion,
				etapa : etapa
			},
			success : function(data) {
				lala(data);
			}
		});
	});
	};

$(".btnAgregarObsAEntregable").click(function(e) {
	e.preventDefault();
	var idEntregable = $('.idEntregable').val();
	var obs = $('#obs').val();
	$.ajax({
		type : 'GET',
		url : nombreProy + "EvolucionTPObs",
		data : {
			idEntregable : idEntregable,
			obs : obs
		},
		success : function(data) {
			setTimeout(function(){
				$('.btnVerLista').trigger('click');
	        }, 10);
		}
	});
});


$(".btnEditarObsAEntregable").click(function(e) {
	e.preventDefault();
	var idEntregable = $('.idEntregable').val();
	var obs = $('#obsNew').val();
	$.ajax({
		type : 'GET',
		url : nombreProy + "EvolucionTPObsModifica",
		data : {
			idEntregable : idEntregable,
			obs : obs
		},
		success : function(data) {
			setTimeout(function(){
				$('.btnVerLista').trigger('click');
	        }, 10);
		}
	});
});


$(".btnSetStsAEntregable").click(function(e) {
	e.preventDefault();
	var idEntregable = $('.idEntregable').val();
	var estado = $('#estado').val();
	$.ajax({
		type : 'GET',
		url : nombreProy + "EvolucionTPEstadoEntregable",
		data : {
			idEntregable : idEntregable,
			estado : estado
		},
		success : function(data) {
			setTimeout(function(){
				$('.btnVerLista').trigger('click');
	        }, 10);
		}
	});
});



$(document.body).on('click', '.verHistorialObs', function() {
	var idEntregable = $(this).closest('tr').attr('id');
	
	$.ajax({
		type : 'GET',
		url : nombreProy + "EvolucionTPObsEntregable",
		data : {
			idEntregable : idEntregable
		},
		success : function(data) {
			$("#modalListadoObs p").html(data);
			$("#modalListadoObs").modal();
		}
	});
});