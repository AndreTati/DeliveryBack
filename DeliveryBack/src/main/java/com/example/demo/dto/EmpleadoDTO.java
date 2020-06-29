package com.example.demo.dto;

import com.example.demo.entities.Domicilio;

public class EmpleadoDTO extends PersonaDTO{

	private RolDTO rol;
	private DomicilioDTO domicilio;
	
	public EmpleadoDTO() {
		super();
	}

	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}

	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}
	
	
}
