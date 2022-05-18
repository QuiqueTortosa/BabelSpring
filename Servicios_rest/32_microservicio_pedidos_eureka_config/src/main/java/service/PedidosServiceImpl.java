package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import dao.PedidosDao;
import model.Pedido;
import model.Producto;

@Service
public class PedidosServiceImpl implements PedidosService{
	
	PedidosDao pedidosDao;
	RestTemplate template;
	String urlProducto="http://servicio-productos";

	
	public PedidosServiceImpl(@Autowired PedidosDao pedidosDao, @Autowired RestTemplate template) {
		super();
		this.pedidosDao = pedidosDao;
		this.template = template;
	}

	/*@Override
	public boolean pedido(Pedido pedido) {
		double precioProducto = template.getForObject(urlProducto + "/" +pedido.getCodigoProducto(), double.class);
		ResponseEntity<String> response = template.exchange(
				urlProducto+"/{codigo}/{unidades}",
				HttpMethod.PUT,
				null,
				String.class,
				pedido.getCodigoProducto(),
				pedido.getUnidades());
		String cuerpo = response.getBody();
		if(precioProducto != 0 && cuerpo.equals("true")) {
			pedido.setFechaPedido(new Date());
			pedido.setTotal(pedido.getUnidades()*precioProducto);
			pedidosDao.save(pedido);
			return true;
		}
		return false;
	}*/
	
	public boolean pedido(Pedido pedido) {
		try {
			double precioProducto = template.getForObject(urlProducto + "/" +pedido.getCodigoProducto(), double.class);
			ResponseEntity<String> response = template.exchange(
					urlProducto+"/{codigo}/{unidades}",
					HttpMethod.PUT,
					null,
					String.class,
					pedido.getCodigoProducto(),
					pedido.getUnidades());	
			pedido.setFechaPedido(new Date());
			pedido.setTotal(pedido.getUnidades()*precioProducto);
			pedidosDao.save(pedido);
			return true;
		} catch(HttpClientErrorException ex) {
			return false;
		}
	}
	

	@Override
	public List<Pedido> todosLosPedidos() {
		return pedidosDao.findAll();
	}

	
	
}
