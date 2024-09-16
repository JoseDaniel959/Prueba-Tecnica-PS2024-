package models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import play.db.Database;
public class CalzadaRepository {
	private final Database db;

    @Inject
    public CalzadaRepository(Database db) {
        this.db = db;
    }
    
    public List<Calzada> obtenerCalzadasDB() {
    	List<Calzada> ListaCalzada = new ArrayList<>();
    	 String sql = "SELECT * FROM CALZADA";
    	
    	 try (Connection connection = db.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                	Calzada CalzadaNuevo = new Calzada();
                	CalzadaNuevo.setId_calzada(rs.getLong("id_calzada"));;
                	CalzadaNuevo.setLongitud(rs.getLong("longitud"));
                	CalzadaNuevo.setSegmento(rs.getLong("segmento"));
		            
                	ListaCalzada.add(CalzadaNuevo);
                }

            } catch (SQLException e) {
                e.printStackTrace();  // Manejo básico de errores
            }
    	 return ListaCalzada;
    
    }
    
    public void crearCalzadaDB(Calzada calzada){
    	String sql = "INSERT INTO CALZADA (id_calzada, longitud, segmento) VALUES (?, ?, ?)";
    	
    	try (Connection connection = db.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
    			
               stmt.setLong(1,calzada.getId_calzada());
               stmt.setLong(2, calzada.getLongitud());
               stmt.setLong(3, calzada.getSegmento());
               stmt.executeUpdate();

           } catch (SQLException e) {
               e.printStackTrace();  // Manejo básico de errores
           }
    	
    }
}
