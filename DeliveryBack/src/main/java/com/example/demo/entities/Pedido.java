package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

@Entity
@Where( clause = "eliminado_pedido = false")  
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int id;
	@Column(name="fecha_pedido")
	private String fecha;
	@Column(name="nro_pedido")
	private int nro;
	@Column(name="horaEstimadaFin_pedido")
	private String horaEstimadaFin;
	@Column(name="tipoEnvio_pedido")
	private String tipoEnvio;
	@Column(name="eliminado_pedido")
	private boolean eliminado;
	@Column(name="montoDescuento_pedido")
	private double montoDescuento;
	@Column(name="total_pedido")
	private double total;
	@Column(name="estado_pedido")
	private String estado;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<PedidoDetalle>detalles=new ArrayList<PedidoDetalle>();
	@OneToOne
	@JoinColumn(name="fk_id_cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="fk_id_domicilioCliente")
	private Domicilio domicilioCliente;
	
	public Pedido() {}

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

	public List<PedidoDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<PedidoDetalle> detalles) {
		this.detalles = detalles;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public Domicilio getDomicilioCliente() {
		return domicilioCliente;
	}

	public void setDomicilioCliente(Domicilio domicilioCliente) {
		this.domicilioCliente = domicilioCliente;
	}
	
	
}
