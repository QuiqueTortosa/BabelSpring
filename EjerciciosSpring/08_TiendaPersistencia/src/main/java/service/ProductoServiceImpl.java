package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Producto> buscarPorSeccion(String seccion) {
		String jpql = "select p from Producto p where p.seccion=:seccion";
		TypedQuery<Producto> query = entityManager.createQuery(jpql, Producto.class);
		query.setParameter("seccion", seccion);
		List<Producto> productos = query.getResultList();
		return productos;
	}

	@Transactional
	@Override
	public void altaP(Producto producto) {
		entityManager.persist(producto);		
	}
	
	@Transactional
	@Override
	public void modificarP(String nombre, double nPrecio) {
		String jpql = "update from Producto p set p.precio=:precio where p.nombre=:nombre";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("precio", nPrecio);
		query.setParameter("nombre", nombre);
		query.executeUpdate();
	}

	@Transactional
	@Override
	public void eliminarP(String nombre) {
		String jpql = "delete from Producto p where p.nombre=:nombre";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nombre", nombre);
		query.executeUpdate();
	}

	@Override
	public Producto buscarProducto(int id) {
		return entityManager.find(Producto.class, id); //find es solo por primary key
	}	
	
	@Override
	public Producto buscarProducto(String nombre) {
		String jpql = "select p from Producto p where p.nombre=:nombre";
		TypedQuery<Producto> query = entityManager.createQuery(jpql, Producto.class);
		query.setParameter("nombre", nombre);
		List<Producto> productos = query.getResultList();
		return productos.size()>0?productos.get(0):null;
	}
	
}
