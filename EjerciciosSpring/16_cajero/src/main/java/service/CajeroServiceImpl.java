package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import dao.TitularDao;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

@Service
public class CajeroServiceImpl implements CajeroService{
	
	@Autowired
	ConversorEntityDto conversor;
	
	CuentasDao cuentasDao;
	
	MovimientosDao movimientosDao;
	
	ClientesDao cursosDao;
	
	TitularDao titularDao;
	
	
	
	public CajeroServiceImpl(@Autowired CuentasDao cuentasDao, @Autowired MovimientosDao movimientosDao, @Autowired ClientesDao cursosDao, @Autowired TitularDao titularDao) {
		this.cuentasDao = cuentasDao;
		this.movimientosDao = movimientosDao;
		this.cursosDao = cursosDao;
		this.titularDao = titularDao;
	}

	@Override
	public CuentaDto buscarCuenta(int numeroCuenta) {
		System.out.println(cuentasDao.getById(numeroCuenta));
		return conversor.cuentaToDto(cuentasDao.getById(numeroCuenta));
	}

	@Override
	public boolean ingresar(int numeroCuenta, int cantidad) {
		Optional<Cuenta> cuenta = cuentasDao.findById(numeroCuenta);
		if(cuenta.isPresent()) {
			Movimiento m = new Movimiento(numeroCuenta, new Date(),cantidad, "ingreso");
			cuenta.get().setSaldo(cantidad+cuenta.get().getSaldo());
			cuentasDao.save(cuenta.get());
			movimientosDao.save(m);
			return true;
		}
		return false;
	}

	@Override
	public boolean extraccion(int numeroCuenta, int cantidad) {
		Optional<Cuenta> cuenta = cuentasDao.findById(numeroCuenta);
		if(cuenta.isPresent()) {
			Movimiento m = new Movimiento(numeroCuenta, new Date(),cantidad, "extracción");
			cuenta.get().setSaldo(cuenta.get().getSaldo()-cantidad);
			cuentasDao.save(cuenta.get());
			movimientosDao.save(m);
			return true;
		}
		return false;
	}

	@Override
	public boolean transferencia(int numeroCuenta, int toNumeroCuenta, int cantidad) {
		Optional<Cuenta> cuenta = cuentasDao.findById(numeroCuenta);
		Optional<Cuenta> toCuenta = cuentasDao.findById(toNumeroCuenta);
		if(cuenta.isPresent() && toCuenta.isPresent()) {			
			Movimiento m = new Movimiento(numeroCuenta, new Date(),cantidad, "transferencia");
			cuenta.get().setSaldo(cuenta.get().getSaldo()-cantidad);
			toCuenta.get().setSaldo(toCuenta.get().getSaldo()+cantidad);
			cuentasDao.save(cuenta.get());
			cuentasDao.save(toCuenta.get());
			movimientosDao.save(m);
			return true;
		}
		return false;
	}

	@Override
	public List<MovimientoDto> consultarMovimientos(int nmCuenta, Date start, Date end) {
		return movimientosDao.findByCuentaNumeroCuentaAndFechaBetween(nmCuenta,start, end)
				.stream()
				.map(m->conversor.movimientoToDto(m))
				.collect(Collectors.toList());
	}

}
