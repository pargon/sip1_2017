package dto;

public class NumGrupoDTO {
	
	private int nroGrupo;
	private int id;
		
	public NumGrupoDTO(int nroGrupo, int id) {
		super();
		this.nroGrupo = nroGrupo;
		this.id = id;
	}

	public int getNroGrupo() {
		return nroGrupo;
	}

	public void setNroGrupo(int nroGrupo) {
		this.nroGrupo = nroGrupo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}