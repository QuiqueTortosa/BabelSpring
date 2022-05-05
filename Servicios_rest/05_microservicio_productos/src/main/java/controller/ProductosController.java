package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;

@RestController
public class ProductosController {
	@Autowired
	ProductosService service;
	@PostMapping(value="Producto",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaProducto(@RequestBody Producto producto) {
		service.altaProducto(producto);
	}
	
	@DeleteMapping(value="Producto/{id}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String eliminar(@PathVariable("id") int id) {
		return String.valueOf(service.eliminarProducto(id));
	}
	@GetMapping(value="Productos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos(){
		return service.todosProducto();
	}
	@GetMapping(value="Productos/{seccion}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> buscarProducto(@PathVariable("seccion") String seccion){
		return service.buscarProductos(seccion);
	}

}
