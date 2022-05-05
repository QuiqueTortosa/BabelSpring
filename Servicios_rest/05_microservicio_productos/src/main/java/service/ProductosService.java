package service;

import java.util.List;

import model.Producto;

public interface ProductosService {

	void altaProducto(Producto producto);

	List<Producto> buscarProductos(String seccion);

	boolean eliminarProducto(int id);

	List<Producto> todosProducto();

}
