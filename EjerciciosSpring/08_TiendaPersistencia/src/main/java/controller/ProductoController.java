package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Producto;
import service.ProductoService;

@CrossOrigin("*")
@Controller
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping(value="Buscador", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Producto> buscar(@RequestParam("seccion") String seccion) {
		return productoService.buscarPorSeccion(seccion); 
	}
	
	@PostMapping(value = "Alta")
	public String añadirProducto(@ModelAttribute Producto product) {
		productoService.altaP(product);
		return "datos";
	}
	
	@GetMapping(value="Modificar")
	public String modificarProducto(@RequestParam("nombre") String nombre, @RequestParam("precio") double precio){
		productoService.modificarP(nombre,precio);
		return "modificar";
	}
	
	@GetMapping(value="Eliminar")
	public String eliminar(@RequestParam("nombre") String nombre){
		System.out.println(nombre);
		productoService.eliminarP(nombre);
		return "eliminar";
	}
	
	
}
