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
@Where( clause = "eliminado_factura = false")  
public class Factura {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id_factura")
	private int id;
	@Column(name="fecha_factura")
	private String fecha;
	@Column(name="montoDescuento_factura")
	private double montoDescuento;
	@Column(name="total_factura")
	private double total;
	@Column(name="nro_factura")
	private int nro;
	@Column(name="tipoPago_factura")
	private String tipoPago;
	@Column(name="nroTarjeta_factura")
	private long nroTarjeta;
	@Column(name="eliminado_factura")
	private boolean eliminado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
	private List<PedidoDetalle>detalles=new ArrayList<>();
	@OneToOne
	@JoinColumn(name="fk_id_cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="fk_id_pedido")
	private Pedido pedido;
	
	public Factura() {}

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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
