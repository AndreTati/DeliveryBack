package com.example.demo.dto;

import com.example.demo.entities.Domicilio;

public class EmpleadoDTO extends PersonaDTO{

	private RolDTO rol;
	private Domicilio domicilio;
	
	public EmpleadoDTO() {
		super();
	}

	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	
}
