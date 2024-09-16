package models;

public class Calzada {
	long id_calzada;
	long longitud;
	long segmento;
	
	
	public Calzada(){
		
	}
	
	public Calzada(long id_calzada, long longitud, long segmento) {
		super();
		this.id_calzada = id_calzada;
		this.longitud = longitud;
		this.segmento = segmento;
	}
	

	public long getId_calzada() {
		return id_calzada;
	}

	public void setId_calzada(long id_calzada) {
		this.id_calzada = id_calzada;
	}

	public long getSegmento() {
		return segmento;
	}

	public void setSegmento(long segmento) {
		this.segmento = segmento;
	}

	public long getLongitud() {
		return longitud;
	}

	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}


	
	
	
}
