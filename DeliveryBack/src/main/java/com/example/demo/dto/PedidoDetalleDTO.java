package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entities.Factura;
import com.example.demo.entities.Pedido;

public class PedidoDetalleDTO implements Serializable{

	private int id;
	private int cantidad;
	private double subtotal;
	
	private ArticuloInsumoDTO insumo;
	private ArticuloManufacturadoDTO manufacturado;
	
	private Pedido pedido;
	private Factura factura;
	
	public PedidoDetalleDTO() {}

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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
}
