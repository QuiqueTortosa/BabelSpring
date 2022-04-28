package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService{
	
	AlumnosDao alumnosDao;
	CursosDao cursosDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}
	
	@Override
	public Alumno login(String usuario, String password) {
		return alumnosDao.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public List<Curso> cursosMatriculado(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> cursos() {
		return cursosDao.findAll();
	}

	@Override
	public List<Alumno> matriculadosPorCurso(String nombre) {
		return alumnosDao.findByCurso(nombre);
	}

	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		Optional<Curso> curso = cursosDao.findById(idCurso);
		Optional<Alumno> alumno = alumnosDao.findById(usuario);
		if(curso.isPresent() && alumno.isPresent()) { //Si lo encuentra
			Alumno al = alumno.get();
			al.getCursos().add(curso.get());
			alumnosDao.save(al);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean altaAlumno(Alumno alumno) {
		if(alumnosDao.findById(alumno.getUsuario()).isEmpty()) {
			alumnosDao.save(alumno);
			return true;
		}
		return false;
	}

	@Override
	public boolean altaCurso(Curso curso) {
		if(cursosDao.findByNombre(curso.getNombre()).isEmpty()) {
			cursosDao.save(curso);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Alumno> alumnos() {
		return alumnosDao.findAll();
	}

	@Override
	public List<Curso> cursosSinMatricular(String usuario) {
		return cursosDao.findByCursosSinMatricular(usuario);
	}

	@Override
	public List<Curso> consultarMatriculas(Date start, Date end) {
		return cursosDao.findByRange(start, end);
	}
	
}
