package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController{

	@Autowired FormacionService formacionService;
	
	@GetMapping(value="Alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> findAllAlumnos() {
		return formacionService.alumnos();
	}
	
	@GetMapping(value="Cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> findAllCursos() {
		return formacionService.cursos();
	}
	
	@GetMapping(value="findAlumnosByCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> findAlumnosByCursos(@RequestParam("nombre") String nombre) {
		return formacionService.matriculadosPorCurso(nombre);
	}
	
	@GetMapping(value="findCursosByAlumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> findCursosByAlumnos(@RequestParam("usuario") String usuario) {
		return formacionService.cursosMatriculado(usuario);
	}
	
	@PostMapping(value="Login")
	public String login(@RequestParam("usuario")String usuario, @RequestParam("password") String password, HttpSession sesion, HttpServletRequest request) {
		Alumno alumno = formacionService.login(usuario, password);
		if(alumno != null) {
			sesion.setAttribute("alumno", alumno);
			return "menu";
			}
		else {
			request.setAttribute("mensaje", "Usuario y/o contraseña incorrectos");
			return "error";
		}
	}
	
}
