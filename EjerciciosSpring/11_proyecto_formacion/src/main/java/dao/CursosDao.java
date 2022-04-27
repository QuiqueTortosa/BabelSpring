package dao;

import java.util.List;

import model.Curso;

public interface CursosDao {
	
	/**
	 * 
	 * @param idCurso
	 * @return curso encontrado
	 */
	Curso findById(int idCurso);
	
	/**
	 * 
	 * @return todos los cursos
	 */
	List<Curso> findAll();
	
	/**
	 * 
	 * @param usuario
	 * @return el alumno encontrado
	 */
	List<Curso> findByAlumno(String usuario);
}
