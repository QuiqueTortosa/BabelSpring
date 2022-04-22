package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {
	
	/**
	 * 
	 * @param cursos
	 * @return los alumnos del curso
	 */
	List<Alumno> buscarPorCurso(String cursos);
	
	/**
	 * Añade un nuevo usuario
	 * @param alumno
	 */
	void altaAlumno (Alumno alumno);
	
	/**
	 * 
	 * @param nombre
	 * @return el alumno con el nombre enviado por param
	 */
	Alumno buscarPorNombre(String nombre);
	
	/**
	 * 
	 * @param nombre
	 * @return true si existe false si no existe
	 */
	boolean existeAlumno(String nombre);
	
	/**
	 * 
	 * @return la lista de todos los cursos encontrados
	 */
	List<String> cursos();
	
}
