	package dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;
import model.Curso;

public interface CursosDao extends JpaRepository<Curso,Integer>{
		
	/**
	 * 
	 * @param usuario
	 * @return el alumno encontrado
	 */
	@Query("select c from Curso c join c.alumnos a where a.usuario=?1")
	List<Curso> findByAlumno(String usuario);
	
	/**
	 * 
	 * @param nombre
	 * @return el curso encontrado
	 */
	Optional<Curso> findByNombre(String nombre);
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return devuelve los cursos entre las dos fechas
	 */
	@Query("select c from Curso c where c.fechaInicio between ?1 and ?2")
	List<Curso> findByRange(Date start, Date end);
	
	/**
	 * 
	 * @param usuario
	 * @return los cursos del alumno en los que no esta matriculado
	 */
	@Query("select c From Curso c Where c Not In (Select c From Curso c join c.alumnos a Where a.usuario=?1)")
	List<Curso> findByCursosSinMatricular(String usuario);
}
