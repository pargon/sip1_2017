package dto;

public class AlumnoDTO {
	private int lu;
	private String nombre;
	private String apellido;
	private String notaA;
	private String notaB;

	public AlumnoDTO(int lu, String nombre, String apellido, String notaA,
			String notaB) {
		super();
		this.lu = lu;
		this.nombre = nombre;
		this.apellido = apellido;
		this.notaA = notaA;
		this.notaB = notaB;
	}

	public int getLu() {
		return lu;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNotaA() {
		return notaA;
	}

	public String getNotaB() {
		return notaB;
	}	

	
	
}
