package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ArticuloManufacturadoDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_articuloManufacturadoDetalle")
	private int id;
	@Column(name="cantidad_articuloManufacturadoDetalle")
	private double cantidad;
	
	@OneToOne
	@JoinColumn(name="fk_id_articuloInsumo")
	private ArticuloInsumo insumo;
	
	public ArticuloManufacturadoDetalle() {}

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

	public ArticuloInsumo getInsumo() {
		return insumo;
	}

	public void setInsumo(ArticuloInsumo insumo) {
		this.insumo = insumo;
	}
	
	
}
