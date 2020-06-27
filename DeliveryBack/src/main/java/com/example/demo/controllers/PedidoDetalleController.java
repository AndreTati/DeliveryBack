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

import com.example.demo.dto.PedidoDetalleDTO;
import com.example.demo.exceptions.StatusException;
import com.example.demo.services.PedidoDetalleService;


@Controller
@RestController
@RequestMapping(path="api/v1/detalle")
public class PedidoDetalleController {

	private PedidoDetalleService detalleService;

	public PedidoDetalleController(PedidoDetalleService detalleService) {
		this.detalleService = detalleService;
	}
	@GetMapping("/")
	@CrossOrigin("*")
	public List<PedidoDetalleDTO> getAll(){
		return ResponseEntity.status(200).body(detalleService.getAll()).getBody();
	}
	@GetMapping("/{id}")
	@CrossOrigin("*")
	public PedidoDetalleDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(detalleService.getOne(id)).getBody();
	}
	@PostMapping("/")
	@CrossOrigin("*")
	public ResponseEntity save(@RequestBody PedidoDetalleDTO detalleDto) {
		PedidoDetalleDTO temp=detalleService.save(detalleDto);
		
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
	public ResponseEntity update(@RequestBody PedidoDetalleDTO detalleDto, @PathVariable int id) {
		PedidoDetalleDTO temp=detalleService.update(detalleDto, id);
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
		boolean det = detalleService.delete(id);
		
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
