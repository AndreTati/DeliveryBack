package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;


@Entity
@Where( clause = "eliminado_provincia= false")  
public class Provincia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_provincia")
	private int id;
	@Column(name="nombre_provincia")
	private String nombre;
	@Column(name="eliminado_provincia")
	private boolean eliminado;
	
	@OneToOne
	@JoinColumn(name="fk_id_pais")
	private Pais pais;
	
	public Provincia() {}

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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
