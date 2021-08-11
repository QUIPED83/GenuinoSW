package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import dto.Prototipo;
import general.ConexionBD;
import general.DAO;
import general.DAOException;

public class PrototipoDAO implements DAO<Prototipo, String>{
	 private final String GETALL = "SELECT * FROM prototipo WHERE Tiempo IS NULL";
	 private final String GETALL2 = "SELECT * FROM prototipo WHERE Tiempo IS NOT NULL ORDER BY Tiempo ASC";
	 private final String INSERT = "INSERT INTO prototipo(NombrePrototipo,Categoria,id_equipo,id_torneo) VALUES (?,?,?,?) ";
	 private final String UPDATE = "UPDATE prototipo SET Tiempo = ? WHERE NombrePrototipo = ?"; 
	 private final String DELETE = "DELETE FROM prototipo WHERE NombrePrototipo = ?";
	 private final String GETONE = "SELECT * FROM prototipo WHERE NombrePrototipo = ?";

	@Override
	public Object insertar(Prototipo obj) throws DAOException {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	       Integer clave = null;
	        try {
	            conn = ConexionBD.obtenerConexion();
	            stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	            stmt.setString(1, obj.getNombrePrototipo());
	            stmt.setString(2, obj.getCategoria());
	            stmt.setInt(3, obj.getId_equipo());
	            stmt.setInt(4, obj.getId_torneo());
	            stmt.executeUpdate();
	            rs = stmt.getGeneratedKeys();            
	            if (rs.next()) {
	                clave = rs.getInt(1);
	                obj.setId_prototipo(clave);                
	            }
	            return clave;
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
	public boolean modificar(Prototipo obj) throws DAOException {
		return false;	
	}

	public boolean modificar2(Prototipo obj, String tiempo) throws DAOException {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            conn = ConexionBD.obtenerConexion();
	            stmt = conn.prepareStatement(UPDATE);
	            stmt.setString(1, tiempo);
	            stmt.setString(2, obj.getNombrePrototipo());
	            return stmt.executeUpdate() == 0;
	        } catch (SQLException ex) {
	            System.out.println("Error causado por: " + ex.getMessage());
	            return false;
	        } finally {
	            cerrarConnection(conn);
	            cerrarResultSet(rs);
	            cerrarStatement(stmt);
	        }
	}

	@Override
	public boolean eliminar(Prototipo obj) throws DAOException {
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            conn = ConexionBD.obtenerConexion();
	            stmt = conn.prepareStatement(DELETE);
	            stmt.setString(1, obj.getNombrePrototipo());
	            return stmt.executeUpdate() == 0;
	        } catch (SQLException ex) {
	            System.out.println("Error causado por: " + ex.getMessage());
	            return false;
	        } finally {
	            cerrarConnection(conn);
	            cerrarResultSet(rs);
	            cerrarStatement(stmt);
	        }
	}

	@Override
	public List<Prototipo> obtenerTodos() throws DAOException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Prototipo> prototipos = new ArrayList<Prototipo>();
        try {
            conn = ConexionBD.obtenerConexion();
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
               prototipos.add((Prototipo) convertir(rs, new Prototipo()));
            }
            return prototipos;
        } catch (SQLException | IllegalArgumentException | IllegalAccessException | DAOException ex) {
            System.out.println("Error causado por: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        } finally {
        	//alumnos.stream().forEach((e)->{System.out.println(e.getId());});
            cerrarConnection(conn);
            cerrarResultSet(rs);
            cerrarStatement(stmt);
        }
	}
	
	
	public List<Prototipo> obtenerTodosFinalizados() throws DAOException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Prototipo> prototipos = new ArrayList<Prototipo>();
        try {
            conn = ConexionBD.obtenerConexion();
            stmt = conn.prepareStatement(GETALL2);
            rs = stmt.executeQuery();
            while (rs.next()) {
               prototipos.add((Prototipo) convertir(rs, new Prototipo()));
            }
            return prototipos;
        } catch (SQLException | IllegalArgumentException | IllegalAccessException | DAOException ex) {
            System.out.println("Error intentando obtener finalizados por: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        } finally {
        	//alumnos.stream().forEach((e)->{System.out.println(e.getId());});
            cerrarConnection(conn);
            cerrarResultSet(rs);
            cerrarStatement(stmt);
        }
	}

	@Override
	public List<Prototipo> obtenerTodos(String[] campos) throws DAOException {
		int numero_campos;
        String select;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Prototipo> peliculas = new ArrayList<Prototipo>();
        try {
            numero_campos = campos.length;
            select = prepararSelect(campos, numero_campos);
            conn = ConexionBD.obtenerConexion();
            stmt = conn.prepareStatement(select);
            rs = stmt.executeQuery();
            while (rs.next()) {
                peliculas.add((Prototipo) convertir(rs, new Prototipo(), campos));
            }
            return peliculas;
        } catch (SQLException | IllegalArgumentException | IllegalAccessException | DAOException ex) {
            System.out.println("Error causado por: " + ex.getMessage());
            return null;
        } finally {
            cerrarConnection(conn);
            cerrarResultSet(rs);
            cerrarStatement(stmt);
        }
	}

	@Override
	public Prototipo obtener(String nombre) throws DAOException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Prototipo prototi = null;
        try {
            conn = ConexionBD.obtenerConexion();
            stmt = conn.prepareStatement(GETONE);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
              prototi = (Prototipo) convertir(rs, new Prototipo());
            } else {
                System.out.println("No se encontro el prototipo en la base de datos");
            }
            return prototi;
        } catch (SQLException | IllegalArgumentException | IllegalAccessException | DAOException ex) {
            System.out.println("Error causado por: " + ex.getMessage());
            return null;
        } finally {
            cerrarConnection(conn);
            cerrarResultSet(rs);
            cerrarStatement(stmt);
        }
	}
	 public Prototipo obtenerModelo() {
	        return new Prototipo();
	    }
	private String prepararSelect(String campos[], int numero_campos){
     String select = "SELECT ";
     for (int i = 0; i < numero_campos - 1; i++) {
         select = select.concat(campos[i]) + ", ";
     }
     select = select.concat(campos[numero_campos - 1]);
     select = select.concat(" FROM prototipo;");
     return select;
 }

}
