package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	String urlHotel="http://localhost:8000/hoteles";
	String urlVuelo="http://localhost:8001/vuelos";

	public ReservasServiceImpl(@Autowired ReservasDao reservasDao,@Autowired RestTemplate template) {
		super();
		this.reservasDao = reservasDao;
		this.template = template;
	}
	
	@Override
	public void reservar(ReservaDto reservaDto) {
		Hotel hotel = template.getForObject(urlHotel+"/Hotel/find/"+reservaDto.getHotel(), Hotel.class);
		Vuelo vuelo = template.getForObject(urlVuelo+"/Vuelos/find/"+reservaDto.getVuelo(), Vuelo.class);
		if(hotel!=null && vuelo.getPlazas() >= reservaDto.getPlazas()) {
			Reserva reserva = new Reserva(reservaDto.getIdReserva(),reservaDto.getNombre(),reservaDto.getDni(),reservaDto.getHotel(),reservaDto.getVuelo());
			template.put(urlVuelo+"/Vuelo/"+"?idVuelo="+reservaDto.getVuelo()+"&plazas="+reservaDto.getPlazas(),null);
			reservasDao.save(reserva);
		}
	}

	@Override
	public List<Reserva> obtenerReservas() {
		return reservasDao.findAll();
	}
	
}
