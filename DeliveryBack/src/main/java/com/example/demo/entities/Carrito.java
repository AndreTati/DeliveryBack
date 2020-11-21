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

import com.example.demo.dto.CarritoDetalleDTO;
import com.example.demo.dto.ClienteDTO;


@Entity
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_carrito")
	private int id;
	@Column(name="fecha_carrito")
	private Date fecha;
	@Column(name="tipoEnvio_carrito")
	private String tipoEnvio;
	@Column(name="montoDescuento_carrito")
	private double montoDescuento;
	@Column(name="total_carrito")
	private double total;
	@Column(name="formaPago_carrito")
	private String formaPago;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "carrito")
	private List<CarritoDetalle> detallesCarrito=new ArrayList<>();
	@OneToOne
	@JoinColumn(name="fk_id_cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="fk_id_domicilioCliente")
	private Domicilio domicilioCliente;
	
	public Carrito() {}

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

	public List<CarritoDetalle> getDetallesCarrito() {
		return detallesCarrito;
	}

	public void setDetallesCarrito(List<CarritoDetalle> detallesCarrito) {
		this.detallesCarrito = detallesCarrito;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Domicilio getDomicilioCliente() {
		return domicilioCliente;
	}

	public void setDomicilioCliente(Domicilio domicilioCliente) {
		this.domicilioCliente = domicilioCliente;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	
	
}
