package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="vuelos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Vuelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvuelo;
	private String company;
	private String fecha;
	private double precio;
	private int plazas;
	
}
