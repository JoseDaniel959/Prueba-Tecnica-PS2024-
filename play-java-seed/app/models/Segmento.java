package models;

public class Segmento {
	private Long id_segmento;
	private Long longitud;
	private String direccion;
	
	
	public Segmento(){
		
	}
	
	public Segmento(Long id_segmento, Long longitud, String direccion) {
		super();
		this.id_segmento = id_segmento;
		this.longitud = longitud;
		this.direccion = direccion;
	}


	public Long getId_segmento() {
		return id_segmento;
	}


	public void setId_segmento(Long id_segmento) {
		this.id_segmento = id_segmento;
	}


	public Long getLongitud() {
		return longitud;
	}


	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	
}
