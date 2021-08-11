package dto;

public class Integrante {
	private String Nombre;
	private String ApPaterno;
	private String ApMaterno;
	private Integer edad;
	private Integer id_equipo;
	
	Integrante(){}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApPaterno() {
		return ApPaterno;
	}

	public void setApPaterno(String apPaterno) {
		ApPaterno = apPaterno;
	}

	public String getApMaterno() {
		return ApMaterno;
	}

	public void setApMaterno(String apMaterno) {
		ApMaterno = apMaterno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getId_equipo() {
		return id_equipo;
	}

	public void setId_equipo(Integer id_equipo) {
		this.id_equipo = id_equipo;
	}
	
	
}
