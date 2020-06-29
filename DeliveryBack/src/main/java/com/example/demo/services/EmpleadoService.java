package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	private EmpleadoRepository empleadoRepository;

	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	
}
