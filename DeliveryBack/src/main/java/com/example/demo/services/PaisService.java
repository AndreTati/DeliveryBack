package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PaisDTO;
import com.example.demo.entities.Pais;
import com.example.demo.repositories.PaisRepository;

@Service
public class PaisService {
	private PaisRepository repository;

	public PaisService(PaisRepository repository) {
		this.repository = repository;
	}
	
	public List<PaisDTO> getAll() {
		List<PaisDTO> lista = new ArrayList<>();
	
		for (Pais cg : repository.findAll()) {
			PaisDTO temp = new PaisDTO();
			temp.setId(cg.getId());
			temp.setNombre(cg.getNombre());
			temp.setEliminado(cg.isEliminado());
			lista.add(temp);
		}

		return lista;

	}
	
	public PaisDTO getOne(int id) {
		Optional<Pais> bd = repository.findById(id);
		PaisDTO temp = new PaisDTO();
		try {

			Pais cg = bd.get();
			temp.setId(cg.getId());
			temp.setNombre(cg.getNombre());
			temp.setEliminado(cg.isEliminado());

			return temp;

		} catch (Exception e) {

			return temp;
		}

	}
	
	public PaisDTO post(PaisDTO paisDTO) {
		Pais cg = new Pais();

		cg.setId(paisDTO.getId());
		cg.setNombre(paisDTO.getNombre());
		cg.setEliminado(paisDTO.isEliminado());
		
		try {
			repository.save(cg);
		} catch (Exception e) {

		}
		paisDTO.setId(cg.getId());
		return paisDTO;

	}
	
	public PaisDTO put(PaisDTO paisDTO, int id) {
		Optional<Pais> temp = repository.findById(id);
		try {
			Pais cg = temp.get();
			cg.setNombre(paisDTO.getNombre());
			cg.setEliminado(paisDTO.isEliminado());
			
			repository.save(cg);

			paisDTO.setId(cg.getId());
		} catch (Exception e) {
			System.out.print("Bad request");
		}
		return paisDTO;
	}
	public boolean delete(int id) {
		try {
			
			repository.deleteLogico(id);
			return true;
		} catch (Exception e) {
			return false;

		}

	}
	
}
