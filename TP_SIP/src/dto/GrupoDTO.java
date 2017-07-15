package dto;

import java.util.Date;
import java.util.List;


public class GrupoDTO {
	
	private int nroGrupo;
	private String estadoTP;
	private String tituloTP;
	private List<AlumnoDTO> integrantes;
	private int notaDocFinal;
	private Date fechaEntregaDocFinal;
	private String estadoDocFinal;
	private List<String> archivosDocFinal;
	private List<String> obsDocFinal;
	
	
	public GrupoDTO(int nroGrupo, String estadoTP, String tituloTP,
			List<AlumnoDTO> integrantes, int notaDocFinal,
			Date fechaEntregaDocFinal, String estadoDocFinal,
			List<String> archivosDocFinal, List<String> obsDocFinal) {
		super();
		this.nroGrupo = nroGrupo;
		this.estadoTP = estadoTP;
		this.tituloTP = tituloTP;
		this.integrantes = integrantes;
		this.notaDocFinal = notaDocFinal;
		this.fechaEntregaDocFinal = fechaEntregaDocFinal;
		this.estadoDocFinal = estadoDocFinal;
		this.archivosDocFinal = archivosDocFinal;
		this.obsDocFinal = obsDocFinal;
	}


	public int getNroGrupo() {
		return nroGrupo;
	}


	public String getEstadoTP() {
		return estadoTP;
	}


	public String getTituloTP() {
		return tituloTP;
	}


	public List<AlumnoDTO> getIntegrantes() {
		return integrantes;
	}


	public int getNotaDocFinal() {
		return notaDocFinal;
	}


	public Date getFechaEntregaDocFinal() {
		return fechaEntregaDocFinal;
	}


	public String getEstadoDocFinal() {
		return estadoDocFinal;
	}


	public List<String> getArchivosDocFinal() {
		return archivosDocFinal;
	}


	public List<String> getObsDocFinal() {
		return obsDocFinal;
	}
	
	
	
}