package com.example.demo.dto;

import java.io.Serializable;

public class CategoriaGeneralDTO implements Serializable{

	private int id;
	private String denominacion;
	private boolean eliminado;
	
	public CategoriaGeneralDTO() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
}
