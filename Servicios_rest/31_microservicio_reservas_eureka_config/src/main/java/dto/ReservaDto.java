package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservaDto {
	
	private int idReserva;
	private String nombre;
	private String dni;
	private int hotel;
	private int vuelo;
	private int plazas;
	
}
