package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArticuloManufacturadoDTO implements Serializable{

	private int id;
	private String nombre;
	private int tiempoPreparacion;
	private double precio;
	private boolean eliminado;
	
	private CategoriaGeneralDTO categoriaGral;
	private ImagenDTO img;
	private List<ArticuloManufacturadoDetalleDTO> detalles =new ArrayList<>();
	
	public ArticuloManufacturadoDTO() {}
	
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

	public CategoriaGeneralDTO getCategoriaGral() {
		return categoriaGral;
	}

	public void setCategoriaGral(CategoriaGeneralDTO categoriaGral) {
		this.categoriaGral = categoriaGral;
	}

	public ImagenDTO getImg() {
		return img;
	}

	public void setImg(ImagenDTO img) {
		this.img = img;
	}

	public List<ArticuloManufacturadoDetalleDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ArticuloManufacturadoDetalleDTO> detalles) {
		this.detalles = detalles;
	}
	
	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
}
