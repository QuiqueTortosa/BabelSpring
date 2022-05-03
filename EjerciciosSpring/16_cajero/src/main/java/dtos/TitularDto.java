package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TitularDto {
	
	private ClienteDto clienteDto;
	private CuentaDto cuentaDto;
}
