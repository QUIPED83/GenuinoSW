package bo;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.EquipoDAO;
import dto.Equipo;
import general.DAOException;

@ManagedBean(name="equipoBO")
@SessionScoped
public class EquipoBO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Equipo equi;
	private EquipoDAO equiDAO;
	
	public EquipoBO() {
		equiDAO = new EquipoDAO();
		equi = new Equipo();
	}
	
	public List<Equipo> getEquipo(){
		try {
			return equiDAO.obtenerTodos();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String save() {
		try {
			if(equi.getId_equipo()==null || equi.getId_equipo()==0) {
				equiDAO.insertar(equi);
			}else {
				equiDAO.modificar(equi);
			}
			equi = new Equipo();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Registro";
	}
	
	public String next() {
		
		return "prototipo";
	}
	public Equipo getEqui() {
		return equi;
	}

	public void setEqui(Equipo equi) {
		this.equi =equi;
	}	
}