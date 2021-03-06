package dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovimientoDto {
	
	private int idMovimiento;
	private int idCuenta;
	private CuentaDto cuentaDto;
	private Date fecha;
	private int cantidad;
	private String operacion;
	
}
