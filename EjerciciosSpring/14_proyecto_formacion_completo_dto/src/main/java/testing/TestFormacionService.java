package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import model.Curso;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class }) 
public class TestFormacionService {

	@Autowired
	FormacionService service;
	
	@Test
	void testLogin() {
		assertNotNull(service.login("admin", "a"));
		assertNull(service.login("text", "mytext"));	
	}
	
	@Test
	void testCursosMatriculados() {
		assertEquals(6, service.cursosMatriculado("aaa").size());
	}
	
	@Test 
	void testCursos() {
		assertEquals(18,service.cursos().size());
	}
	
	@Test
	void testMatricularPorCurso() {
		assertEquals(4, service.matriculadosPorCurso("kafka").size());
		assertEquals(2, service.matriculadosPorCurso("javascript").size());
	}
	
	@Test
	void testCursosSinMatricular() {
		assertEquals(12,service.cursosSinMatricular("aaa").size());
	}
	
	@Test
	void testfindByRange() throws ParseException {
		/*Calendar cal1 = Calendar.getInstance(); 
		 * Calencar cal2 = Calendar.getInstance();
		 * cal1.set(2020,8,20)
		 * cal2.set(2021,8,20
		 * Date f1 = cal1.getTime()
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2020-11-18");
		Date date2 = sdf.parse("2025-12-03");
		//service.altaCurso(new CursoDto("www",30,date2,10.0));
		//assertEquals(12,service.consultarMatriculas(date, date2).size());
	}
	
}
