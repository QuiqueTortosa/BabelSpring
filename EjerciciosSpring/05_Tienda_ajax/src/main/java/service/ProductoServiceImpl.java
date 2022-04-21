package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Producto> buscarPorSeccion(String seccion) {
		String sql = "select * from productos where seccion=?";
		return template.query(sql,
				(rs,f)->new Producto(rs.getInt("id"), //f es el numero de fila
									 rs.getString("nombre"), 
									 rs.getString("seccion"),
									 rs.getDouble("precio"),
									 rs.getInt("stock")),
				seccion);
	}

	@Override
	public Producto buscarProducto(int id) {
		String sql="select * from productos where id=?";
		List<Producto> productos = template.query(sql,
				(rs,f)->new Producto(rs.getInt("id"), //f es el numero de fila
									 rs.getString("nombre"), 
									 rs.getString("seccion"),
									 rs.getDouble("precio"),
									 rs.getInt("stock")),
				id);
		return productos.size()>0?productos.get(0):null;
	}
	
	@Override
	public Producto buscarProducto(String nombre) {
		String sql="select * from productos where nombre=?";
		List<Producto> productos = template.query(sql,
				(rs,f)->new Producto(rs.getInt("id"), //f es el numero de fila
									 rs.getString("nombre"), 
									 rs.getString("seccion"),
									 rs.getDouble("precio"),
									 rs.getInt("stock")),
				nombre);
		return productos.size()>0?productos.get(0):null;
	}
	
	@Override
	public void altaP(Producto producto) {
		String sql = "insert into productos(nombre,seccion,precio,stock) values(?,?,?,?)";
		template.update(sql, 
				producto.getNombre(), 
				producto.getSeccion(), 
				producto.getPrecio(), 
				producto.getStock());
	}                              

	@Override
	public void modificarP(String nombre, double nPrecio) {
		String sql="update producto set precio=? where nombre=?";
		template.update(sql, nPrecio, nombre);
	}

	@Override
	public void eliminarP(String nombre) {
		String sql = "delete from productos where nombre=?";
		template.update(sql, nombre);
	}
	
}
