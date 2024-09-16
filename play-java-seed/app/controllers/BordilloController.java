package controllers;
import play.mvc.*;
import models.Bordillo;
import models.BordilloRepository;


import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
public class BordilloController extends Controller {
	private final BordilloRepository Repositorio;
	 
		@Inject
	    public BordilloController(BordilloRepository Repositorio) {
	        this.Repositorio = Repositorio;
	    }
		
		public Result obtenerBordillosPorIDSegmento(long id_segmento){
			 List<Bordillo> bordillos = Repositorio.obtenerBordillosPorIdSegmentoDB(id_segmento);
		     return ok(play.libs.Json.toJson(bordillos));
			
		}
		
		public Result obtenerBordillos(){
			List<Bordillo> bordillos = Repositorio.obtenerBordillosDB();
		    return ok(play.libs.Json.toJson(bordillos));
		}
		
		public Result crearBordillosAsociadoSegmento(Http.Request request){
			JsonNode json_bordillos = request.body().asJson().findValue("bordillos");
			for(JsonNode json_bordillo:json_bordillos) {
				long id_bordillo = json_bordillo.findValue("id_bordillo").asLong();
				long longitud = json_bordillo.findValue("longitud").asLong();
				long segmento = json_bordillo.findValue("segmento").asLong();
				Bordillo bordilloNuevo = new Bordillo(id_bordillo,longitud,segmento);
				Repositorio.crearBordilloDB(bordilloNuevo);
			}
			
			
		
			return ok("Bordillo creado con exito");
		}
		
		
		
}
