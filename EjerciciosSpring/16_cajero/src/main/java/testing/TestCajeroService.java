package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.CajeroService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class} )

public class TestCajeroService {
	
	@Autowired 
	CajeroService cajeroS;
	
	@Test void testValidaraCuenta() {
		
		assertNotEquals(null,cajeroS.buscarCuenta(1000));
		assertNotNull(cajeroS.buscarCuenta(1000));
	}
	
}
