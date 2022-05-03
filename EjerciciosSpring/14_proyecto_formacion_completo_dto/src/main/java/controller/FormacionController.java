package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;
import service.FormacionService;

@Controller
public class FormacionController {
	@Autowired
	FormacionService formacionService;
	
	@GetMapping(value="Alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> alumnos() {
		return formacionService.alumnos();
	}
	@GetMapping(value="findAlumnosByCurso",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> alumnosCurso(@RequestParam("nombre") String nombreCurso) {
		
		return formacionService.matriculadosPorCurso(nombreCurso);
	}
	@GetMapping(value="findCursosByAlumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> cursosAlumno(@RequestParam("usuario") String usuario)  {
		
		return formacionService.cursosMatriculado(usuario);
	}
	@GetMapping(value="Cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> cursos( ) {		
		return formacionService.cursos();
	}
	@PostMapping(value="Login")
	public String login(@RequestParam("usuario")String usuario, @RequestParam("password") String password, HttpSession sesion, HttpServletRequest request) {
		AlumnoDto alumno = formacionService.login(usuario, password);
		if(alumno != null) {
			sesion.setAttribute("alumno", alumno);
			return "menu";
			}
		else {
			request.setAttribute("mensaje", "Usuario y/o contraseña incorrectos");
			return "error";
		}
	}
	@PostMapping("AltaCurso")
	public String altaCurso(@ModelAttribute CursoDto curso) {
		return formacionService.altaCurso(curso)?"menu":"altaCurso";
	}
	@PostMapping("AltaAlumno")
	public String altaAlumno(@ModelAttribute AlumnoDto alumno) {
		return formacionService.altaAlumno(alumno)?"menu":"altaAlumno";
	}

	@GetMapping(value="ConsultaMatriculas",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> matriculas(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, 
												@RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
		
			return formacionService.consultarMatriculas(start, end);
		
	}
}

