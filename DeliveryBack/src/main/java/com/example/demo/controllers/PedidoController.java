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

import com.example.demo.dto.PedidoDTO;
import com.example.demo.exceptions.StatusException;
import com.example.demo.services.PedidoService;


@Controller
@RestController
@RequestMapping(path="api/v1/pedido")
public class PedidoController {

	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	@GetMapping("/")
	@CrossOrigin("*")
	public List<PedidoDTO> getAll(){
		return ResponseEntity.status(200).body(pedidoService.getAll()).getBody();
	}
	@GetMapping("/{id}")
	@CrossOrigin("*")
	public PedidoDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(pedidoService.getOne(id)).getBody();
	}
	@PostMapping("/")
	@CrossOrigin("*")
	public ResponseEntity save(@RequestBody PedidoDTO pedidoDto) {
		PedidoDTO temp = pedidoService.save(pedidoDto);		
		
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
	@PutMapping("/{id}/{estado}")
	@CrossOrigin("*")
	public ResponseEntity updateEstado(@RequestBody PedidoDTO pedidoDto, @PathVariable int id, @PathVariable String estado) {
		PedidoDTO temp = pedidoService.updateEstado(pedidoDto, id, estado);
		
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
	public ResponseEntity update(@RequestBody PedidoDTO pedidoDto, @PathVariable int id) {
		PedidoDTO temp = pedidoService.update(pedidoDto, id);
		
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
		boolean det = pedidoService.delete(id);
		
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
