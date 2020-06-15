package com.example.demo.dto;

import java.io.Serializable;

public class ArticuloInsumoDTO implements Serializable{

	private int id;
	private String nombre;
	private String descripcion;
	private double precioCompra;
	private double stockActual;
	private double stockMin;
	private double stockMax;
	private boolean esInsumo;
	private double precioVta;
	
	private CategoriaDTO categoria;
	private UnidadDeMedidaDTO unidadDeMed;
	private ImagenDTO img;
	
	public ArticuloInsumoDTO() {}

	
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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public UnidadDeMedidaDTO getUnidadDeMed() {
		return unidadDeMed;
	}

	public void setUnidadDeMed(UnidadDeMedidaDTO unidadDeMed) {
		this.unidadDeMed = unidadDeMed;
	}

	public ImagenDTO getImg() {
		return img;
	}

	public void setImg(ImagenDTO img) {
		this.img = img;
	}
	
	
}
