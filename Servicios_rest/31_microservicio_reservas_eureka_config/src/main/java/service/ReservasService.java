package service;

import java.util.List;

import dto.ReservaDto;
import model.Reserva;

public interface ReservasService {
	
	/**
	 * 
	 * @param reserva
	 */
	void reservar(ReservaDto reservaDto);
	
	/**
	 * 
	 * @return reservas
	 */
	List<Reserva> obtenerReservas();

	
}
