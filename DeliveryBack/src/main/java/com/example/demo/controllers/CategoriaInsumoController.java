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

import com.example.demo.dto.CategoriaInsumoDTO;
import com.example.demo.services.CategoriaInsumoService;
import com.example.demo.exceptions.StatusException;


@Controller
@RestController
@RequestMapping(path="api/v1/categoriainsumo")
public class CategoriaInsumoController {

	private CategoriaInsumoService categoriaService;

	public CategoriaInsumoController(CategoriaInsumoService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public List<CategoriaInsumoDTO> getAll(){
		return ResponseEntity.status(200).body(categoriaService.getAll()).getBody();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public CategoriaInsumoDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(categoriaService.getOne(id)).getBody();
	}
	
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity save(@RequestBody CategoriaInsumoDTO categoriaDTO) {
		CategoriaInsumoDTO temp=categoriaService.save(categoriaDTO);
		
		try {
			if(temp.getId()!=0) {
				return ResponseEntity.status(201).body(temp);
			}else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
		}catch(StatusException e) {
			return e.getResponseStatus();
		}
	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity update(CategoriaInsumoDTO categoriaDTO, int id) {
		
		CategoriaInsumoDTO temp=categoriaService.update(categoriaDTO, id);
		try {
			if(temp.getId()!=0) {
				return ResponseEntity.status(201).body(temp);
			}else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
		}catch(StatusException e) {
			return e.getResponseStatus();
		}
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity delete(int id) {
		boolean det=categoriaService.delete(id);
		
		try {
			if(det) {
				return ResponseEntity.status(204).body("{ \"Succesful\": \"Correctly removed.\" }");
			}
			else {
				throw new StatusException("Bad request. Please verify the id or if exist a relation with another table", 400);
			}
		}catch(StatusException e) {
			return e.getResponseStatus();
		}
	}
}
