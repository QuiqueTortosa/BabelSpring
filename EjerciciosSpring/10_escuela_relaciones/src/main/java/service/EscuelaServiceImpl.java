package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;

@Service
public class EscuelaServiceImpl implements EscuelaService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Alumno> alumnosCurso(String nombre) {
		String jpql = "select a from Alumno a where a.curso.denominacion=?1";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, nombre);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0?alumnos:null;	
	}

	@Override
	public List<Alumno> alumnosCursoDuracion(int duracionMax) {
		String jpql = "select a from Alumno a where a.curso.duracion<=?1";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, duracionMax);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0?alumnos:null;
	}

	@Override
	public Curso cursoMatriculadoAlumno(String dni) {
		String jpql = "select c from Curso c join c.alumnos a where a.dni=?1";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, dni);
		List<Curso> curso = query.getResultList();
		return curso.size()>0?curso.get(0):null;
	}

	@Override
	public List<Curso> alumnosSenior(int edad) {
		String jpql = "select distinct(c) from Curso c join c.alumnos a where a.edad>=?1";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, edad);
		List<Curso> curso = query.getResultList();
		return curso.size()>0?curso:null;
	}

	@Override
	public double edadMediaCurso(String nombreCurso) {
		String jpql = "select avg(a.edad) from Alumno a where a.curso.denominacion=?1";
		TypedQuery<Double> query=entityManager.createQuery(jpql,Double.class);
		query.setParameter(1, nombreCurso);
		List<Double> edadMedia = query.getResultList();
		return edadMedia.size()>0?edadMedia.get(0):0;
	}

	@Override
	public double precioCurso(String email) {
		String jpql = "select a.curso.precio from Alumno a where a.email=?1";
		TypedQuery<Integer> query=entityManager.createQuery(jpql,Integer.class);
		query.setParameter(1, email);
		List<Integer> precio = query.getResultList();
		return precio.size()>0?precio.get(0):0;
	}
	
	
}
