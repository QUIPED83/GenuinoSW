package bo;
import java.io.Serializable;
import java.util.List;
import java.sql.Time;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import DAO.PrototipoDAO;
import dto.Prototipo;
import general.DAOException;

@ManagedBean(name="prototipoBO")
@SessionScoped
public class PrototipoBO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Prototipo proto;
	private PrototipoDAO protoDAO;
	
	public PrototipoBO() {
		protoDAO = new PrototipoDAO();
		proto = new Prototipo();
	}
	
	public List<Prototipo> getPrototipo(){
		try {
			return protoDAO.obtenerTodos();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Prototipo> getPrototipoFin(){
		try {
			return protoDAO.obtenerTodosFinalizados();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String edit(String nombreProto) {
		try {
			proto = protoDAO.obtener(nombreProto);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "carro";
	}
	
	public String save() {
		try {
			if(proto.getId_prototipo()==null || proto.getId_prototipo()==0) {
				protoDAO.insertar(proto);
			}
			proto = new Prototipo();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "prototipo";
	}
	public String save(String tiempo) {
		try {
			if(proto.getId_prototipo()==null || proto.getId_prototipo()==0) {
				protoDAO.insertar(proto);
			}else {
				protoDAO.modificar2(proto,tiempo);
			}
			proto = new Prototipo();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "carro";
	}

	public String eliminar(String NombrePrototipo) {
		try {
			proto = protoDAO.obtener(NombrePrototipo);
			protoDAO.eliminar(proto);
			proto = new Prototipo();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return "carro";
	}

	public String next() {
	return "menu";
	}
	public Prototipo getProto() {
		return proto;
	}

	public void setProto(Prototipo proto) {
		this.proto =proto;
	}	
}