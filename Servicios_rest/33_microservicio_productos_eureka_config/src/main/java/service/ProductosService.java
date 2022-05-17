package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	
	/**
	 * 
	 * @return lista de productos existentes
	 */
	List<Producto> productosExistentes();
	
	/**
	 * 
	 * @param codigoProducto
	 * @param unidadesCompradas
	 * @return true si se actualiza el producto, false en caso de error
	 */
	boolean actualizarProducto(int codigoProducto, int unidadesCompradas);

	/**
	 * 
	 * @param codigoProducto
	 * @return precioUnitario del producto encontrado
	 */
	double precioUnitarioProducto(int codigoProducto);
	
}
