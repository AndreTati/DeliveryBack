package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDTO implements Serializable{

	private int id;
	private String fecha;
	private int nro;
	private String horaEstimadaFin;
	private String tipoEnvio;
	private boolean eliminado;
	private double montoDescuento;
	private double total;
	private String estado;
	private String formaPago;
	
	private List<PedidoDetalleDTO>detalles=new ArrayList<PedidoDetalleDTO>();
	private ClienteDTO cliente;
	private DomicilioDTO domicilioCliente;
	
	public PedidoDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getHoraEstimadaFin() {
		return horaEstimadaFin;
	}

	public void setHoraEstimadaFin(String horaEstimadaFin) {
		this.horaEstimadaFin = horaEstimadaFin;
	}

	public String getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<PedidoDetalleDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<PedidoDetalleDTO> detalles) {
		this.detalles = detalles;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
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

	public DomicilioDTO getDomicilioCliente() {
		return domicilioCliente;
	}

	public void setDomicilioCliente(DomicilioDTO domicilioCliente) {
		this.domicilioCliente = domicilioCliente;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	
	
}
