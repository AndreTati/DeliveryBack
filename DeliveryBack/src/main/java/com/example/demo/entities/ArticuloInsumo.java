package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ArticuloInsumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_articuloInsumo")
	private int id;
	@Column(name="nombre_articuloInsumo")
	private String nombre;
	@Column(name="descripcion_articuloInsumo")
	private String descripcion;
	@Column(name="precioCompra_articuloInsumo")
	private double precioCompra;
	@Column(name="stockActual_articuloInsumo")
	private double stockActual;
	@Column(name="stockMin_articuloInsumo")
	private double stockMin;
	@Column(name="stockMax_articuloInsumo")
	private double stockMax;
	@Column(name="esInsumo_articuloInsumo")
	private boolean esInsumo;
	@Column(name="precioVta_articuloInsumo")
	private double precioVta;
	
	@OneToOne
	@JoinColumn(name="fk_id_categoriaInsumo")
	private CategoriaInsumo categoria;
	@OneToOne
	@JoinColumn(name="fk_id_unidadDeMedida")
	private UnidadDeMedida unidadMed;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_id_imagen")
	private Imagen img;
	
	public ArticuloInsumo() {}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getStockActual() {
		return stockActual;
	}

	public void setStockActual(double stockActual) {
		this.stockActual = stockActual;
	}

	public double getStockMin() {
		return stockMin;
	}

	public void setStockMin(double stockMin) {
		this.stockMin = stockMin;
	}

	public double getStockMax() {
		return stockMax;
	}

	public void setStockMax(double stockMax) {
		this.stockMax = stockMax;
	}

	public boolean isEsInsumo() {
		return esInsumo;
	}

	public void setEsInsumo(boolean esInsumo) {
		this.esInsumo = esInsumo;
	}

	public double getPrecioVta() {
		return precioVta;
	}

	public void setPrecioVta(double precioVta) {
		this.precioVta = precioVta;
	}

	public CategoriaInsumo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaInsumo categoria) {
		this.categoria = categoria;
	}

	public UnidadDeMedida getUnidadMed() {
		return unidadMed;
	}

	public void setUnidadMed(UnidadDeMedida unidadMed) {
		this.unidadMed = unidadMed;
	}

	public Imagen getImg() {
		return img;
	}

	public void setImg(Imagen img) {
		this.img = img;
	}
	
	
}
