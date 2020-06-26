package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoriaGeneralDTO;
import com.example.demo.entities.CategoriaGeneral;
import com.example.demo.repositories.CategoriaGeneralRepository;

@Service
public class CategoriaGeneralService {

	private CategoriaGeneralRepository repository;

	public CategoriaGeneralService(CategoriaGeneralRepository repository) {
		this.repository = repository;
	}

	

	public List<CategoriaGeneralDTO> getAll() {
		List<CategoriaGeneralDTO> lista = new ArrayList<>();
	
		for (CategoriaGeneral cg : repository.findAll()) {
			CategoriaGeneralDTO temp = new CategoriaGeneralDTO();
			temp.setId(cg.getId());
			temp.setDenominacion(cg.getDenominacion());

			lista.add(temp);
		}

		return lista;

	}
	
	public CategoriaGeneralDTO getOne(int id) {
		Optional<CategoriaGeneral> bd = repository.findById(id);
		CategoriaGeneralDTO categoriaGeneralDTO = new CategoriaGeneralDTO();
		try {

			CategoriaGeneral cg = bd.get();
			categoriaGeneralDTO.setId(cg.getId());
			categoriaGeneralDTO.setDenominacion(cg.getDenominacion());
			categoriaGeneralDTO.setEliminado(cg.isEliminado());

			return categoriaGeneralDTO;

		} catch (Exception e) {

			return categoriaGeneralDTO;
		}

	}

	public CategoriaGeneralDTO save(CategoriaGeneralDTO categoriaGeneralDTO) {
		CategoriaGeneral cg = new CategoriaGeneral();

		
		cg.setDenominacion(categoriaGeneralDTO.getDenominacion());
		cg.setEliminado(categoriaGeneralDTO.isEliminado());

		try {
			repository.save(cg);
		} catch (Exception e) {

		}
		categoriaGeneralDTO.setId(cg.getId());
		return categoriaGeneralDTO;

	}

	public CategoriaGeneralDTO update(CategoriaGeneralDTO categoriaGeneralDTO, int id) {
		Optional<CategoriaGeneral> temp = repository.findById(id);
		try {
			CategoriaGeneral cg = temp.get();
			cg.setDenominacion(categoriaGeneralDTO.getDenominacion());
			cg.setEliminado(categoriaGeneralDTO.isEliminado());

			repository.save(cg);

			categoriaGeneralDTO.setId(cg.getId());
		} catch (Exception e) {
			System.out.print("Bad request");
			categoriaGeneralDTO.setId(0);
		}
		return categoriaGeneralDTO;
	}

	public boolean delete(int id) {
		try {
			
			repository.deleteCategoriaGeneralById(id);
			return true;
		} catch (Exception e) {
			return false;

		}

	}

}
