package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class }) 
public class TestFormacionService {

	@Autowired
	FormacionService service;
	
	@Test
	void testLogin() {
		assertNotNull(service.login("admin", "a"));
	}
	
	@Test
	void testCursosMatriculados() {
		assertEquals(5, service.cursosMatriculado("aaa").size());
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
}
