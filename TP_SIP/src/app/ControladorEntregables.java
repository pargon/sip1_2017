package app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.HibernateDAO;
import dto.EntregableGrupoDTO;
import enums.EstadoEntregable;
import negocio.Entregable;
import negocio.Grupo;

public class ControladorEntregables {

	private static ControladorEntregables instancia;
	
	private ControladorEntregables() {}
	
	public static ControladorEntregables getInstancia() {
		if(instancia == null)
			instancia = new ControladorEntregables();
		return instancia;
	}
	
	public Grupo buscarGrupoPorNumero(int nroGrupo) {
		Grupo grupo = null;
		try {
		grupo = HibernateDAO.getInstancia().buscarGrupoPorNumero(nroGrupo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grupo;
	}
	
	public List<EntregableGrupoDTO> lineasTablaDeGrupo(Grupo grupo) {
		List<Entregable> entregables = grupo.getEntregables();
		List<EntregableGrupoDTO> listaEntregablesDTO = new ArrayList<>();
		
		for(Entregable e : entregables) {
			EntregableGrupoDTO egdto = new EntregableGrupoDTO();
			if(!e.getObservaciones().isEmpty()) {
				egdto.setComentario(e.getObservaciones().get(e.getObservaciones().size() - 1).toString());
			}
			else
			{
				egdto.setComentario("");
			}
			egdto.setEstado(e.getEstado());
			egdto.setFechaCarga(e.getFechaCarga());
			egdto.setFechaEntrega(e.getEntregableestructura().getFechaEntrega());
			if(!e.getObservaciones().isEmpty()) {
				egdto.setFechaObs(e.getObservaciones().get(e.getObservaciones().size() - 1).getFecha());
			}
			else
			{
				egdto.setFechaObs(null);
			}
			egdto.setIdEntregable(e.getId());
			egdto.setNombreArchivo(e.getArchivo().getNombre());
			egdto.setNombreEntregable(e.getEntregableestructura().getNombre());
			egdto.setNombreEtapa(e.getEntregableestructura().getEtapa().getNombre());
			egdto.setNombreIteracion(e.getEntregableestructura().getEtapa().getIteracion().getNombre());
			egdto.setNroGrupo(grupo.getNroGrupo());
			egdto.setRutaArchivo(e.getArchivo().getRuta());
			listaEntregablesDTO.add(egdto);
		}
		return listaEntregablesDTO;
		
	}
}

