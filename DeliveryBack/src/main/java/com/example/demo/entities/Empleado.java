package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id_empleado")
public class Empleado extends Persona{

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="fk_id_rol")
	private Rol rol;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
	private Domicilio domicilio;
	
	
	public Empleado() {
		super();
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	
	
}
