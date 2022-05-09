package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import service.VuelosService;

@CrossOrigin("*")
@RestController
public class VuelosController {
	
	@Autowired
	VuelosService service;
	
	@GetMapping(value ="Vuelos/{plazas}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> buscarVuelos(@PathVariable("plazas") int plazas){
		return service.vuelosPorPlazas(plazas);
	}
	
	@GetMapping(value ="Vuelos/find/{idVuelo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Vuelo buscarVuelosPorId(@PathVariable("idVuelo") int idVuelo){
		return service.buscarVuelo(idVuelo);
	}
	
	@PutMapping(value="Vuelo",produces=MediaType.APPLICATION_JSON_VALUE)
	public String actualizar(@RequestParam("idVuelo") int idVuelo,@RequestParam("plazas") int plazas) {
		return String.valueOf(service.actualizarVuelo(idVuelo, plazas));
	}
	
}
