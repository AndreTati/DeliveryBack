package com.example.demo.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Where( clause = "eliminado = false")  
public abstract class Persona {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	protected int id;
	@Column(name="dni_persona")
	protected long dni;
	@Column(name="nombre_persona")
	protected String nombre;
	@Column(name="apellido_persona")
	protected String apellido;
	@Column(name="email_persona")
	protected String email;
	@Column(name="pass_persona")
	protected String pass;
	@Column(name="fechaAlta_persona")
	protected Date fechaAlta;
	@Column(name="telefono_persona")
	protected String telefono;
	@Column(name="fechaNac_persona")
	protected Date fechaNac;
	@Column(name="eliminado_persona")
	private boolean eliminado;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="fk_id_imagen")
	private Imagen img;
	
	public Persona() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Imagen getImg() {
		return img;
	}

	public void setImg(Imagen img) {
		this.img = img;
	}
	
	
}
