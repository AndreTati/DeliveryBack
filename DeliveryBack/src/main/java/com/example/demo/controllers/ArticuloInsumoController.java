package com.example.demo.controllers;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.exceptions.StatusException;

import com.example.demo.dto.ArticuloInsumoDTO;
import com.example.demo.services.ArticuloInsumoService;


@Controller
@RestController
@RequestMapping(path="api/v1/insumo")
public class ArticuloInsumoController {

	private ArticuloInsumoService insumoService;

	public ArticuloInsumoController(ArticuloInsumoService insumoService) {
		this.insumoService = insumoService;
	}
	
	@GetMapping("/")
	@CrossOrigin(origins="*")
	public List<ArticuloInsumoDTO> getAll(){
		return ResponseEntity.status(200).body(insumoService.getAll()).getBody();
	}
	
	@GetMapping("/esInsumo/{esInsumo}")
	@CrossOrigin(origins="*")
	public List<ArticuloInsumoDTO> getAllNoInsumos(@PathVariable boolean esInsumo){
		return ResponseEntity.status(200).body(insumoService.getAllNoInsumos(esInsumo)).getBody();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins="*")
	public ArticuloInsumoDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(insumoService.getOne(id)).getBody();
	}
	
	@PostMapping("/")
	@CrossOrigin(origins="*")
	public ResponseEntity save(@RequestBody ArticuloInsumoDTO i) {
		ArticuloInsumoDTO temp=insumoService.save(i);
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
	@CrossOrigin(origins="*")
	public ResponseEntity update(@RequestBody ArticuloInsumoDTO t, @PathVariable int id) {
		ArticuloInsumoDTO temp=insumoService.update(t, id);
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
	@CrossOrigin(origins="*")
	public ResponseEntity delete(@PathVariable int id) {
		boolean borrado=insumoService.delete(id);
		try {
			if(borrado) {
				return ResponseEntity.status(204).body("{ \"Succesful\": \"Correctly removed.\" }");
			}else {
				throw new StatusException("Bad request. Please verify the id or if exist a relation with another table", 400);
			}
		}catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
	}
}
