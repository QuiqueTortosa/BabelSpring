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
	int nmCuenta = 0;
	
	@PostMapping(value="Cuenta")
	public String login(@RequestParam("nmCuenta")int nmCuenta, HttpSession sesion, HttpServletRequest request) {
		CuentaDto cuenta = cajeroService.buscarCuenta(nmCuenta);
		if(cuenta != null) {
			this.nmCuenta = nmCuenta;
			sesion.setAttribute("cuenta", cuenta);
			return "menu";
			}
		else {
			request.setAttribute("mensaje", "Numero de cuenta y incorrecta");
			return "error";
		}
	}

	@PostMapping(value="Ingreso")
	public String ingresar(@RequestParam("cantidad")int cantidad) {
		System.out.println(this.nmCuenta);
		boolean ingresado = cajeroService.ingresar(this.nmCuenta,cantidad);
		if(ingresado) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	@PostMapping(value="Extracto")
	public String extraccion(@RequestParam("cantidad")int cantidad) {
		boolean extraido = cajeroService.extraccion(this.nmCuenta,cantidad);
		if(extraido) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	@PostMapping(value="Transferencia")
	public String transferencia(@RequestParam("toNmCuenta")int toNmCuenta, @RequestParam("cantidad")int cantidad) {
		boolean transferido = cajeroService.transferencia(this.nmCuenta,toNmCuenta,cantidad);
		if(transferido) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	
	@GetMapping(value = "ConsultaMovimientos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<MovimientoDto> movimientos(@DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("start") Date start,
			@DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("end") Date end) {
		
		return cajeroService.consultarMovimientos(this.nmCuenta, start, end);
	}
	
	@GetMapping(value="Cuenta")
	public @ResponseBody CuentaDto buscarCuenta() {
		CuentaDto cuenta = cajeroService.buscarCuenta(this.nmCuenta);
		return cuenta!=null?cuenta:null;
	}
}
