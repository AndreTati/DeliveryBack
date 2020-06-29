package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

public class ConfiguracionDTO implements Serializable{

	private int id;
	private Date horarioCierre;
	private Date horarioApertura;
	private int cantidadCocineros;
	private String nombreEmpresa;
	private String emailEmpresa;
	private long cuit;
	private long numeroFiscal;
	private String telefono;
	private String sociedad;
	private String paginaWeb;
	private boolean eliminado;
	
	public ConfiguracionDTO() {
		
	}

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
