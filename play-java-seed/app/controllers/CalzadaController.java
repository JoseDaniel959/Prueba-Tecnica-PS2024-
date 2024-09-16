package controllers;
import play.mvc.*;
import models.Calzada;
import models.CalzadaRepository;


import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
public class CalzadaController extends Controller {
	
	private final CalzadaRepository Repositorio;
	 
	@Inject
    public CalzadaController(CalzadaRepository Repositorio) {
        this.Repositorio = Repositorio;
    }
	
	public Result obtenerCalzadas(){
		List<Calzada> Calzadas = Repositorio.obtenerCalzadasDB();
		return ok(play.libs.Json.toJson(Calzadas));
	}
	
	public Result crearCalzadasAsociadoSegmento(Http.Request request){
		JsonNode json_calzadas = request.body().asJson().findValue("calzadas");
		for(JsonNode json_calzada:json_calzadas) {
			long id_calzada = json_calzada.findValue("id_calzada").asLong();
			long longitud = json_calzada.findValue("longitud").asLong();
			long segmento = json_calzada.findValue("segmento").asLong();
			Calzada CalzadaNueva = new Calzada(id_calzada,longitud,segmento);
			Repositorio.crearCalzadaDB(CalzadaNueva);
		}
		
		
	
		return ok("Bordillo creado con exito");
	}

}
