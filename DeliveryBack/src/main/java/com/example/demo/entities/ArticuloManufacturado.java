package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

@Entity
@Where( clause = "eliminado_articuloManufacturado = false")  
public class ArticuloManufacturado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_articuloManufacturado")
	private int id;
	@Column(name="nombre_articuloManufacturado")
	private String nombre;
	@Column(name="tiempoPreparacion_articuloManufacturado")
	private int tiempoPreparacion;
	@Column(name="precio_articuloManufacturado")
	private double precio;
	@Column(name="eliminado_articuloManufacturado")
	private boolean eliminado;
	
	@OneToOne
	@JoinColumn(name="fk_id_categoriaGeneral")
	private CategoriaGeneral categoria;
	@OneToOne
	@JoinColumn(name="fk_id_imagen")
	private Imagen img;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturado")
	private List<ArticuloManufacturadoDetalle>detalles=new ArrayList<ArticuloManufacturadoDetalle>();
	
	public ArticuloManufacturado() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public CategoriaGeneral getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaGeneral categoria) {
		this.categoria = categoria;
	}

	public Imagen getImg() {
		return img;
	}

	public void setImg(Imagen img) {
		this.img = img;
	}

	public List<ArticuloManufacturadoDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ArticuloManufacturadoDetalle> detalles) {
		this.detalles = detalles;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
