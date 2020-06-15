package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Domicilio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_domicilio")
	private int id;
	@Column(name="calle_domicilio")
	private String calle;
	@Column(name="nro_domicilio")
	private int nro;
	@Column(name="piso_domicilio")
	private int piso;
	@Column(name="dpto_domicilio")
	private int dpto;
	@Column(name="cp_domicilio")
	private int CP;
	@Column(name="latitud_domicilio")
	private double latitud;
	@Column(name="longitud_domicilio")
	private double longitud;
	
	@OneToOne
	@JoinColumn(name="fk_id_localidad")
	private Localidad localidad;
	
	public Domicilio() {}

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

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	
}
