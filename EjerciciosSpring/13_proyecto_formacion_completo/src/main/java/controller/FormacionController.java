package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	
	@PostMapping(value="AltaUsuario")
	public String altaUsuario(@ModelAttribute Alumno alumno, HttpSession sesion, HttpServletRequest request) {
		System.out.println(alumno);
		boolean alta = formacionService.altaAlumno(alumno);
		if(alta) {
			request.setAttribute("mensaje", "Usuario añadido");
			return "menu";
		}else {
			request.setAttribute("mensaje", "Usuario y/o contraseña incorrectos");
			return "AltaAlumno";
		}
	}
	
	@PostMapping(value="AltaCurso")
	public String altaUsuario(@ModelAttribute Curso curso,HttpSession sesion, HttpServletRequest request) {
		boolean alta = formacionService.altaCurso(curso);
		if(alta) {
			request.setAttribute("mensaje", "Usuario añadido");
			return "menu";
		}else {
			request.setAttribute("mensaje", "Usuario y/o contraseña incorrectos");
			return "AltaCurso";
		}
	}
	
	@GetMapping(value="CursosSinMatricular", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> findCursosSinMatricular(@RequestParam("usuario") String usuario) {
		return formacionService.cursosSinMatricular(usuario);
	}
	
	@GetMapping(value="ConsultaMatriculas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> findCursos(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, 
												@RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		return formacionService.consultarMatriculas(start,end);
	}
	
}
