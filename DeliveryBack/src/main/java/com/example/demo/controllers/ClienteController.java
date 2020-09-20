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

import com.example.demo.dto.ClienteDTO;
import com.example.demo.exceptions.StatusException;
import com.example.demo.services.ClienteService;


@Controller
@RestController
@RequestMapping(path="api/v1/cliente")
public class ClienteController {

	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	@GetMapping("/")
	@CrossOrigin("*")
	public List<ClienteDTO> getAll(){
		return ResponseEntity.status(200).body(clienteService.getAll()).getBody();
	}
	@GetMapping("/{id}")
	@CrossOrigin("*")
	public ClienteDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(clienteService.getOne(id)).getBody();
	}
	@GetMapping("busquedaPorEmail/{email}")
	@CrossOrigin("*")
	public ClienteDTO getBuscarPorEmail(@PathVariable String email) {
		return ResponseEntity.status(200).body(clienteService.busquedaPorEmail(email)).getBody();
	}
	@PostMapping("/")
	@CrossOrigin("*")
	public ResponseEntity save(@RequestBody ClienteDTO clienteDto) {
		ClienteDTO temp=clienteService.save(clienteDto);
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
	public ResponseEntity update(@RequestBody ClienteDTO clienteDto,@PathVariable int id) {
		ClienteDTO temp=clienteService.update(clienteDto, id);
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
		boolean det = clienteService.delete(id);
		
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
