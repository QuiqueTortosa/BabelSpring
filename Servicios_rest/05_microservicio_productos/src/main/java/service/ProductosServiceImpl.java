package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;
@Service
public class ProductosServiceImpl implements ProductosService {
	
	ProductosDao productosDao;
	
	public ProductosServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}

	@Override
	public void altaProducto(Producto producto) {
		productosDao.save(producto);
	}

	@Override
	public List<Producto> buscarProductos(String seccion) {
		return productosDao.findBySeccion(seccion);
	}

	@Override
	public boolean eliminarProducto(int id) {
		if(productosDao.findById(id)!=null) {
			productosDao.deleteById(id);
			return true;
		}
		return false;	
		}

	@Override
	public List<Producto> todosProducto() {
		return productosDao.findAll();
	}
}
