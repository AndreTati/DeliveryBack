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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Factura {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id_factura")
	private int id;
	@Column(name="fecha_factura")
	private Date fecha;
	@Column(name="montoDescuento_factura")
	private int montoDescuento;
	@Column(name="total_factura")
	private double total;
	@Column(name="nro_factura")
	private int nro;
	@Column(name="tipoPago_factura")
	private String tipoPago;
	@Column(name="nroTarjeta_factura")
	private long nroTarjeta;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PedidoDetalle>detalles=new ArrayList<>();
	@OneToOne
	@Column(name="fk_id_cliente")
	private Cliente cliente;
	@OneToOne
	@Column(name="fk_id_pedido")
	private Pedido pedido;
	
	public Factura() {}

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
	
	
}
