package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int nroGrupo;
	private String estadoTP;
	private String tituloTP;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idgrupo")
	private List<Alumno> integrantes;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idgrupo")
	private List<Entregable> entregables;
	
	@OneToOne
	@JoinColumn(name="iddocfinal")
	private DocumentoFinal docFinal;
	
	public Grupo() {
		this.integrantes = new ArrayList<>();
		this.entregables = new ArrayList<>();
		this.docFinal = new DocumentoFinal();
	}
	
	
	public Grupo(int nroGrupo, String tituloTP) {
		super();
		this.estadoTP = "Inicial";
		this.nroGrupo = nroGrupo;
		this.tituloTP = tituloTP;
	}



	public int getNroGrupo() {
		return nroGrupo;
	}

	public void setNroGrupo(int nroGrupo) {
		this.nroGrupo = nroGrupo;
	}

	public String getEstadoTP() {
		return estadoTP;
	}

	public void setEstadoTP(String estadoTP) {
		this.estadoTP = estadoTP;
	}

	public String getTituloTP() {
		return tituloTP;
	}

	public void setTituloTP(String tituloTP) {
		this.tituloTP = tituloTP;
	}

	public List<Alumno> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Alumno> integrantes) {
		this.integrantes = integrantes;
	}

	public List<Entregable> getEntregables() {
		return entregables;
	}

	public void setEntregables(List<Entregable> entregables) {
		this.entregables = entregables;
	}

	public DocumentoFinal getDocFinal() {
		return docFinal;
	}

	public void setDocFinal(DocumentoFinal docFinal) {
		this.docFinal = docFinal;
	}
	
}
