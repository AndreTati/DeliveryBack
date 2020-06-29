package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LocalidadDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.dto.ProvinciaDTO;
import com.example.demo.entities.Localidad;
import com.example.demo.entities.Provincia;
import com.example.demo.repositories.LocalidadRepository;

@Service
public class LocalidadService {
	private LocalidadRepository repository;

	public LocalidadService(LocalidadRepository repository) {
		this.repository = repository;
	}
	
	public LocalidadDTO getOne(int id) {
		Optional<Localidad> bd = repository.findById(id);
		
		LocalidadDTO localidadDTO = new LocalidadDTO();
		try {

			Localidad cg = bd.get();
			localidadDTO.setId(cg.getId());
			localidadDTO.setEliminado(cg.isEliminado());
			localidadDTO.setNombre(cg.getNombre());
		
			try {

				ProvinciaDTO provinciaDTO = new ProvinciaDTO();
				provinciaDTO.setId(cg.getProvincia().getId());
				provinciaDTO.setEliminado(cg.getProvincia().isEliminado());
				provinciaDTO.setNombre(cg.getProvincia().getNombre());
			
				try {

					PaisDTO paisDTO = new PaisDTO();
					paisDTO.setId(provinciaDTO.getPais().getId());
					paisDTO.setNombre(provinciaDTO.getPais().getNombre());
					paisDTO.setEliminado(provinciaDTO.getPais().isEliminado());

					provinciaDTO.setPais(paisDTO);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				
				
				localidadDTO.setProvincia(provinciaDTO);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return localidadDTO;

		} catch (Exception e) {

			return localidadDTO;
		}

	}
	
	public List<LocalidadDTO> getAll() {
		List<LocalidadDTO> lista = new ArrayList<>();

		for (Localidad cg : repository.findAll()) {
			LocalidadDTO temp = new LocalidadDTO();
			
			temp.setId(cg.getId());
			temp.setNombre(cg.getNombre());
			temp.setEliminado(cg.isEliminado());

			try {

				ProvinciaDTO provinciaDTO = new ProvinciaDTO();
				provinciaDTO.setId(cg.getProvincia().getId());
				provinciaDTO.setEliminado(cg.getProvincia().isEliminado());
				provinciaDTO.setNombre(cg.getProvincia().getNombre());
				try {

					PaisDTO paisDTO = new PaisDTO();
					paisDTO.setId(provinciaDTO.getPais().getId());
					paisDTO.setNombre(provinciaDTO.getPais().getNombre());
					paisDTO.setEliminado(provinciaDTO.getPais().isEliminado());

					provinciaDTO.setPais(paisDTO);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				temp.setProvincia(provinciaDTO);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			lista.add(temp);
		}

		return lista;
	}
	
	public LocalidadDTO post(LocalidadDTO localidadDTO) {
		Localidad cg = new Localidad();

		cg.setId(localidadDTO.getId());
		cg.setNombre(localidadDTO.getNombre());
		cg.setEliminado(localidadDTO.isEliminado());

		try {

			Provincia prov = new Provincia();
			prov.setId(localidadDTO.getProvincia().getId());
			prov.setNombre(localidadDTO.getProvincia().getNombre());
			prov.setEliminado(localidadDTO.getProvincia().isEliminado());
		
			cg.setProvincia(prov);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		repository.save(cg);

		localidadDTO.setId(cg.getId());
		return localidadDTO;

	}
	
	public LocalidadDTO put(LocalidadDTO localidadDTO, int id) {
		Optional<Localidad> temp = repository.findById(id);

		try {

			Localidad cg = temp.get();

			cg.setNombre(localidadDTO.getNombre());
			cg.setEliminado(localidadDTO.isEliminado());

			try {

				Provincia prov= new Provincia();
				prov.setId(localidadDTO.getProvincia().getId());
				prov.setNombre(localidadDTO.getProvincia().getNombre());
				prov.setEliminado(localidadDTO.getProvincia().isEliminado());
			
				cg.setProvincia(prov); 

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			repository.save(cg);

			localidadDTO.setId(cg.getId());
		} catch (Exception e) {
			System.out.print("Bad request");
		}
		return localidadDTO;
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
