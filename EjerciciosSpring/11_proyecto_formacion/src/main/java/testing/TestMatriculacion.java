package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class }) 

public class TestMatriculacion {

	@Autowired
	FormacionService service;
	
	@Test
	void testMatricularAlumno() {
		service.matricularAlumno("aaa", 2);
		assertEquals(5,service.cursosMatriculado("aaa").size());
	}
}
