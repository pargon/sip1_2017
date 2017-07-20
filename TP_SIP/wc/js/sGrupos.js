		$(document).ready(function() {
			$("#success-alert").hide();
			$(".btnPuntuarNota").click(function showAlert() {
				$(".mensaje").text("La nota ha sidp actualizada correctamente.");
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
			$(".valueTitle").text("Nota de Prototipo");
			$('#modalAdmGrupo').modal();
		});
		
		
		$(".btnPuntuarExposicion").click(function() {
			$(".nroGrupo").val($(this).closest('tr').attr('id'));
			$(".lu").val($(this).closest('tr').data('lu'));
			$(".tipoNota").val("notaB");
			$(".modal-title").text("Ingresar Nota");
			$(".valueTitle").text("Nota de Exposicion");
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
				url : "/TPSeminario/AsignarNota",
				data : {
					nroGrupo : nroGrupo,
					valueNota : valNotaA,
					lu : lu,
					tipoNota : tipoNota
				},
				success : function(data) {
					setTimeout(function(){
			               window.location.reload();
			        }, 3000);
				}
			});
		});