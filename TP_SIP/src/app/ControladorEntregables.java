package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.HibernateDAO;
import dto.EntregableGrupoDTO;
import negocio.Entregable;
import negocio.Grupo;

public class ControladorEntregables {

	private static ControladorEntregables instancia;
	
	public ControladorEntregables() {}
	
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
	
	public List<EntregableGrupoDTO> lineasTablaDeGrupo(int ngrupo, Date dateEntrega, String iter, String etapa) {
		// obtiene objeto grupo de la base
		Grupo grupo = buscarGrupoPorNumero(ngrupo);
		
		// entregables ya presentados del grupo
		List<Entregable> entregables = grupo.getEntregables();
		
		//
		// llena DTO
		//
		List<EntregableGrupoDTO> listaEntregablesDTO = new ArrayList<EntregableGrupoDTO>();
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
			
			boolean muestra = false;
			
			// valida filtros
			if (dateEntrega.before(egdto.getFechaEntrega() ))
				if(iter.equals(egdto.getNombreIteracion()) || iter.equals(""))
					if( etapa.equals(egdto.getNombreEtapa()) || etapa.equals(""))
						muestra = true;	
			
			if (muestra)
				listaEntregablesDTO.add(egdto);
		}
		return listaEntregablesDTO;
		
	}
}

