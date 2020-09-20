package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

@Entity
@Where( clause = "eliminado_rol = false")  
public class Rol {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private int id;
	@Column(name="nombre_rol")
	private String nombre;
	@Column(name="eliminado_rol")
	private boolean eliminado;
	
	public Rol() {}

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

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
