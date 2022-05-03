package service;

import java.util.Date;
import java.util.List;

import dtos.CuentaDto;
import dtos.MovimientoDto;

public interface CajeroService {
	/**
	 * 
	 * @param numeroCuenta
	 * @return la cuenta encontrada o null
	 */
	CuentaDto buscarCuenta(int numeroCuenta);
	
	/**
	 * 
	 * @param numeroCuenta
	 * @param cantidad
	 * @return true en caso de exito, false en caso de fallo
	 * @return
	 */
	boolean ingresar(int numeroCuenta, int cantidad);
	
	/**
	 * 
	 * @param numeroCuenta
	 * @param cantidad
	 * @return true en caso de exito, false en caso de fallo
	 */
	boolean extraccion(int numeroCuenta, int cantidad);

	/**
	 * 
	 * @param numeroCuenta
	 * @param toNumeroCuenta
	 * @param cantidad
	 * @return true en caso de exito, false en caso de fallo
	 */
	boolean transferencia(int numeroCuenta, int toNumeroCuenta, int cantidad);
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return los movimientos entre las dos fechas
	 */
	List<MovimientoDto> consultarMovimientos(int nmCuenta, Date start, Date end);	
}
