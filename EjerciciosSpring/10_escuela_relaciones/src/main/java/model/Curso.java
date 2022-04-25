package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id //Para indiciar que es la clave primaria de la bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para indicar que es primary key autogenerada
	private int idCurso;
	private String denominacion;
	private int duracion;
	private int precio;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@OneToMany(mappedBy="curso")
	private List<Alumno> alumnos;

	public Curso(int idCurso, String denominacion, int duracion, int precio, Date fechaInicio) {
		super();
		this.idCurso = idCurso;
		this.denominacion = denominacion;
		this.duracion = duracion;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
	}
	
	
	
}	
