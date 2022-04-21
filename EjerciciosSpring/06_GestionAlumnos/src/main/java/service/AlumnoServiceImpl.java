package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Alumno> buscarPorCurso(String cursos) {
		String sql = "select * from alumnos where cursos=?";
		return template.query(sql,
				(rs,f)->new Alumno(rs.getInt("idAlumno"), //f es el numero de fila
									 rs.getString("nombre"), 
									 rs.getString("cursos"),
									 rs.getDouble("nota")),
								cursos);
	}
	
	@Override
	public void altaAlumno(Alumno alumno) {
		if(buscarPorNombre(alumno.getNombre()) == null) {
		String sql = "insert into alumnos(nombre,cursos,nota) values(?,?,?)";
		template.update(sql, 
				alumno.getNombre(), 
				alumno.getCursos(), 
				alumno.getNota());
		}else {
			System.out.println("El alumno ya existe");
		}
	}
	
	@Override
	public Alumno buscarPorNombre(String nombre) {
		String sql="select * from alumnos where nombre=?";
		List<Alumno> alumnos = template.query(sql,
				(rs,f)->new Alumno(rs.getInt("idAlumno"), //f es el numero de fila
						 rs.getString("nombre"), 
						 rs.getString("cursos"),
						 rs.getDouble("nota")),
				nombre);
		return alumnos.size()>0?alumnos.get(0):null;
	}                              
	
	
}
