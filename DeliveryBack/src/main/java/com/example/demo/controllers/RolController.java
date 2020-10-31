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

import com.example.demo.dto.PaisDTO;
import com.example.demo.dto.RolDTO;
import com.example.demo.exceptions.StatusException;
import com.example.demo.services.RolService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/v1/rol")
public class RolController {
	 private RolService service;

	public RolController(RolService service) {
		this.service = service;
	}
	 
	@GetMapping("/")
	@Transactional
	public List<RolDTO> getAll() {
		return ResponseEntity.status(200).body(service.getAll()).getBody();
	}

	@GetMapping("/{id}")
	@Transactional
	public RolDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(service.getOne(id)).getBody();
	}

	@PostMapping(path = "/")
	@Transactional
	public ResponseEntity post(@RequestBody RolDTO rolDTO) {
		RolDTO result = new RolDTO();
		try {
			result = service.post(rolDTO);
		} catch (Exception e) {
		}

		return ResponseEntity.status(201).body(result);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity put(@RequestBody RolDTO rolDTO, @PathVariable int id) {
		RolDTO result = new RolDTO();
		try {
			result = service.put(rolDTO, id);
		} catch (Exception e) {
			return ResponseEntity.status(400).body("{\"Error\":\"Bad Request.\"  } ");
		}

		rolDTO.setId(result.getId());
		return ResponseEntity.status(201).body(rolDTO);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable int id) {

		boolean result = service.delete(id);

		try {
			if (result) {
				return ResponseEntity.status(204).body("{ \"Succesful\": \"Correctly removed.\" }");
			} else {
				throw new StatusException("Bad request. Please verify the id", 400);
			}

		}catch(StatusException e) {
			return e.getResponseStatus();
		}
	}
}
