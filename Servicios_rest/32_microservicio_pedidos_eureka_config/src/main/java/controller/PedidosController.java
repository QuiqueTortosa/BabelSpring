package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.PedidosService;

@CrossOrigin("*")
@RestController
public class PedidosController {
	
	@Autowired
	PedidosService service;
	
	@PostMapping(value="",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void pedir(@RequestBody Pedido pedido) {
		service.pedido(pedido);
	}
	
	@GetMapping(value="",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> pedidos(){
		return service.todosLosPedidos();
	}
	
}
