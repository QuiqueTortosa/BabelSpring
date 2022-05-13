package service;

import java.util.List;

import model.Vuelo;

public interface VuelosService {
	
	/**
	 * 
	 * @param plazas
	 * @return vuelos con plazas suficientes
	 */
	
	List<Vuelo> vuelosPorPlazas(int plazas);
	
	/**
	 * 
	 * @param idVuelo
	 * @return vuelo encontrado
	 */
	Vuelo buscarVuelo(int idVuelo);
	
	/**
	 * 
	 * @param idVuelo
	 * @param plazas
	 * @return true si actualiza las plazas, false si falla
	 */
	boolean actualizarVuelo(int idVuelo, int plazas);
	
}
