package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacturaDTO implements Serializable{

	private int id;
	private Date fecha;
	private int montoDescuento;
	private double total;
	private int nro;
	private String tipoPago;
	private long nroTarjeta;
	private boolean eliminado;
	
	private List<PedidoDetalleDTO> detalles=new ArrayList<>();
	private ClienteDTO cliente;
	private PedidoDTO pedido;
	
	public FacturaDTO() {}

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

	public int getMontoDescuento() {
		return montoDescuento;
	}

	public void setMontoDescuento(int montoDescuento) {
		this.montoDescuento = montoDescuento;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public long getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(long nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
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

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	
	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
}
