package service;

import java.util.Date;
import java.util.List;

import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;
import model.Curso;

public interface FormacionService 
{
	/**
	 * 
	 * @param usuario
	 * @param password
	 * @return el usuario que cumple el usuario y el password
	 */
	AlumnoDto login(String usuario, String password);
	
	/**
	 * 
	 * @param usuario
	 * @return los cursos en los que esta matriculado
	 */
	List<CursoDto> cursosMatriculado(String usuario);
	
	/**
	 * 
	 * @return los cursos existentes
	 */
	List<CursoDto> cursos();

	/**
	 * 
	 * @param nombre
	 * @return los alumnos matriculados en el curso
	 */
	List<AlumnoDto> matriculadosPorCurso(String nombre);
	
	/**
	 * 
	 * @param alumno
	 * @param idCurso
	 * Matricula al alumno en el curso
	 */
	boolean matricularAlumno(String alumno, int idCurso);
	
	/**
	 * 
	 * @param alumno
	 * @return true si da de alta, false si hay algun error
	 */
	boolean altaAlumno(AlumnoDto alumno);
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	boolean altaCurso(CursoDto curso);
	
	/**
	 * 
	 * @return todos los alumnos
	 */
	List<AlumnoDto> alumnos();
	
	/**
	 * 
	 * @param usuario
	 * @return los cursos del alumno en los que no esta matriculado
	 */
	List<CursoDto> cursosSinMatricular(String usuario);
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return devuelve los cursos entre las dos fechas
	 */
	List<CursoDto> consultarMatriculas(Date start, Date end);
}
