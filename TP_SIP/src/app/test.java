package app;

import java.util.List;

import dto.EntregableGrupoDTO;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String fechaEntrega = "01/10/2017";
		String iter = "Iteracion 2";
		String etapa = null;
		
		List<EntregableGrupoDTO> lo = 		ControladorEntregables.getInstancia().lineasTablaDeGrupo(5, fechaEntrega, iter, etapa);

		for (EntregableGrupoDTO eo :lo){
			System.out.println("eo:" + eo.getIdEntregable() + " iter: " + eo.getNombreIteracion() + " eta: " + eo.getNombreEtapa() +" estado: " + eo.getEstado() + " fecha ent: " + eo.getFechaEntrega());
			
		}
	}

}
