package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id_persona")
public class Empleado extends Persona{

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="fk_id_rol")
	private Rol rol;
	
	public Empleado() {
		super();
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
