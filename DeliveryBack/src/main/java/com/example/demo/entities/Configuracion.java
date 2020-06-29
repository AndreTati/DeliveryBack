package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;

@Entity
@Where( clause = "eliminado_configuracion = false")  
public class Configuracion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_configuracion")
	private int id;
	@Column(name="horarioCierre_configuracion")
	@Temporal(TemporalType.DATE)
	private Date horarioCierre;
	@Column(name="horarioApertura_configuracion")
	@Temporal(TemporalType.DATE)
	private Date horarioApertura;
	@Column(name="cantidadCocineros_configuracion")
	private int cantidadCocineros;
	@Column(name="nombreEmpresa_configuracion")
	private String nombreEmpresa;
	@Column(name="emailEmpresa_configuracion")
	private String emailEmpresa;
	@Column(name="cuit_configuracion")
	private long cuit;
	@Column(name="numeroFiscal_configuracion")
	private long numeroFiscal;
	@Column(name="telefono_configuracion")
	private String telefono;
	@Column(name="sociedad_configuracion")
	private String sociedad;
	@Column(name="paginaWeb_configuracion")
	private String paginaWeb;
	@Column(name="eliminado_configuracion")
	private boolean eliminado;
	
	public Configuracion() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(Date horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

	public Date getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(Date horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public int getCantidadCocineros() {
		return cantidadCocineros;
	}

	public void setCantidadCocineros(int cantidadCocineros) {
		this.cantidadCocineros = cantidadCocineros;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public long getNumeroFiscal() {
		return numeroFiscal;
	}

	public void setNumeroFiscal(long numeroFiscal) {
		this.numeroFiscal = numeroFiscal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSociedad() {
		return sociedad;
	}

	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
