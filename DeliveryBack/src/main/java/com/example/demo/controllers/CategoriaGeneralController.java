package com.example.demo.controllers;

import java.util.List;

import javax.transaction.Transactional;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exceptions.StatusException;

import com.example.demo.dto.CategoriaGeneralDTO;
import com.example.demo.services.CategoriaGeneralService;


@Controller
@RestController
@RequestMapping(path = "api/v1/categoriageneral")
public class CategoriaGeneralController {

	private CategoriaGeneralService service;

	public CategoriaGeneralController(CategoriaGeneralService service) {
		this.service = service;
	}

	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public List<CategoriaGeneralDTO> getAll() {
		return ResponseEntity.status(200).body(service.getAll()).getBody();
	}

	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public CategoriaGeneralDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(service.getOne(id)).getBody();
	}

	
	@PostMapping(path="/") 
	@CrossOrigin(origins = "*")
	public ResponseEntity save(@RequestBody CategoriaGeneralDTO categoriaGeneralDTO) {
		CategoriaGeneralDTO temp = service.save(categoriaGeneralDTO);
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
	
	
	@PutMapping(path = "/{id}") 
	@CrossOrigin(origins = "*")
	public ResponseEntity update(@RequestBody CategoriaGeneralDTO categoriaGeneralDTO, @PathVariable int id) {
		CategoriaGeneralDTO temp = service.update(categoriaGeneralDTO, id);
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
	
	@DeleteMapping(path = "/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity delete(@PathVariable int id) {
		
		boolean result = service.delete(id);
		
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
