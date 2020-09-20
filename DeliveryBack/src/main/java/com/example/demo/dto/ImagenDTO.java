package com.example.demo.dto;

import java.io.Serializable;

public class ImagenDTO implements Serializable{

	private int id;
	private String url;
	
	public ImagenDTO() {}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
