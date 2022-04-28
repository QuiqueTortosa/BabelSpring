package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	
	/**
	 * 
	 * @param usuario
	 * @param password
	 * @return el usuario que cumple el usuario y el password
	 */
	Alumno login(String usuario, String password);
	
	/**
	 * 
	 * @param usuario
	 * @return los cursos en los que esta matriculado
	 */
	List<Curso> cursosMatriculado(String usuario);
	
	/**
	 * 
	 * @return los cursos existentes
	 */
	List<Curso> cursos();

	/**
	 * 
	 * @param nombre
	 * @return los alumnos matriculados en el curso
	 */
	List<Alumno> matriculadosPorCurso(String nombre);
	
	/**
	 * 
	 * @param alumno
	 * @param idCurso
	 * Matricula al alumno en el curso
	 */
	boolean matricularAlumno(String alumno, int idCurso);
	
	/**
	 * 
	 * @return todos los alumnos
	 */
	List<Alumno> alumnos();
}
