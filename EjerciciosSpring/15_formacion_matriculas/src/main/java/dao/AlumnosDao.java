package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno,String> {//La clase y el tipo de la PK

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
	@Query("select a from Alumno a join a.matriculas m where m.curso.nombre=?1")
	List<Alumno> findByCurso(String nombreCurso);
				
}
