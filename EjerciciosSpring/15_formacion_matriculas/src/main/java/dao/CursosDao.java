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
	@Query("select c from Curso c join c.matriculas m where m.alumno.usuario =?1")
	List<Curso> findByAlumno(String usuario);
	
	/**
	 * 
	 * @param nombre
	 * @return el curso encontrado
	 */
	Optional<Curso> findByNombre(String nombre);
	
	
	/**
	 * 
	 * @param usuario
	 * @return los cursos del alumno en los que no esta matriculado
	 */
	@Query("Select c From Curso c Where c Not In (Select c From Curso c join c.matriculas m where m.alumno.usuario =?1)")
	List<Curso> findByCursosSinMatricular(String usuario);
}