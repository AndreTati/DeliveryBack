package com.example.demo.dto;

import java.io.Serializable;

public class LocalidadDTO implements Serializable{

	private int id;
	private String nombre;
	private boolean eliminado;
	
	private ProvinciaDTO provincia;
	
	public LocalidadDTO() {}

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

	public ProvinciaDTO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaDTO provincia) {
		this.provincia = provincia;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
