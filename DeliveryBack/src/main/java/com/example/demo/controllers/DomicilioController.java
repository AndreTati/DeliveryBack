package com.example.demo.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
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

import com.example.demo.dto.DomicilioDTO;
import com.example.demo.services.DomicilioService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/v1/delivery/domicilio")
public class DomicilioController {

	private DomicilioService service;

	public DomicilioController(DomicilioService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	@Transactional
	public List<DomicilioDTO> getAll() {
		return ResponseEntity.status(200).body(service.getAll()).getBody();
	}

	@GetMapping("/{id}")
	@Transactional
	public DomicilioDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(service.getOne(id)).getBody();
	}

	@PostMapping(path = "/")
	@Transactional
	public ResponseEntity post(@RequestBody DomicilioDTO domicilioDTO) {
		DomicilioDTO result = new DomicilioDTO();
		try {
			result = service.save(domicilioDTO);
		} catch (Exception e) {
		}

		return ResponseEntity.status(201).body(result);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity put(@RequestBody DomicilioDTO domicilioDTO, @PathVariable int id) {
		DomicilioDTO result = new DomicilioDTO();
		try {
			result = service.update(domicilioDTO, id);
		} catch (Exception e) {
			return ResponseEntity.status(400).body("{\"Error\":\"Bad Request.\"  } ");
		}

		domicilioDTO.setId(result.getId());
		return ResponseEntity.status(201).body(domicilioDTO);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable int id) {

		boolean result = service.delete(id);

		if (result) {
			return ResponseEntity.status(204).body("");
		} else {
			return ResponseEntity.status(204).body("No ha sido borrado");
		}

	}
}
