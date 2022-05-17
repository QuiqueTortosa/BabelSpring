package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;

@CrossOrigin("*")
@RestController
public class ProductosController {

	@Autowired
	ProductosService service;
	
	@GetMapping(value ="/{codigo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public double precioUnitarioProducto(@PathVariable("codigo") int codigoProducto){
		return service.precioUnitarioProducto(codigoProducto);
	}
	
	@GetMapping(value ="",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> buscarProductosExistentes(){
		return service.productosExistentes();
	}
	
	@PutMapping(value="/{codigo}/{unidades}",produces=MediaType.APPLICATION_JSON_VALUE)
	public String actualizar(@PathVariable("codigo") int codigoProducto,@PathVariable("unidades") int unidades) {
		return String.valueOf(service.actualizarProducto(codigoProducto, unidades));
	}
	
}
