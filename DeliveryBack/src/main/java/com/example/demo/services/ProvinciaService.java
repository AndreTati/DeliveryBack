package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PaisDTO;
import com.example.demo.dto.ProvinciaDTO;
import com.example.demo.entities.Pais;
import com.example.demo.entities.Provincia;
import com.example.demo.repositories.ProvinciaRepository;

@Service
public class ProvinciaService {
	private ProvinciaRepository repository;

	public ProvinciaService(ProvinciaRepository repository) {
		this.repository = repository;
	}
	
	public ProvinciaDTO getOne(int id) {
		Optional<Provincia> bd = repository.findById(id);
		
		ProvinciaDTO provinciaDTO = new ProvinciaDTO();
		try {

			Provincia cg = bd.get();
			provinciaDTO.setId(cg.getId());
			provinciaDTO.setEliminado(cg.isEliminado());
			provinciaDTO.setNombre(cg.getNombre());
		
			try {

				PaisDTO paisDTO = new PaisDTO();
				paisDTO.setId(cg.getPais().getId());
				paisDTO.setNombre(cg.getPais().getNombre());
				paisDTO.setEliminado(cg.getPais().isEliminado());

				provinciaDTO.setPais(paisDTO);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return provinciaDTO;

		} catch (Exception e) {

			return provinciaDTO;
		}

	}
	
	
	
	public List<ProvinciaDTO> getAll() {
		List<ProvinciaDTO> lista = new ArrayList<>();

		for (Provincia cg : repository.findAll()) {
			ProvinciaDTO temp = new ProvinciaDTO();
			
			temp.setId(cg.getId());
			temp.setNombre(cg.getNombre());
			temp.setEliminado(cg.isEliminado());

			try {

				PaisDTO paisDTO = new PaisDTO();
				paisDTO.setId(cg.getPais().getId());
				paisDTO.setNombre(cg.getPais().getNombre());
				paisDTO.setEliminado(cg.getPais().isEliminado());

				temp.setPais(paisDTO);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			lista.add(temp);
		}

		return lista;
	}
	
	public ProvinciaDTO post(ProvinciaDTO provinciaDTO) {
		Provincia cg = new Provincia();

		cg.setId(provinciaDTO.getId());
		cg.setNombre(provinciaDTO.getNombre());
		cg.setEliminado(provinciaDTO.isEliminado());

		try {

			Pais pais = new Pais();
			pais.setId(provinciaDTO.getPais().getId());
			pais.setNombre(provinciaDTO.getPais().getNombre());
			pais.setEliminado(provinciaDTO.getPais().isEliminado());
		
			cg.setPais(pais); 

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		repository.save(cg);

		provinciaDTO.setId(cg.getId());
		return provinciaDTO;

	}
	
	public ProvinciaDTO put(ProvinciaDTO provinciaDTO, int id) {
		Optional<Provincia> temp = repository.findById(id);

		try {

			Provincia cg = temp.get();

			cg.setNombre(provinciaDTO.getNombre());
			cg.setEliminado(provinciaDTO.isEliminado());

			try {

				Pais pais = new Pais();
				pais.setId(provinciaDTO.getPais().getId());
				pais.setNombre(provinciaDTO.getPais().getNombre());
				pais.setEliminado(provinciaDTO.getPais().isEliminado());
			
				cg.setPais(pais); 

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			repository.save(cg);

			provinciaDTO.setId(cg.getId());
		} catch (Exception e) {
			System.out.print("Bad request");
		}
		return provinciaDTO;
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
