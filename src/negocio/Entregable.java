package negocio;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import enums.EstadoEntregable;

@Entity
public class Entregable implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Date fechaCarga;
	
	@Enumerated
	private EstadoEntregable estado;
	
	@ManyToOne
	@JoinColumn(name="identregable")
	private Archivo archivo;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="identregable")
	private List<ObservacionEntregable> observaciones;
	
	@OneToOne
	@JoinColumn(name="identrestr")
	private EntregableEstructura entregableestructura;

	public Entregable() {
		this.archivo = null;
		this.observaciones = new ArrayList<>();
		this.entregableestructura = null;
		this.estado = EstadoEntregable.NO_CARGADO;
		this.fechaCarga = new Date();
	}



	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	
	

	public EstadoEntregable getEstado() {
		return estado;
	}


	public void setEstado(EstadoEntregable estado) {
		this.estado = estado;
	}


	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
