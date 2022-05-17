package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService{

	ProductosDao productosDao;
	
	public ProductosServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}

	@Override
	public List<Producto> productosExistentes() {
		System.out.println("yeh");
		return productosDao.findAll();
	}

	@Override
	public boolean actualizarProducto(int codigoProducto, int unidadesCompradas) {
		Optional<Producto> producto = productosDao.findById(codigoProducto);
		if(producto.isPresent() && producto.get().getStock() >= unidadesCompradas) {
			producto.get().setStock(producto.get().getStock() - unidadesCompradas);
			productosDao.save(producto.get());
			return true;
		}
		return false;
	}

	@Override
	public double precioUnitarioProducto(int codigoProducto) {
		Producto producto = productosDao.findById(codigoProducto).orElse(null);
		if(producto != null) {
			return producto.getPrecioUnitario();
		}
		return 0;
	}

}
