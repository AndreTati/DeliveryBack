package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class ClienteDTO extends PersonaDTO{

	private List<DomicilioDTO> domicilios=new ArrayList<DomicilioDTO>();
	
	public ClienteDTO() {
		super();
	}

	public List<DomicilioDTO> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<DomicilioDTO> domicilios) {
		this.domicilios = domicilios;
	}


	public void sddDomicilio(DomicilioDTO dom) {
		this.domicilios.add(dom);
	}
	
	
	
}
