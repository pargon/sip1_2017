package negocio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Entregable implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Date fechaCarga;
	private String estado;
	
	@OneToMany
	@JoinColumn(name="identregable")
	private List<Archivo> archivos;
	
	@OneToMany
	@JoinColumn(name="identregable")
	private List<ObservacionEntregable> observaciones;
	
	@OneToOne
	@JoinColumn(name="identrestr")
	private EntregableEstructura entregableestructura;

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
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

	public List<ObservacionEntregable> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(List<ObservacionEntregable> observaciones) {
		this.observaciones = observaciones;
	}

	public EntregableEstructura getEntregableestructura() {
		return entregableestructura;
	}

	public void setEntregableestructura(EntregableEstructura entregableestructura) {
		this.entregableestructura = entregableestructura;
	}
}
