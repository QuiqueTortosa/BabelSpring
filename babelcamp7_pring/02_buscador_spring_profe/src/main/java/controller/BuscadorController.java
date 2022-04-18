package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {

	@Autowired //Injecta una dependencia
	BuscadorService buscadorService;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("tema") String tematica, HttpServletRequest request) {
		List<Pagina> paginas = buscadorService.buscar(tematica);
		request.setAttribute("paginas", paginas);
		return "listado";
	}
	
	/*@PostMapping(value="AddPag")
	public String addPag(@RequestParam("direccion") String direccion, @RequestParam("tematica") String tematica, @RequestParam("descripcion")  String descripcion) {
		buscadorService.addPag(new Pagina(direccion,tematica,descripcion));
		return "datos";
	}*/
	
	@PostMapping(value="AddPag")
	public String addPag(@ModelAttribute Pagina pagina) {
		buscadorService.addPag(pagina);
		return "datos";
	}
}
