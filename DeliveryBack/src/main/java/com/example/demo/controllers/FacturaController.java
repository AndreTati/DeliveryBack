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

import com.example.demo.dto.FacturaDTO;
import com.example.demo.exceptions.StatusException;
import com.example.demo.services.FacturaService;

@Controller
@RestController
@RequestMapping(path="api/v1/factura")
public class FacturaController {

	private FacturaService facturaService;

	public FacturaController(FacturaService facturaService) {
		this.facturaService = facturaService;
	}
	
	@GetMapping("/")
	@CrossOrigin("*")
	public List<FacturaDTO> getAll(){
		return ResponseEntity.status(200).body(facturaService.getAll()).getBody();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin("*")
	public FacturaDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(facturaService.getOne(id)).getBody();
	}
	
	@GetMapping("/byPedido/{idPedido}")
	@CrossOrigin("*")
	public FacturaDTO getOneByPedido(@PathVariable int idPedido) {
		return ResponseEntity.status(200).body(facturaService.getOneByPedido(idPedido)).getBody();
	}
	
	@PostMapping("/")
	@CrossOrigin("*")
	public ResponseEntity save(@RequestBody FacturaDTO facturaDto) {
		FacturaDTO temp = facturaService.save(facturaDto);		
		
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
	public ResponseEntity update(@RequestBody FacturaDTO facturaDto,@PathVariable int id) {
FacturaDTO temp = facturaService.update(facturaDto, id);
		
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
		boolean det = facturaService.delete(id);
		
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
