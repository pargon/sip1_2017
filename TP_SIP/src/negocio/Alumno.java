package negocio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alumno{
	@Id
	private int lu;
	
	private String nombre;
	private String apellido;
	private String notaA;
	private String notaB;
	public int getLu() {
		return lu;
	}
	public void setLu(int lu) {
		this.lu = lu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNotaA() {
		return notaA;
	}
	public void setNotaA(String notaA) {
		this.notaA = notaA;
	}
	public String getNotaB() {
		return notaB;
	}
	public void setNotaB(String notaB) {
		this.notaB = notaB;
	}
	
}
