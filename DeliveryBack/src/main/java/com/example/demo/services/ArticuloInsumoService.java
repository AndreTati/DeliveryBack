package com.example.demo.services;

import java.util.*;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ArticuloInsumoDTO;
import com.example.demo.dto.CategoriaInsumoDTO;
import com.example.demo.dto.ImagenDTO;
import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.entities.ArticuloInsumo;
import com.example.demo.entities.CategoriaInsumo;
import com.example.demo.entities.Imagen;
import com.example.demo.entities.UnidadDeMedida;
import com.example.demo.repositories.ArticuloInsumoRepository;

@Service
public class ArticuloInsumoService {
	private ArticuloInsumoRepository insumoRepository;

	public ArticuloInsumoService(ArticuloInsumoRepository insumoRepository) {
		this.insumoRepository = insumoRepository;
	}
	
	public List<ArticuloInsumoDTO> getAll(){
		List<ArticuloInsumoDTO> result=new ArrayList<>();
		for(ArticuloInsumo ins:insumoRepository.findAll()) {
			ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
			insumo.setId(ins.getId());
			insumo.setNombre(ins.getNombre());
			insumo.setDescripcion(ins.getDescripcion());
			insumo.setEsInsumo(ins.isEsInsumo());
			insumo.setStockActual(ins.getStockActual());
			insumo.setStockMin(ins.getStockMin());
			insumo.setStockMax(ins.getStockMax());
			insumo.setPrecioCompra(ins.getPrecioCompra());
			insumo.setPrecioVta(ins.getPrecioVta());
			
			try {
				CategoriaInsumoDTO categoria=new CategoriaInsumoDTO();
				categoria.setId(ins.getCategoria().getId());
				categoria.setDenominacion(ins.getCategoria().getDenominacion());
				insumo.setCategoria(categoria);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				UnidadDeMedidaDTO unidadMedida=new UnidadDeMedidaDTO();
				unidadMedida.setId(ins.getUnidadMed().getId());
				unidadMedida.setNombre(ins.getUnidadMed().getNombre());
				unidadMedida.setAbreviatura(ins.getUnidadMed().getAbreviatura());
				insumo.setUnidadDeMed(unidadMedida);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(ins.getImg().getId());
				img.setUrl(ins.getImg().getUrl());
				insumo.setImg(img);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

			result.add(insumo);
			
		}
		return result;
	}
	
	public List<ArticuloInsumoDTO> getAllNoInsumos(boolean esInsumo){
		List<ArticuloInsumoDTO> result=new ArrayList<>();
		for(ArticuloInsumo ins:insumoRepository.getAllNoInsumos(esInsumo)) {
			ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
			insumo.setId(ins.getId());
			insumo.setNombre(ins.getNombre());
			insumo.setDescripcion(ins.getDescripcion());
			insumo.setEsInsumo(ins.isEsInsumo());
			insumo.setStockActual(ins.getStockActual());
			insumo.setStockMin(ins.getStockMin());
			insumo.setStockMax(ins.getStockMax());
			insumo.setPrecioCompra(ins.getPrecioCompra());
			insumo.setPrecioVta(ins.getPrecioVta());
			
			try {
				CategoriaInsumoDTO categoria=new CategoriaInsumoDTO();
				categoria.setId(ins.getCategoria().getId());
				categoria.setDenominacion(ins.getCategoria().getDenominacion());
				insumo.setCategoria(categoria);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				UnidadDeMedidaDTO unidadMedida=new UnidadDeMedidaDTO();
				unidadMedida.setId(ins.getUnidadMed().getId());
				unidadMedida.setNombre(ins.getUnidadMed().getNombre());
				unidadMedida.setAbreviatura(ins.getUnidadMed().getAbreviatura());
				insumo.setUnidadDeMed(unidadMedida);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(ins.getImg().getId());
				img.setUrl(ins.getImg().getUrl());
				insumo.setImg(img);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

			result.add(insumo);
			
		}
		return result;
	}
	
	public ArticuloInsumoDTO getOne(int id) {
		Optional<ArticuloInsumo>optional=insumoRepository.findById(id);
		ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
		try {
			ArticuloInsumo ins=optional.get();
			insumo.setId(ins.getId());
			insumo.setNombre(ins.getNombre());
			insumo.setDescripcion(ins.getDescripcion());
			insumo.setEsInsumo(ins.isEsInsumo());
			insumo.setStockActual(ins.getStockActual());
			insumo.setStockMin(ins.getStockMin());
			insumo.setStockMax(ins.getStockMax());
			insumo.setPrecioCompra(ins.getPrecioCompra());
			insumo.setPrecioVta(ins.getPrecioVta());
			try {
				CategoriaInsumoDTO categoria=new CategoriaInsumoDTO();
				categoria.setId(ins.getCategoria().getId());
				categoria.setDenominacion(ins.getCategoria().getDenominacion());
				insumo.setCategoria(categoria);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				UnidadDeMedidaDTO unidadMedida=new UnidadDeMedidaDTO();
				unidadMedida.setId(ins.getUnidadMed().getId());
				unidadMedida.setNombre(ins.getUnidadMed().getNombre());
				unidadMedida.setAbreviatura(ins.getUnidadMed().getAbreviatura());
				insumo.setUnidadDeMed(unidadMedida);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(ins.getImg().getId());
				img.setUrl(ins.getImg().getUrl());
				insumo.setImg(img);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}catch(Exception e) {
			System.out.println("No existe el id");
		}
		

		return insumo;
	}
	
	public ArticuloInsumoDTO save(ArticuloInsumoDTO insumoDto) {
		ArticuloInsumo ins=new ArticuloInsumo();
		ins.setNombre(insumoDto.getNombre());
		ins.setDescripcion(insumoDto.getDescripcion());
		ins.setEsInsumo(insumoDto.isEsInsumo());
		ins.setStockActual(insumoDto.getStockActual());
		ins.setStockMin(insumoDto.getStockMin());
		ins.setStockMax(insumoDto.getStockMax());
		ins.setPrecioCompra(insumoDto.getPrecioCompra());
		ins.setPrecioVta(insumoDto.getPrecioVta());
		
		try {
			CategoriaInsumo categoria=new CategoriaInsumo();
			categoria.setId(insumoDto.getCategoria().getId());
			categoria.setDenominacion(insumoDto.getCategoria().getDenominacion());
			ins.setCategoria(categoria);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			UnidadDeMedida unidadMedida=new UnidadDeMedida();
			unidadMedida.setId(insumoDto.getUnidadDeMed().getId());
			unidadMedida.setNombre(insumoDto.getUnidadDeMed().getNombre());
			unidadMedida.setAbreviatura(insumoDto.getUnidadDeMed().getAbreviatura());
			ins.setUnidadMed(unidadMedida);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Imagen img=new Imagen();
			img.setId(insumoDto.getImg().getId());
			img.setUrl(insumoDto.getImg().getUrl());
			ins.setImg(img);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		insumoRepository.save(ins);
		insumoDto.setId(ins.getId());
		
		return insumoDto;
	}
	
	
	public ArticuloInsumoDTO update(ArticuloInsumoDTO insumoDto, int id) {
		Optional<ArticuloInsumo> optional=insumoRepository.findById(id);
		ArticuloInsumo ins=new ArticuloInsumo();
		
		try {
			
			ins=optional.get();
			
			ins.setNombre(insumoDto.getNombre());
			ins.setDescripcion(insumoDto.getDescripcion());
			ins.setEsInsumo(insumoDto.isEsInsumo());
			ins.setStockActual(insumoDto.getStockActual());
			ins.setStockMin(insumoDto.getStockMin());
			ins.setStockMax(insumoDto.getStockMax());
			ins.setPrecioCompra(insumoDto.getPrecioCompra());
			ins.setPrecioVta(insumoDto.getPrecioVta());
			
			try {
				CategoriaInsumo categoria=new CategoriaInsumo();
				categoria.setId(insumoDto.getCategoria().getId());
				categoria.setDenominacion(insumoDto.getCategoria().getDenominacion());
				ins.setCategoria(categoria);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				UnidadDeMedida unidadMedida=new UnidadDeMedida();
				unidadMedida.setId(insumoDto.getUnidadDeMed().getId());
				unidadMedida.setNombre(insumoDto.getUnidadDeMed().getNombre());
				unidadMedida.setAbreviatura(insumoDto.getUnidadDeMed().getAbreviatura());
				ins.setUnidadMed(unidadMedida);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				Imagen img=new Imagen();
				img.setId(insumoDto.getImg().getId());
				img.setUrl(insumoDto.getImg().getUrl());
				ins.setImg(img);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			insumoRepository.save(ins);
			insumoDto.setId(ins.getId());
			
		}catch(Exception e) {
			System.out.println("Bad Request");
			insumoDto.setId(0);
		}
		
		
		
		return insumoDto;
	}
	
	
	public boolean delete(int id) {
		try {
			insumoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
