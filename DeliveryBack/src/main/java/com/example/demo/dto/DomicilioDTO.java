package com.example.demo.dto;

import java.io.Serializable;

public class DomicilioDTO implements Serializable{

	private int id;
	private String calle;
	private int nro;
	private int piso;
	private int dpto;
	private int CP;
	private String alias;
	
	private LocalidadDTO localidad;
	private EmpleadoDTO empleado;
	private ClienteDTO cliente;
	
	public DomicilioDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getDpto() {
		return dpto;
	}

	public void setDpto(int dpto) {
		this.dpto = dpto;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}

	public LocalidadDTO getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoDTO empleado) {
		this.empleado = empleado;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	
	
	
}
