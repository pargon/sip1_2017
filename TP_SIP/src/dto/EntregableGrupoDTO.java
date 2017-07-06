package dto;

import java.util.Date;

import enums.EstadoEntregable;

public class EntregableGrupoDTO {

	private int idEntregable;
	private int nroGrupo;
	private String nombreIteracion;
	private String nombreEtapa;
	private String nombreEntregable;
	private Date fechaCarga;
	private Date fechaEntrega;
	private EstadoEntregable estado;
	private String comentario;
	private Date fechaObs;
	private String nombreArchivo;
	private String rutaArchivo;
	
	public EntregableGrupoDTO() {}

	public int getIdEntregable() {
		return idEntregable;
	}

	public void setIdEntregable(int idEntregable) {
		this.idEntregable = idEntregable;
	}

	public int getNroGrupo() {
		return nroGrupo;
	}

	public void setNroGrupo(int nroGrupo) {
		this.nroGrupo = nroGrupo;
	}

	public String getNombreIteracion() {
		return nombreIteracion;
	}

	public void setNombreIteracion(String nombreIteracion) {
		this.nombreIteracion = nombreIteracion;
	}

	public String getNombreEtapa() {
		return nombreEtapa;
	}

	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}

	public String getNombreEntregable() {
		return nombreEntregable;
	}

	public void setNombreEntregable(String nombreEntregable) {
		this.nombreEntregable = nombreEntregable;
	}

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public EstadoEntregable getEstado() {
		return estado;
	}

	public void setEstado(EstadoEntregable estado) {
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaObs() {
		return fechaObs;
	}

	public void setFechaObs(Date fechaObs) {
		this.fechaObs = fechaObs;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	
	
	
	
}
