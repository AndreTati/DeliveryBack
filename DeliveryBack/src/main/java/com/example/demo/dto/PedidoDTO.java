package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDTO implements Serializable{

	private int id;
	private Date fecha;
	private int nro;
	private String horaEstimadaFin;
	private String tipoEnvio;
	
	private EstadoDTO estado;
	private List<PedidoDetalleDTO>detalles=new ArrayList<>();
	private ClienteDTO cliente;
	
	public PedidoDTO() {}

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

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
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
	
	
}
