package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ArticuloManufacturadoDTO;
import com.example.demo.services.ArticuloManufacturadoService;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.exceptions.StatusException;

@Controller
@RestController
@RequestMapping(path="api/v1/manufacturado")
public class ArticuloManufacturadoController {

	private ArticuloManufacturadoService manufacturadoService;

	public ArticuloManufacturadoController(ArticuloManufacturadoService manufacturadoService) {
		this.manufacturadoService = manufacturadoService;
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public List<ArticuloManufacturadoDTO> getAll(){
		return ResponseEntity.status(200).body(manufacturadoService.getAll()).getBody();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ArticuloManufacturadoDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(manufacturadoService.getOne(id)).getBody();
	}
	
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity save(@RequestBody ArticuloManufacturadoDTO manufacturadoDto) {
		ArticuloManufacturadoDTO temp=manufacturadoService.save(manufacturadoDto);
		
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
	@CrossOrigin(origins = "*")
	public ResponseEntity update(@RequestBody ArticuloManufacturadoDTO manufacturadoDto, @PathVariable int id) {
		ArticuloManufacturadoDTO temp=manufacturadoService.update(manufacturadoDto, id);
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
	@CrossOrigin(origins = "*")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det=manufacturadoService.delete(id);
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
