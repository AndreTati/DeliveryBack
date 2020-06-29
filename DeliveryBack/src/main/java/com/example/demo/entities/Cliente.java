package com.example.demo.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id_cliente")

public class Cliente extends Persona{

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Domicilio> domicilios=new ArrayList<Domicilio>();
	
	public Cliente() {
		super();
	}

	public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

	public void addDomicilio(Domicilio domicilio) {
		this.domicilios.add(domicilio);
	}
	
	
}
