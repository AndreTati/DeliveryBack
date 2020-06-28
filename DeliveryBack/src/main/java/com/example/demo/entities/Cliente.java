package com.example.demo.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id_cliente")

public class Cliente extends Persona{

	public Cliente() {
		super();
	}

	
	
	
}
