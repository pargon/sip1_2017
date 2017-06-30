package negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Etapa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int nroOrden;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="iditeracion")
	private Iteracion iteracion;
	
	@OneToMany
	@JoinColumn(name="idetapa")
	private List<EntregableEstructura> entregablesEstruc;

	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Iteracion getIteracion() {
		return iteracion;
	}

	public void setIteracion(Iteracion iteracion) {
		this.iteracion = iteracion;
	}

	public List<EntregableEstructura> getEntregablesEstruc() {
		return entregablesEstruc;
	}

	public void setEntregablesEstruc(List<EntregableEstructura> entregablesEstruc) {
		this.entregablesEstruc = entregablesEstruc;
	}
	
}
