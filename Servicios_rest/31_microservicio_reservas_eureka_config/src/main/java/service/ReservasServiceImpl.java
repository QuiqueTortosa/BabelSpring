package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import dto.ReservaDto;
import model.Hotel;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservasServiceImpl implements ReservasService{
	
	ReservasDao reservasDao;
	RestTemplate template;
	String urlHotel="http://servicio-hoteles";
	String urlVuelo="http://servicio-vuelos";

	public ReservasServiceImpl(@Autowired ReservasDao reservasDao,@Autowired RestTemplate template) {
		super();
		this.reservasDao = reservasDao;
		this.template = template;
	}
	
	@Override
	public void reservar(ReservaDto reservaDto) {
		Hotel hotel = template.getForObject(urlHotel+"/Hotel/find/"+reservaDto.getHotel(), Hotel.class);
		ResponseEntity<String> response = template.exchange(
							urlVuelo+"/Vuelo/{idVuelo}/{plazas}",
							HttpMethod.PUT,
							null,
							String.class,
							reservaDto.getVuelo(),
							reservaDto.getPlazas());
		String cuerpo = response.getBody();
		if(hotel != null && cuerpo.equals("true")) {
			Reserva reserva = new Reserva(reservaDto.getIdReserva(),reservaDto.getNombre(),reservaDto.getDni(),reservaDto.getHotel(),reservaDto.getVuelo());
			reservasDao.save(reserva);
		}
	}

	@Override
	public List<Reserva> obtenerReservas() {
		return reservasDao.findAll();
	}
	
}
