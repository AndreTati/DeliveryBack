package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.exceptions.StatusException;
import com.example.demo.services.UnidadDeMedidaService;



@Controller
@RestController
@RequestMapping(path="api/v1/unidadmedida")
public class UnidadDeMedidaController {

	private UnidadDeMedidaService unidadMedidaService;

	public UnidadDeMedidaController(UnidadDeMedidaService unidadMedidaService) {
		super();
		this.unidadMedidaService = unidadMedidaService;
	}
	
	@GetMapping("/")
	@CrossOrigin("*")
	public List<UnidadDeMedidaDTO> getAll(){
		return ResponseEntity.status(200).body(unidadMedidaService.getAll()).getBody();
	}
	@GetMapping("/{id}")
	@CrossOrigin("*")
	public UnidadDeMedidaDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(unidadMedidaService.getOne(id)).getBody();
	}
	@PostMapping("/")
	@CrossOrigin("*")
	public ResponseEntity save(@RequestBody UnidadDeMedidaDTO uni) {
		UnidadDeMedidaDTO temp = unidadMedidaService.save(uni);		
		
		try {
			
			if(temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			}
			else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
	}
	@PutMapping("/{id}")
	@CrossOrigin("*")
	public ResponseEntity update(@RequestBody UnidadDeMedidaDTO uni, @PathVariable int id) {
		UnidadDeMedidaDTO temp = unidadMedidaService.update(uni, id);
		
		try {
			
			if(temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			}
			else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
	}
	@DeleteMapping("/{id}")
	@CrossOrigin("*")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = unidadMedidaService.delete(id);
		
		try {
			
			if(det) {
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
