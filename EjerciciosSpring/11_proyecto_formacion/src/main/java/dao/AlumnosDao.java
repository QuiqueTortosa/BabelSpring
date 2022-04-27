package dao;

import java.util.List;

import model.Alumno;

public interface AlumnosDao {

	/**
	 * 
	 * @return usuario si coincide el usuario y el password
	 */
	Alumno findByUsuarioAndPassword(String usuario, String password);
	
	/**
	 * 
	 * @param nombreCurso
	 * @return la lista de alumnos del curso
	 */
	List<Alumno> findByCurso(String nombreCurso);
	
	/**
	 * 
	 * @param usuario
	 * @return devuelve el usuario encontrado
	 */
	Alumno findById(String usuario);
	
	/**
	 * 
	 * @return todos los usuarios
	 */
	List<Alumno> findAll();
	
	/**
	 * 
	 * @param alumno
	 * Actualiza el alumno
	 */ 
	void update(Alumno alumno);
	
}
