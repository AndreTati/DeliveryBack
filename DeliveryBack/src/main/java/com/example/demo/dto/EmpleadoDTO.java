package com.example.demo.dto;

public class EmpleadoDTO extends PersonaDTO{

	private RolDTO rol;
	
	public EmpleadoDTO() {
		super();
	}

	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}
	
	
}
