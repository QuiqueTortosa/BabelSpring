package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import service.AlumnoService;

@Controller
public class AlumnoController {
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping(value="Buscador", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscar(@RequestParam("curso") String curso) {
		return alumnoService.buscarPorCurso(curso);
	}
	
	@PostMapping(value = "Alta")
	public String a�adirAlumno(@ModelAttribute Alumno alumno) {
		alumnoService.altaAlumno(alumno);
		return "datos";
	}
}
