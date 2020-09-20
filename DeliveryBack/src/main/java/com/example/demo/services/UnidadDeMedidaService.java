package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.entities.UnidadDeMedida;
import com.example.demo.repositories.UnidadDeMedidaRepository;

@Service
public class UnidadDeMedidaService {

	private UnidadDeMedidaRepository unidadMedidaRepository;

	public UnidadDeMedidaService(UnidadDeMedidaRepository unidadMedidaRepository) {
		super();
		this.unidadMedidaRepository = unidadMedidaRepository;
	}
	
	public List<UnidadDeMedidaDTO> getAll(){
		List<UnidadDeMedidaDTO> result=new ArrayList<UnidadDeMedidaDTO>();
		for(UnidadDeMedida uniMed:unidadMedidaRepository.findAll()) {
			UnidadDeMedidaDTO uniDto=new UnidadDeMedidaDTO();
			uniDto.setId(uniMed.getId());
			uniDto.setNombre(uniMed.getNombre());
			uniDto.setAbreviatura(uniMed.getAbreviatura());
			uniDto.setEliminado(uniMed.isEliminado());
			result.add(uniDto);
		}
		return result;
	}
	
	public UnidadDeMedidaDTO getOne(int id) {
		Optional<UnidadDeMedida> opt=unidadMedidaRepository.findById(id);
		UnidadDeMedidaDTO uniDto=new UnidadDeMedidaDTO();
		
		try {
			UnidadDeMedida uniMed= opt.get();
			uniDto.setId(uniMed.getId());
			uniDto.setNombre(uniMed.getNombre());
			uniDto.setAbreviatura(uniMed.getAbreviatura());
			uniDto.setEliminado(uniMed.isEliminado());
		}catch(Exception e) {
			System.out.println("No existe el id");
		}
		return uniDto;
	}
	
	public UnidadDeMedidaDTO save(UnidadDeMedidaDTO unidadDTO) {
		UnidadDeMedida uniMed=new UnidadDeMedida();
		
		uniMed.setNombre(unidadDTO.getNombre());
		uniMed.setAbreviatura(unidadDTO.getAbreviatura());
		uniMed.setEliminado(unidadDTO.isEliminado());
		
		unidadMedidaRepository.save(uniMed);
		
		unidadDTO.setId(uniMed.getId());
		return unidadDTO;
	}
	
	public UnidadDeMedidaDTO update(UnidadDeMedidaDTO unidadDTO, int id) {
		Optional<UnidadDeMedida> opt=unidadMedidaRepository.findById(id);
		UnidadDeMedida uniMed=new UnidadDeMedida();
		
		try {
			uniMed=opt.get();
			uniMed.setNombre(unidadDTO.getNombre());
			uniMed.setAbreviatura(unidadDTO.getAbreviatura());
			unidadMedidaRepository.save(uniMed);
			
			unidadDTO.setId(uniMed.getId());
		}catch(Exception e) {
			System.out.println("Bad Request");
			unidadDTO.setId(0);
		}
		return unidadDTO;
	}
	
	public boolean delete(int id) {
		try {
			unidadMedidaRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
