package com.example.demo.dto;

import java.io.Serializable;

public class PaisDTO implements Serializable{

	private int id;
	private String nombre;
	
	public PaisDTO() {}

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
	
	
}
