package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
			
			// última observacion del entregable
			if(!e.getObservaciones().isEmpty())
				egdto.setComentario(e.getObservaciones().get(e.getObservaciones().size() - 1).toString());
			else
				egdto.setComentario("");
			
			// estado entregable, respecto al grupo
			egdto.setEstado(e.getEstado());
			
			// fecha carga entregable en grupo
			egdto.setFechaCarga(e.getFechaCarga());
			
			// fecha propuesta de entrega en estructura tp
			egdto.setFechaEntrega(e.getEntregableestructura().getFechaEntrega());
			
			// fecha de la última observación, si la hubo
			if(!e.getObservaciones().isEmpty())
				egdto.setFechaObs(e.getObservaciones().get(e.getObservaciones().size() - 1).getFecha());
			else
				egdto.setFechaObs(null);
			
			// id del entregable del grupo
			egdto.setIdEntregable(e.getId());
			
			// nombre archivo subido asociado al entregable del grupo
			egdto.setNombreArchivo(e.getArchivo().getNombre());
			
			// nombre entregable-estructura
			egdto.setNombreEntregable(e.getEntregableestructura().getNombre());
			
			// nombre etapa
			egdto.setNombreEtapa(e.getEntregableestructura().getEtapa().getNombre());
			
			// nombre iteracion
			egdto.setNombreIteracion(e.getEntregableestructura().getEtapa().getIteracion().getNombre());
			
			// numero grupo
			egdto.setNroGrupo(grupo.getNroGrupo());
			
			// ruta archivo del entregable subido
			egdto.setRutaArchivo(e.getArchivo().getRuta());
			
			//
			// aplica filtros de pantalla, si no filtra no se agrega a la Lista
			//
			boolean muestra = false;
			if (dateEntrega.before(egdto.getFechaEntrega() ))
				if(iter.equals(egdto.getNombreIteracion()) || iter.equals(""))
					if( etapa.equals(egdto.getNombreEtapa()) || etapa.equals(""))
						muestra = true;	
			
			// valida filtros, sino no entra			
			if (muestra)
				listaEntregablesDTO.add(egdto);
		}
		return listaEntregablesDTO;
		
	}
}

