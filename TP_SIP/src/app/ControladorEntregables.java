package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.HibernateDAO;
import dto.EntregableGrupoDTO;
import dto.ObsEntregableDTO;
import enums.EstadoEntregable;
import negocio.Entregable;
import negocio.Grupo;
import negocio.ObservacionEntregable;

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
	
	public Entregable buscarEntregablePorNumero(int idEntregable) {
		Entregable ent = null;
		try {
			
	        String sql = "from Entregable where id = :idEnt";
	        String prm = "idEnt";
	        Integer obj = Integer.valueOf(idEntregable);
	        ent = (Entregable) HibernateDAO.getInstancia().getUnique(sql, prm, obj);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ent;
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
			
			// �ltima observacion del entregable
			if(!e.getObservaciones().isEmpty())
				egdto.setComentario(e.getObservaciones().get(e.getObservaciones().size() - 1).getComentario());
			else
				egdto.setComentario("");
			
			// estado entregable, respecto al grupo
			egdto.setEstado(e.getEstado());
			
			// fecha carga entregable en grupo
			egdto.setFechaCarga(e.getFechaCarga());
			
			// fecha propuesta de entrega en estructura tp
			egdto.setFechaEntrega(e.getEntregableestructura().getFechaEntrega());
			
			// fecha de la �ltima observaci�n, si la hubo
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
			/*boolean muestra = false;
			if (dateEntrega.before(egdto.getFechaEntrega() ))
				if(iter.equals(egdto.getNombreIteracion()) || iter.equals(""))
					if( etapa.equals(egdto.getNombreEtapa()) || etapa.equals(""))
						muestra = true;	
			
			// valida filtros, sino no entra			
			if (muestra)*/
				listaEntregablesDTO.add(egdto);
		}
		return listaEntregablesDTO;
		
	}
	public void agregarObsEntregable(int idEntregable, String observacion) {
		
		// obtiene objeto entregable desde su id
		Entregable e = buscarEntregablePorNumero(idEntregable);
				
		// agrega observacion del entregable
		ObservacionEntregable oe = new ObservacionEntregable();
		oe.setFecha(new Date());
		oe.setComentario(observacion);
		e.getObservaciones().add(oe);
		
		// guarda
		HibernateDAO.getInstancia().persistir(e);
	}

	public void modificaObsEntregable(int idEntregable, String observacion) {
		
		// obtiene objeto entregable desde su id
		Entregable e = buscarEntregablePorNumero(idEntregable);
				
		// obtiene �ltima observacion del entregable
		if(!e.getObservaciones().isEmpty())
		{
			e.getObservaciones().get(e.getObservaciones().size() - 1).setComentario(observacion);
			e.getObservaciones().get(e.getObservaciones().size() - 1).setFecha(new Date());
		}
		else{
			// agrega observacion del entregable
			ObservacionEntregable oe = new ObservacionEntregable();
			oe.setFecha(new Date());
			oe.setComentario(observacion);
			e.getObservaciones().add(oe);
		}
		// guarda
		HibernateDAO.getInstancia().persistir(e);
	}

	public List<ObsEntregableDTO> listarObsDeEntregable(int idEntregable) {
		
		List<ObsEntregableDTO> loe = new ArrayList<ObsEntregableDTO>();
		
		// entregable de la base
		Entregable e = buscarEntregablePorNumero(idEntregable);
		
		// crea DTO
		for(ObservacionEntregable oe: e.getObservaciones()){
			ObsEntregableDTO oed = new ObsEntregableDTO(oe.getComentario(), oe.getFecha());
			loe.add(oed);
		}
		return loe;
	}

	public void cambiaEstadoEntregable(int idEntregable, String estado) {
		// obtiene objeto entregable desde su id
		Entregable e = buscarEntregablePorNumero(idEntregable);
				
		// actualiza estado
		e.setEstado(EstadoEntregable.valueOf(estado));
		
		// guarda
		HibernateDAO.getInstancia().persistir(e);
	}
}

