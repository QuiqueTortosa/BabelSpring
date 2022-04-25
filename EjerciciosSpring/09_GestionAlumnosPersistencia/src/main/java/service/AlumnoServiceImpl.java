package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Alumno> buscarPorCurso(String cursos) {
		String jpql = "select a from Alumno a where a.cursos=:cursos";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("cursos", cursos);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0?alumnos:null;	
	}

	@Transactional
	@Override
	public void altaAlumno(Alumno alumno) {
		entityManager.persist(alumno);	
	}

	@Override
	public Alumno buscarPorNombre(String nombre) {
		String jpql = "select a from Alumno a where a.nombre=:nombre";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("nombre", nombre);
		return query.getSingleResult();
	}

	@Override
	public boolean existeAlumno(String nombre) {
		String jpql = "select a from Alumno a where a.nombre=:nombre";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("nombre", nombre);
		return query.getResultList().size()>0;
	}

	@Override
	public List<String> cursos() {
		String jpql = "select distinct(cursos) from Alumno";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		List<String> cursos = query.getResultList();
		return cursos.size()>0?cursos:null;		
	}
		
}
