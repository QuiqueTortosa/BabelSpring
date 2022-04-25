package service;

import java.util.List;
import model.Alumno;
import model.Curso;

public interface EscuelaService {
	
	/**
	 * 
	 * @param nombre
	 * @return lista de alumnos del curso
	 */
	List<Alumno> alumnosCurso(String nombre);
	/**
	 * 
	 * @param duracionMax
	 * @return Lista de alumnos de los cursos con menor a la duracionMax como param
	 */
	List<Alumno> alumnosCursoDuracion(int duracionMax);
	/**
	 * 
	 * @param dni
	 * @return curso matriculado
	 */
	Curso cursoMatriculadoAlumno(String dni);
	
	/**
	 * 
	 * @param edad
	 * @return lista de cursosen los que estan matriculados alumnos con edad superior al valor recibido
	 */
	List<Curso> alumnosSenior(int edad);
	
	/**
	 * 
	 * @param nombreCurso
	 * @return edad media de los alumnos matriculados en el curso indicado
	 */
	double edadMediaCurso(String nombreCurso);
	
	/**
	 * 
	 * @param email
	 * @return precio del curso en el que está matriculado el alumno con dicho email
	 */
	double precioCurso(String email);
}
