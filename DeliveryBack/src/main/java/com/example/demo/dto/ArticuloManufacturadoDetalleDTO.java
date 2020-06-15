package com.example.demo.dto;

import java.io.Serializable;

public class ArticuloManufacturadoDetalleDTO implements Serializable{

	private int id;
	private double cantidad;
	
	private ArticuloInsumoDTO insumo;
	
	public ArticuloManufacturadoDetalleDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public ArticuloInsumoDTO getInsumo() {
		return insumo;
	}

	public void setInsumo(ArticuloInsumoDTO insumo) {
		this.insumo = insumo;
	}
	
	
}
