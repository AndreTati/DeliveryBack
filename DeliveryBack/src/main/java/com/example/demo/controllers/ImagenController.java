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
import com.example.demo.dto.ImagenDTO;
import com.example.demo.services.ImagenService;

@Controller
@RestController
@RequestMapping(path = "api/v1/imagen")
public class ImagenController {
	private ImagenService service;

	public ImagenController(ImagenService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	@CrossOrigin("*")
	public List<ImagenDTO> getAll() {
		return ResponseEntity.status(200).body(service.getAll()).getBody();
	}

	@GetMapping("/{id}")
	@CrossOrigin("*")
	public ImagenDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(service.getOne(id)).getBody();
	}

	
	@PostMapping(path="/") 
	@CrossOrigin("*")
	public ResponseEntity save(@RequestBody ImagenDTO imagenDTO) {
		ImagenDTO temp = service.save(imagenDTO);
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
	@CrossOrigin("*")
	public ResponseEntity update(@RequestBody ImagenDTO imagenDTO, @PathVariable int id) {
		ImagenDTO temp = service.update(imagenDTO, id);
		try {
			if(temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			}
			else {
				throw new StatusException ("Bad request. Please check the values", 400);
			}
		} catch (StatusException e) {
				return e.getResponseStatus();
		}
		
	}
	
	@DeleteMapping(path = "/{id}")
	@CrossOrigin("*")
	public ResponseEntity delete(@PathVariable int id) {
		
		boolean result = service.delete(id);
		
		if(result) {
			return ResponseEntity.status(204).body("");
		}
		else {
			return ResponseEntity.status(204).body("No ha sido borrado");
		}
		
		
		
	}
}

