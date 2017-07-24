function getAppPath() {
    var pathArray = location.pathname.split('/');
    var appPath = "/";
    for(var i=1; i<pathArray.length-1; i++) {
        appPath += pathArray[i] + "/";
    }
    return appPath;
}

var nombreProy = getAppPath();

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