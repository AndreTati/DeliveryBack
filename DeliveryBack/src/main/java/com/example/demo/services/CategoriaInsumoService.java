package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoriaInsumoDTO;
import com.example.demo.entities.CategoriaInsumo;
import com.example.demo.repositories.CategoriaInsumoRepository;

@Service
public class CategoriaInsumoService {

	private CategoriaInsumoRepository categoriaRepository;

	public CategoriaInsumoService(CategoriaInsumoRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}

	public List<CategoriaInsumoDTO> getAll(){
		List<CategoriaInsumoDTO> result=new ArrayList<>();
		
		for(CategoriaInsumo cat: categoriaRepository.findAll()) {
			CategoriaInsumoDTO categoria=new CategoriaInsumoDTO();
			categoria.setId(cat.getId());
			categoria.setDenominacion(cat.getDenominacion());
			categoria.setEliminado(cat.isEliminado());
			
			result.add(categoria);
		}
		return result;
	}
	
	public CategoriaInsumoDTO getOne(int id) {
		Optional<CategoriaInsumo> opt=categoriaRepository.findById(id);
		CategoriaInsumoDTO categoria=new CategoriaInsumoDTO();
		
		try {
			CategoriaInsumo cat=opt.get();
			categoria.setId(cat.getId());
			categoria.setDenominacion(cat.getDenominacion());
			categoria.setEliminado(cat.isEliminado());
		}catch(Exception e) {
			System.out.println("No existe el id");
		}
		return categoria;
	}
	
	public CategoriaInsumoDTO save(CategoriaInsumoDTO categoriaDTO) {
		CategoriaInsumo cat=new CategoriaInsumo();
		
		cat.setDenominacion(categoriaDTO.getDenominacion());
		categoriaRepository.save(cat);
		categoriaDTO.setId(cat.getId());
		
		return categoriaDTO;
	}
	
	public CategoriaInsumoDTO update(CategoriaInsumoDTO categoriaDTO, int id) {
		
		Optional<CategoriaInsumo> opt=categoriaRepository.findById(id);
		CategoriaInsumo cat=new CategoriaInsumo();
		
		try {
			cat=opt.get();
			cat.setDenominacion(categoriaDTO.getDenominacion());
			
			categoriaRepository.save(cat);
			categoriaDTO.setId(cat.getId());
		}catch(Exception e) {
			System.out.println("Bad Request");
			categoriaDTO.setId(0);
		}
		return categoriaDTO;
	}
	
	public boolean delete(int id) {
		try {
			categoriaRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	
}
