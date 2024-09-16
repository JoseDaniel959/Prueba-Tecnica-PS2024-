package models;

public class Bordillo {
	long id_bordillo;
	long longitud;
	long segmento;
	
	public Bordillo(){
		
	}
	
	public Bordillo(long id_bordillo, long longitud, long segmento) {
		super();
		this.id_bordillo = id_bordillo;
		this.longitud = longitud;
		this.segmento = segmento;
	}

	public long getId_bordillo() {
		return id_bordillo;
	}

	public void setId_bordillo(long id_bordillo) {
		this.id_bordillo = id_bordillo;
	}

	public long getLongitud() {
		return longitud;
	}

	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}

	public long getSegmento() {
		return segmento;
	}

	public void setSegmento(long segmento) {
		this.segmento = segmento;
	}

	
	

}
