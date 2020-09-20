package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ImagenDTO;
import com.example.demo.entities.Imagen;
import com.example.demo.repositories.ImagenRepository;

@Service
public class ImagenService {
	private ImagenRepository repository;

	public ImagenService(ImagenRepository repository) {
		this.repository = repository;
	}
	
	public ImagenDTO getOne(int id) {
		Optional<Imagen> bd = repository.findById(id);
		ImagenDTO imagenDTO = new ImagenDTO();
		try {

			Imagen cg = bd.get();
			imagenDTO.setId(cg.getId());
			imagenDTO.setUrl(cg.getUrl());
			

			return imagenDTO;

		} catch (Exception e) {

			return imagenDTO;
		}

	}

	public List<ImagenDTO> getAll() {
		List<ImagenDTO> lista = new ArrayList<>();
	
		for (Imagen cg : repository.findAll()) {
			ImagenDTO temp = new ImagenDTO();
			temp.setId(cg.getId());
			temp.setUrl(cg.getUrl());

			lista.add(temp);
		}

		return lista;

	}

	public ImagenDTO save(ImagenDTO imagenDTO) {
		Imagen cg = new Imagen();
		cg.setId(imagenDTO.getId());
		cg.setUrl(imagenDTO.getUrl());

		try {
			repository.save(cg);
		} catch (Exception e) {

		}
		imagenDTO.setId(cg.getId());
		return imagenDTO;
	}

	public ImagenDTO update(ImagenDTO imagenDTO, int id) {
		Optional<Imagen> temp = repository.findById(id);
		try {
			Imagen cg = temp.get();
			cg.setUrl(cg.getUrl());
			repository.save(cg);

			imagenDTO.setId(cg.getId());
		} catch (Exception e) {
			System.out.print("Bad request");
		}
		return imagenDTO;
	}

	public boolean delete(int id) {
		Optional<Imagen> temp = repository.findById(id);
		try {
			repository.delete(temp.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
