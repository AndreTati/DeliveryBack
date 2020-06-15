package com.example.demo.dto;

import java.io.Serializable;

public class ProvinciaDTO implements Serializable{

	private int id;
	private String nombre;
	
	private PaisDTO pais;
	
	public ProvinciaDTO() {}

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

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}
	
	
}
