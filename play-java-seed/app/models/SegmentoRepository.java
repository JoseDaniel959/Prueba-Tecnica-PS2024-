package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import play.db.Database;

import javax.inject.Inject;
public class SegmentoRepository {
	 
	private final Database db;

	    @Inject
	    public SegmentoRepository(Database db) {
	        this.db = db;
	    }
	    
	    public List<Segmento> obtenerDatosSegmentoDB() {
	    	List<Segmento> segmentos = new ArrayList<>();
	    	 String sql = "SELECT * FROM SEGMENTO";
	    	
	    	 try (Connection connection = db.getConnection();
	                 PreparedStatement stmt = connection.prepareStatement(sql);
	                 ResultSet rs = stmt.executeQuery()) {

	                while (rs.next()) {
	                    Segmento segmento = new Segmento();
	                    segmento.setId_segmento((rs.getLong("id_segmento")));
	                    segmento.setLongitud(rs.getLong("longitud"));
	                    segmento.setDireccion(rs.getString("direccion"));
	                    segmentos.add(segmento);
	                }

	            } catch (SQLException e) {
	                e.printStackTrace();  // Manejo básico de errores
	            }
	    	 return segmentos;
	    
	    }
	    
	    public void crearSegmentoDB(Segmento segmento){
	    	String sql = "INSERT INTO SEGMENTO (id_segmento, longitud, direccion) VALUES (?, ?, ?)";
	    	
	    	try (Connection connection = db.getConnection();
	                PreparedStatement stmt = connection.prepareStatement(sql)) {

	               stmt.setLong(1, segmento.getId_segmento());
	               stmt.setLong(2, segmento.getLongitud());
	               stmt.setString(3, segmento.getDireccion());
	               stmt.executeUpdate();

	           } catch (SQLException e) {
	               e.printStackTrace();  // Manejo básico de errores
	           }
	    	
	    }
	    
	    public void borrarSegmentoDB(long id_segmento){
	    	String sql = "DELETE FROM SEGMENTO WHERE id_segmento = ?";
	    	try(Connection connection = db.getConnection();
	    		PreparedStatement stmt = connection.prepareStatement(sql)
	    			){
	    		 stmt.setLong(1,id_segmento);
	    		 stmt.executeUpdate();
	    		
	    		
	    	} catch (SQLException e) {
	               e.printStackTrace();  // Manejo básico de errores
	           }
	    }
	    
	    public void EditarSegmentoDB(Segmento segmento,long id){
	    	String sql_delete = "DELETE FROM SEGMENTO WHERE id_segmento = ?";
	    	String Segmento_nuevo = "INSERT INTO SEGMENTO (id_segmento, longitud, direccion) VALUES (?, ?, ?)";
	    	try(Connection connection = db.getConnection();
	    		PreparedStatement stmt = connection.prepareStatement(sql_delete);
	    		
	    			){
	    		 stmt.setLong(1,id);
	    		 stmt.executeUpdate();
	    		
	    		
	    	} catch (SQLException e) {
	               e.printStackTrace();  // Manejo básico de errores
	        }
	    	
	    	try(Connection connection = db.getConnection();
		    		PreparedStatement stmt = connection.prepareStatement(Segmento_nuevo);
		    		
		    			){
		    		 stmt.setLong(1,segmento.getId_segmento());
		    		 stmt.setLong(2,segmento.getLongitud());
		    		 stmt.setString(3, segmento.getDireccion());
		    		 stmt.executeUpdate();
		    		
		    		
		    	} catch (SQLException e) {
		               e.printStackTrace();  // Manejo básico de errores
		        }
	    	
	    	//String Segmento_nuevo = "INSERT INTO SEGMENTO (id_segmento, longitud, direccion) VALUES (?, ?, ?)";
	    	
	    }
	    	
	    
	    
	    

}
