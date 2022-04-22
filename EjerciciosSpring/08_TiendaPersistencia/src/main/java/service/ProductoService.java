package service;

import java.util.List;

import model.Producto;

public interface ProductoService {
	
	List<Producto> buscarPorSeccion(String seccion);
	void altaP (Producto producto);
	void modificarP(String nombre, double nPrecio);
	void eliminarP(String nombre);
	Producto buscarProducto(int id);
	
}
