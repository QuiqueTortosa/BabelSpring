package model;

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
@Table(name = "alumnos")
public class Alumno {
	
	@Id //Para indiciar que es la clave primaria de la bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para indicar que es primary key autogenerada
	private int idAlumno;
	private String nombre;
	private String cursos;
	private double nota;
		
}
