package com.example.demo.entities;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id_persona")

public class Cliente extends Persona{

	public Cliente() {
		super();
	}

	
	
	
}