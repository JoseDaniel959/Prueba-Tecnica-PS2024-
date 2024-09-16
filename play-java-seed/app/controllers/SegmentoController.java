package controllers;
import play.mvc.*;
import models.Segmento;
import models.SegmentoRepository;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
public class SegmentoController extends Controller {
	 
	private final SegmentoRepository Repositorio;

	    @Inject
	    public SegmentoController(SegmentoRepository Repositorio) {
	        this.Repositorio = Repositorio;
	    }
	    
	    public Result obtenerSegmentos() {
	        List<Segmento> segmentos = Repositorio.obtenerDatosSegmentoDB();
	        return ok(play.libs.Json.toJson(segmentos));
	    }
	   
	    @BodyParser.Of(BodyParser.Json.class)
	    public Result crearSegmento(Http.Request request){
	    	JsonNode json = request.body().asJson();
	    	long id_segmento = json.findPath("id_segmento").asLong();
	    	long longitud = json.findPath("longitud").asLong();
	    	String direccion = json.findPath("direccion").textValue();
	    	Segmento nuevoSegmento = new Segmento(id_segmento,longitud,direccion);
	    	Repositorio.crearSegmentoDB(nuevoSegmento);
	        return ok("Usuario creado con éxito " + json);
	    }
	    
	    
	    public Result borrarSegmentoPorId(long id){
	    	Repositorio.borrarSegmentoDB(id);
	    	return ok("Usuario Borrado con éxito");
	    	
	    	
	    }
	    
	    public Result EditarSegmento(Http.Request request) {

	    	
	    	JsonNode json = request.body().asJson();
	    	long id_segmento = json.findPath("id_segmento").asLong();
	    	long longitud = json.findPath("longitud").asLong();
	    	String direccion = json.findPath("direccion").textValue();
	    	Segmento nuevoSegmento = new Segmento(id_segmento,longitud,direccion);
	    	Repositorio.crearSegmentoDB(nuevoSegmento);
	    	return ok("Usuario Editado con éxito");
	    }
	    
	    
	    
	    
	    
}
