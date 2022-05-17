package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {
	
	/**
	 * 
	 * @param pedido
	 * @return true si se guarda el pedido, false si hay algun error
	 */
	boolean pedido(Pedido pedido);
	
	/**
	 * 
	 * @return lista de todos los pedidos
	 */
	List<Pedido> todosLosPedidos();
	
}
