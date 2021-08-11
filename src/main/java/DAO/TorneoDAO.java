package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.Torneo;
import general.ConexionBD;
import general.DAO;
import general.DAOException;

public class TorneoDAO implements DAO<Torneo, String>{
	private final String INSERT = "INSERT INTO torneo(NombreTorneo,FechaTorneo,InstitucionAnfitriona) VALUES (?,?,?) "; //Fecha se inserta en formato YYYY-MM-DD
	
	
	@Override
	public Torneo obtenerModelo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object insertar(Torneo obj) throws DAOException {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        Integer clave = null;
	        try {
	            conn = ConexionBD.obtenerConexion();
	            stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	            stmt.setString(1, obj.getNombreTorneo());
	            stmt.setString(2, obj.getFechaTorneo());
	            stmt.setString(3, obj.getInstitucionAnfitriona());
	            stmt.executeUpdate();
	            rs = stmt.getGeneratedKeys();            
	            if (rs.next()) {
	                clave = rs.getInt(1);
	                obj.setId_torneo(clave);                
	            }
	            
	            return true;
	        } catch (SQLException ex) {
	            System.out.println("Error causado por: " + ex.getMessage());
	            return null;
	        } finally {
	            cerrarConnection(conn);
	            cerrarResultSet(rs);
	            cerrarStatement(stmt);
	        }
	}

	@Override
	public boolean modificar(Torneo obj) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Torneo obj) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Torneo> obtenerTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Torneo> obtenerTodos(String[] campos) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Torneo obtener(String id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
