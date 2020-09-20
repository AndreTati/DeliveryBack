package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.demo.dto.CarritoDTO;

@Entity
public class CarritoDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_carritoDetalle")
	private int id;
	@Column(name="cantidad_carritoDetalle")
	private int cantidad;
	@Column(name="subtotal_carritoDetalle")
	private double subtotal;
	
	@OneToOne
	@JoinColumn(name="fk_id_insumo")
	private ArticuloInsumo insumo;
	@OneToOne
	@JoinColumn(name="fk_id_manufacturado")
	private ArticuloManufacturado manufacturado;
	@ManyToOne
	@JoinColumn(name="fk_id_carrito")
	private Carrito carrito;
	
	public CarritoDetalle() {}

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

	public ArticuloInsumo getInsumo() {
		return insumo;
	}

	public void setInsumo(ArticuloInsumo insumo) {
		this.insumo = insumo;
	}

	public ArticuloManufacturado getManufacturado() {
		return manufacturado;
	}

	public void setManufacturado(ArticuloManufacturado manufacturado) {
		this.manufacturado = manufacturado;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	
}
