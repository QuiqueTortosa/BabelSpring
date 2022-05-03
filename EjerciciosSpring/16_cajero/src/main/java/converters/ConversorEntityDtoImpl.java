package converters;

import org.springframework.stereotype.Component;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import dtos.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Titular;
import model.TitularPk;

@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto{

	@Override
	public ClienteDto clienteToDto(Cliente cliente) {
		return new ClienteDto(cliente.getDni(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono());
	}

	@Override
	public Cliente dtoToCliente(ClienteDto dto) {
		return new Cliente(dto.getDni(), dto.getNombre(), dto.getDireccion(), dto.getTelefono());
	}

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getSaldo(), cuenta.getTipocuenta());
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		return new Cuenta(dto.getNumeroCuenta(), dto.getSaldo(), dto.getTipocuenta());
	}

	@Override
	public MovimientoDto movimientoToDto(Movimiento movimiento) {
		return new MovimientoDto(movimiento.getIdMovimiento(), movimiento.getIdCuenta(),cuentaToDto(movimiento.getCuenta()),movimiento.getFecha(), movimiento.getCantidad(),movimiento.getOperacion());
	}

	@Override
	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		return new Movimiento(dto.getIdMovimiento(), dto.getIdCuenta(), dto.getFecha(), dto.getCantidad(), dto.getOperacion(), dtoToCuenta(dto.getCuentaDto()));
	}

	@Override
	public TitularDto titularToDto(Titular titular) {
		return new TitularDto(clienteToDto(titular.getCliente()), cuentaToDto(titular.getCuenta()));
	}

	@Override
	public Titular dtoToTitular(TitularDto dto) {
		return new Titular(new TitularPk(dto.getClienteDto().getDni(),dto.getCuentaDto().getNumeroCuenta()),dtoToCuenta(dto.getCuentaDto()), dtoToCliente(dto.getClienteDto()));
	}

}
