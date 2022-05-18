package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Double> precioUnitarioProducto(@PathVariable("codigo") int codigoProducto){
		return new ResponseEntity <>(service.precioUnitarioProducto(codigoProducto), HttpStatus.OK);
	}
	
	@GetMapping(value ="",produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<Producto>> buscarProductosExistentes(){
		return new ResponseEntity <>(service.productosExistentes(), HttpStatus.OK);
	}
	
	@PutMapping(value="/{codigo}/{unidades}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> actualizar(@PathVariable("codigo") int codigoProducto,@PathVariable("unidades") int unidades) {
		if(service.actualizarProducto(codigoProducto, unidades)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
	}
	
}
