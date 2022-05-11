package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisesService;

@CrossOrigin("*")
@RestController
public class PaisController {
	
	@Autowired
	PaisesService service;
	
	@GetMapping(value="Continentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.continentes();
	}
	
	@GetMapping(value="PaisPorContinentes/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesPorContinente(@PathVariable("continente") String continente){
		return service.paisesPorContinente(continente);
	}
	
	@GetMapping(value="HabitantesContinentes/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public long habitantesContinente(@PathVariable("continente") String continente){
		return service.habitantesContinente(continente);
	}
}
