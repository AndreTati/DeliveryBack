package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RolDTO;
import com.example.demo.entities.Rol;
import com.example.demo.repositories.RolRepository;

@Service
public class RolService {

		private RolRepository repository;

		public RolService(RolRepository repository) {
			this.repository = repository;
		}
		
		public List<RolDTO> getAll(){
			List<RolDTO> lista = new ArrayList<>();
			
			for (Rol cg : repository.findAll()) {
				RolDTO temp = new RolDTO();
				temp.setNombre(cg.getNombre());
				temp.setEliminado(cg.isEliminado());
				lista.add(temp);
			}

			return lista;
		}
		
		public RolDTO getOne(int id) {
			Optional<Rol> bd = repository.findById(id);
			RolDTO aux = new RolDTO();
			try {

				Rol cg = bd.get();
				aux.setId(cg.getId());
				aux.setNombre(cg.getNombre());
				aux.setEliminado(cg.isEliminado());

				return aux;

			} catch (Exception e) {

				return aux;
			}

		}
		
		
		public RolDTO post(RolDTO rolDTO) {
			Rol cg = new Rol();

			cg.setId(rolDTO.getId());
			cg.setNombre(rolDTO.getNombre());
			cg.setEliminado(rolDTO.isEliminado());
			
			try {
				repository.save(cg);
			} catch (Exception e) {

			}
			rolDTO.setId(cg.getId());
			return rolDTO;

		}
		
		public RolDTO put(RolDTO rolDTO, int id) {
			Optional<Rol> temp = repository.findById(id);
			try {
				Rol cg = temp.get();
				cg.setNombre(rolDTO.getNombre());
				cg.setEliminado(rolDTO.isEliminado());
				
				repository.save(cg);

				rolDTO.setId(cg.getId());
			} catch (Exception e) {
				System.out.print("Bad request");
			}
			return rolDTO;
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
