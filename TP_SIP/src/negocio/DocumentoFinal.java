package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class DocumentoFinal implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int nota;
	private Date fechaEntrega;
	private String estado;

	@OneToMany
	@JoinColumn(name="iddocfinal")
	private List<Archivo> archivos;
	
	@OneToMany
	@JoinColumn(name="iddocfinal")
	private List<ObservacionFinal> observaciones;
	
	
	public DocumentoFinal() {
		super();
		nota = 0;
		fechaEntrega = null;
		estado = "En Curso";
		archivos = new ArrayList<Archivo>();
		observaciones = new ArrayList<ObservacionFinal>();
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<Archivo> getArchivos() {
		return archivos;
	}
	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}
	public List<ObservacionFinal> getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(List<ObservacionFinal> observaciones) {
		this.observaciones = observaciones;
	}
}
