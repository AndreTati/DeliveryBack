package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Localidad {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_localidad")
	private int id;
	@Column(name="nombre_localidad")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="fk_id_provincia")
	private Provincia provincia;
	
	public Localidad() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
}
