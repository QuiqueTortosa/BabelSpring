package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "productos")
public class Producto {
	
	@Id //Para indiciar que es la clave primaria de la bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para indicar que es primary key autogenerada
	private int id;
	private String nombre;
	@Column(name = "seccion")//Si el atributo se llama distinto que en la bdd se usa esto
	private String seccion;
	private double precio;
	private int stock;
		
}
