package dto;

public class Torneo {
private Integer id_torneo;
private String NombreTorneo;
private String FechaTorneo;
private String InstitucionAnfitriona;

public Torneo() {}


public Integer getId_torneo() {
	return id_torneo;
}
public void setId_torneo(Integer id_torneo) {
	this.id_torneo = id_torneo;
}
public String getNombreTorneo() {
	return NombreTorneo;
}
public void setNombreTorneo(String nombreTorneo) {
	NombreTorneo = nombreTorneo;
}
public String getFechaTorneo() {
	return FechaTorneo;
}
public void setFechaTorneo(String fechaTorneo) {
	FechaTorneo = fechaTorneo;
}


public String getInstitucionAnfitriona() {
	return InstitucionAnfitriona;
}


public void setInstitucionAnfitriona(String institucionAnfitriona) {
	InstitucionAnfitriona = institucionAnfitriona;
}


}
