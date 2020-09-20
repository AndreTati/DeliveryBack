package com.example.demo.dto;

import java.io.Serializable;

public class CarritoDetalleDTO implements Serializable{

	private int id;
	private int cantidad;
	private double subtotal;
	
	private ArticuloInsumoDTO insumo;
	private ArticuloManufacturadoDTO manufacturado;
	
	private CarritoDTO carrito;
	
	public CarritoDetalleDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public ArticuloInsumoDTO getInsumo() {
		return insumo;
	}

	public void setInsumo(ArticuloInsumoDTO insumo) {
		this.insumo = insumo;
	}

	public ArticuloManufacturadoDTO getManufacturado() {
		return manufacturado;
	}

	public void setManufacturado(ArticuloManufacturadoDTO manufacturado) {
		this.manufacturado = manufacturado;
	}

	public CarritoDTO getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoDTO carrito) {
		this.carrito = carrito;
	}
	
	
}
