package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService{
	
	VuelosDao vuelosDao;
	
	public VuelosServiceImpl(@Autowired VuelosDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}

	@Override
	public List<Vuelo> vuelosPorPlazas(int plazas) {
		return vuelosDao.findByPlazasGreaterThanEqual(plazas);
	}

	@Override
	public boolean actualizarVuelo(int idVuelo, int plazas) {
		Optional<Vuelo> vuelo=vuelosDao.findById(idVuelo);
		if(vuelo.isPresent()) {
			vuelo.get().setPlazas(vuelo.get().getPlazas() - plazas);;
			vuelosDao.save(vuelo.get());
			return true;
		}
		return false;
	}

	@Override
	public Vuelo buscarVuelo(int idVuelo) {
		return vuelosDao.findById(idVuelo).orElse(null);
	}

}
