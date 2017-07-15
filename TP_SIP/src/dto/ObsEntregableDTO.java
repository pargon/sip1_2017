package dto;

import java.util.Date;

public class ObsEntregableDTO {

	private String comentario;
	private Date fecha;
	
	
	public ObsEntregableDTO(String comentario, Date fecha) {
		super();
		this.comentario = comentario;
		this.fecha = fecha;
	}
	public String getComentario() {
		return comentario;
	}
	public Date getFecha() {
		return fecha;
	}
	
}
