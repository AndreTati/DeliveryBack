package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CarritoDTO implements Serializable{

	private int id;
	private Date fecha;
	private String tipoEnvio;
	private double montoDescuento;
	private double total;
	
	private List<CarritoDetalleDTO> detallesCarrito=new ArrayList<>();
	private ClienteDTO cliente;
	private DomicilioDTO domicilioCliente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipoEnvio() {
		return tipoEnvio;
	}
	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}
	public double getMontoDescuento() {
		return montoDescuento;
	}
	public void setMontoDescuento(double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<CarritoDetalleDTO> getDetallesCarrito() {
		return detallesCarrito;
	}
	public void setDetallesCarrito(List<CarritoDetalleDTO> detallesCarrito) {
		this.detallesCarrito = detallesCarrito;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public DomicilioDTO getDomicilioCliente() {
		return domicilioCliente;
	}
	public void setDomicilioCliente(DomicilioDTO domicilioCliente) {
		this.domicilioCliente = domicilioCliente;
	}
	
	
	
}
