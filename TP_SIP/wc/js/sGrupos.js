function getAppPath() {
    var pathArray = location.pathname.split('/');
    var appPath = "/";
    for(var i=1; i<pathArray.length-1; i++) {
        appPath += pathArray[i] + "/";
    }
    return appPath;
}

var nombreProy = getAppPath();

$(document).ready(function() {
	$("#success-alert").hide();
	$(".btnPuntuarNota").click(function showAlert() {
		$(".mensaje").text("La nota ha sido actualizada correctamente.");
		$("#success-alert").fadeTo(3000, 500).slideUp(500, function() {
			$("#success-alert").slideUp(500);
		});
	});
});

$(".btnPuntuarPrototipo").click(function() {
	$(".nroGrupo").val($(this).closest('tr').attr('id'));
	$(".lu").val($(this).closest('tr').data('lu'));
	$(".tipoNota").val("notaA");
	$(".modal-title").text("Ingresar Nota");
	$(".valueTitle").text("Nota por Prototipado");
	$('#modalAdmGrupo').modal();
});


$(".btnPuntuarExposicion").click(function() {
	$(".nroGrupo").val($(this).closest('tr').attr('id'));
	$(".lu").val($(this).closest('tr').data('lu'));
	$(".tipoNota").val("notaB");
	$(".modal-title").text("Ingresar Nota");
	$(".valueTitle").text("Nota por Exposici\u00F3n");
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
		url : nombreProy + "AsignarNota",
		data : {
			nroGrupo : nroGrupo,
			valueNota : valNotaA,
			lu : lu,
			tipoNota : tipoNota
		},
		success : function(data) {
			setTimeout(function(){
	               window.location.reload();
	        }, 10);
		}
	});
});