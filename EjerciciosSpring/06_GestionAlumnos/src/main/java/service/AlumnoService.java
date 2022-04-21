package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {
	
	List<Alumno> buscarPorCurso(String cursos);
	void altaAlumno (Alumno alumno);
	Alumno buscarPorNombre(String nombre);
	
}
