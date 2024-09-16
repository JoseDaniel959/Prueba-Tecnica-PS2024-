package models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import play.db.Database;
public class BordilloRepository {
	private final Database db;

    @Inject
    public BordilloRepository(Database db) {
        this.db = db;
    }
    
    
    public List<Bordillo> obtenerBordillosDB() {
    	List<Bordillo> ListaBordillos = new ArrayList<>();
    	 String sql = "SELECT * FROM BORDILLO";
    	
    	 try (Connection connection = db.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                	Bordillo bordilloNuevo = new Bordillo();
		            bordilloNuevo.setId_bordillo(rs.getLong("id_bordillo"));
		            bordilloNuevo.setLongitud(rs.getLong("longitud"));
		            bordilloNuevo.setSegmento(rs.getLong("segmento"));
		            
		            ListaBordillos.add(bordilloNuevo);
                }

            } catch (SQLException e) {
                e.printStackTrace();  // Manejo básico de errores
            }
    	 return ListaBordillos;
    
    }
    
    
    public List<Bordillo> obtenerBordillosPorIdSegmentoDB(long id_segmento){
    	List<Bordillo> ListaBordillo = new ArrayList<>();
    	 String sql = "SELECT * FROM BORDILLO WHERE segmento = ?";
    
    	
    	
    	 try (Connection connection = db.getConnection();
    		     PreparedStatement stmt = connection.prepareStatement(sql)) {

    		 
    		    stmt.setLong(1, id_segmento);
    		    
    		  
    		    try (ResultSet rs = stmt.executeQuery()) {
    		        while (rs.next()) {
    		            Bordillo bordilloNuevo = new Bordillo();
    		            bordilloNuevo.setId_bordillo(rs.getLong("id_bordillo"));
    		            bordilloNuevo.setLongitud(rs.getLong("longitud"));
    		            bordilloNuevo.setSegmento(id_segmento);
    		            
    		            ListaBordillo.add(bordilloNuevo);
    		        }
    		    }
    		    
    		} catch (SQLException e) {
    		    e.printStackTrace();  
    		}
    	return ListaBordillo;
    }
    
    
    public void crearBordilloDB(Bordillo bordillo){
    	String sql = "INSERT INTO BORDILLO (id_bordillo, longitud, segmento) VALUES (?, ?, ?)";
    	
    	try (Connection connection = db.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

               stmt.setLong(1,bordillo.getId_bordillo());
               stmt.setLong(2, bordillo.getLongitud());
               stmt.setLong(3, bordillo.getSegmento());
               stmt.executeUpdate();

           } catch (SQLException e) {
               e.printStackTrace();  // Manejo básico de errores
           }
    	
    }
}
