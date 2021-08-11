package bo;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.TorneoDAO;
import dto.Torneo;
import general.DAOException;

@ManagedBean(name="torneoBO")
@SessionScoped
public class TorneoBO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Torneo torn;
	private TorneoDAO tornDAO;
	
	public TorneoBO() {
		tornDAO = new TorneoDAO();
		torn = new Torneo();
	}
	
	public List<Torneo> getTorneo(){
		try {
			return tornDAO.obtenerTodos();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String save() {
		try {
			if(torn.getId_torneo()==null || torn.getId_torneo()==0) {
				tornDAO.insertar(torn);
			}else {
				tornDAO.modificar(torn);
			}
			torn = new Torneo();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "CrearTorneo";
	}
	public String next() {
		return "Registro";
	}

	public Torneo getTorn() {
		return torn;
	}

	public void setEqui(Torneo torn) {
		this.torn =torn;
	}	
}