package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.EscuelaService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class }) 
public class TestEscuelaService {
	
	@Autowired
	EscuelaService service;
	
	@Test
	void testAlumnosCurso() {
		assertEquals(4,service.alumnosCurso("java").size());
		assertEquals(1,service.alumnosCurso("spring boot").size());
		
	}
	
	@Test 
	void testAlumnosCursosDuracion() {
		assertEquals(3,service.alumnosCursoDuracion(70).size());
		assertEquals(8,service.alumnosCursoDuracion(130).size());
	}
	
	@Test
	void testCursoMatriculadoAlumno() {
		assertEquals(2,service.cursoMatriculadoAlumno("1111A").getIdCurso());
		assertEquals(14,service.cursoMatriculadoAlumno("6666B").getIdCurso());
	}
	
	@Test
	void testAlumnoSenior() {
		assertEquals(3,service.alumnosSenior(30).size());
		assertEquals(2,service.alumnosSenior(40).size());
	}
	
	@Test 
	void testEdadMediaCurso() {
		assertEquals(25,service.edadMediaCurso("java"));
		assertEquals(39.6667, service.edadMediaCurso("python"));
	}
	
	 @Test
	 void testPrecioCurso() {
		 assertEquals(200,service.precioCurso("sexto@gmail.com"));
		 assertEquals(250,service.precioCurso("segundo@gmail.com"));
	 }
}
