package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ConfiguracionDTO;
import com.example.demo.exceptions.StatusException;
import com.example.demo.services.ConfiguracionService;

@Controller
@RestController
@RequestMapping(path="api/v1/configuracion")
public class ConfiguracionController {

	private ConfiguracionService configuracionService;

	public ConfiguracionController(ConfiguracionService configuracionService) {
		this.configuracionService = configuracionService;
	}
	@GetMapping("/")
	@CrossOrigin("*")
	public ConfiguracionDTO getOne() {
		return ResponseEntity.status(200).body(configuracionService.getConfiguracion()).getBody();
	}
	@PostMapping("/")
	@CrossOrigin("*")
	public ResponseEntity save(@RequestBody ConfiguracionDTO dto) {
		ConfiguracionDTO temp=configuracionService.save(dto);
		try {
			if(temp.getId()!=0) {
				return ResponseEntity.status(201).body(temp);
			}else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
		} catch (StatusException e) {
			return e.getResponseStatus();
		}
	}
	@PutMapping("/{id}")
	@CrossOrigin("*")
	public ResponseEntity update(@RequestBody ConfiguracionDTO dto,@PathVariable int id) {
		ConfiguracionDTO temp=configuracionService.update(dto, id);
		try {
			if(temp.getId()!=0) {
				return ResponseEntity.status(201).body(temp);
			}else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
		} catch (StatusException e) {
			return e.getResponseStatus();
		}
	}
	@DeleteMapping("/{id}")
	@CrossOrigin("*")
	public ResponseEntity delete(@PathVariable int id) {
		boolean result=configuracionService.delete(id);
		
		try {
			
			if(result) {
				return ResponseEntity.status(204).body("{ \"Succesful\": \"Correctly removed.\" }");
			}
			else {
				throw new StatusException("Bad request. Please verify the id or if exist a relation with another table", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
	}
	
}
