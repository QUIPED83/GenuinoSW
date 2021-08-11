package dto;
import java.sql.Time;
public class Prototipo {
	private Integer id_prototipo;
	private String NombrePrototipo;
	private Integer isEliminado;
	private String Categoria;
	private Time Tiempo;
	private Integer id_equipo;
	private Integer id_torneo;
	
	public Prototipo() {}

	public Integer getId_prototipo() {
		return id_prototipo;
	}

	public void setId_prototipo(Integer id_prototipo) {
		this.id_prototipo = id_prototipo;
	}

	public String getNombrePrototipo() {
		return NombrePrototipo;
	}

	public void setNombrePrototipo(String nombrePrototipo) {
		NombrePrototipo = nombrePrototipo;
	}

	public Integer isEliminado() {
		return isEliminado;
	}

	public void setEliminado(Integer isEliminado) {
		this.isEliminado = isEliminado;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public Time getTiempo() {
		return Tiempo;
	}

	public void setTiempo(Time tiempo) {
		Tiempo = tiempo;
	}

	public Integer getId_equipo() {
		return id_equipo;
	}

	public Integer getId_torneo() {
		return id_torneo;
	}

	public void setId_torneo(Integer id_torneo) {
		this.id_torneo = id_torneo;
	}

	public Integer getIsEliminado() {
		return isEliminado;
	}

	public void setIsEliminado(Integer isEliminado) {
		this.isEliminado = isEliminado;
	}

	public void setId_equipo(Integer id_equipo) {
		this.id_equipo = id_equipo;
	}
	
	
	
}
