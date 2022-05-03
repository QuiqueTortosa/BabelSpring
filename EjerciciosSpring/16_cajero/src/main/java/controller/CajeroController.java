package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.CuentaDto;
import dtos.MovimientoDto;
import service.CajeroService;

@CrossOrigin("*")
@Controller
public class CajeroController {
	
	@Autowired
	CajeroService cajeroService;
	
	@PostMapping(value="Cuenta")
	public String buscarCuenta(@RequestParam("nmCuenta")int nmCuenta, HttpSession sesion, HttpServletRequest request) {
		CuentaDto cuenta = cajeroService.buscarCuenta(nmCuenta);
		if(cuenta != null) {
			sesion.setAttribute("cuenta", cuenta);
			return "menu";
			}
		else {
			request.setAttribute("mensaje", "Numero de cuenta y incorrecta");
			return "error";
		}
	}
	
	@PostMapping(value="Ingreso")
	public String ingresar(@RequestParam("nmCuenta")int nmCuenta, @RequestParam("cantidad")int cantidad) {
		boolean ingresado = cajeroService.ingresar(nmCuenta,cantidad);
		if(ingresado) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	@PostMapping(value="Extracto")
	public String extraccion(@RequestParam("nmCuenta")int nmCuenta, @RequestParam("cantidad")int cantidad) {
		boolean ingresado = cajeroService.extraccion(nmCuenta,cantidad);
		if(ingresado) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	@PostMapping(value="Transferencia")
	public String extraccion(@RequestParam("nmCuenta")int nmCuenta, @RequestParam("toNmCuenta")int toNmCuenta, @RequestParam("cantidad")int cantidad) {
		boolean ingresado = cajeroService.transferencia(nmCuenta,toNmCuenta,cantidad);
		if(ingresado) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	
	@GetMapping(value = "ConsultaMovimientos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<MovimientoDto> movimientos(@RequestParam("nmCuenta")int nmCuenta, @DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("start") Date start,
			@DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("end") Date end) {
		
		return cajeroService.consultarMovimientos(nmCuenta, start, end);
	}
}
