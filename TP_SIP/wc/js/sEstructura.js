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

$(".btnVerLista").click(function(e) {
	e.preventDefault();
	var nroGrupo = $('#listaGrupos').val();

	$.ajax({
		type : 'GET',
		url : nombreProy + "EvolucionTP",
		data : {
			nroGrupo : nroGrupo,
		},
		success : function(data) {
			$("#tablaLista").html(data);
		}
	});
});


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