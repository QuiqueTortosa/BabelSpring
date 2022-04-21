package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import model.Producto;
import service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("seccion") String seccion, HttpServletRequest request) {
		List<Producto> productos = productoService.buscarPorSeccion(seccion);
		request.setAttribute("productos", productos);
		return "listado";
	}
	
	@PostMapping(value = "Alta")
	public String añadirProducto(@ModelAttribute Producto product) {
		productoService.altaP(product);
		return "datos";
	}

	@GetMapping(value = "Eliminar")
	public String eliminarProducto(@RequestParam("nombre") String nombre) {
		productoService.eliminarP(nombre);
		return "datos";
	}
	
	
	@GetMapping(value="Modificar")
	public String modificarP(@RequestParam("nombre") String nombre, @RequestParam("precio") double precio) {
		productoService.modificarP(nombre,precio);
		return "inicio";
	}
}
