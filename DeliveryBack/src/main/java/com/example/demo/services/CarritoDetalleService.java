package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ArticuloInsumoDTO;
import com.example.demo.dto.ArticuloManufacturadoDTO;
import com.example.demo.dto.CarritoDetalleDTO;
import com.example.demo.entities.ArticuloInsumo;
import com.example.demo.entities.ArticuloManufacturado;
import com.example.demo.entities.CarritoDetalle;
import com.example.demo.repositories.CarritoDetalleRepository;

@Service
public class CarritoDetalleService {

	private CarritoDetalleRepository detalleRepository;

	public CarritoDetalleService(CarritoDetalleRepository detalleRepository) {
		this.detalleRepository = detalleRepository;
	}
	
	public List<CarritoDetalleDTO> getAll(){
		List<CarritoDetalleDTO> result=new ArrayList<>();
		
		for(CarritoDetalle det:detalleRepository.findAll()) {
			CarritoDetalleDTO detalleDto=new CarritoDetalleDTO();
			detalleDto.setId(det.getId());
			detalleDto.setCantidad(det.getCantidad());
			detalleDto.setSubtotal(det.getSubtotal());
			
			try {
				ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
				manufacturado.setId(det.getManufacturado().getId());
				manufacturado.setNombre(det.getManufacturado().getNombre());
				manufacturado.setPrecio(det.getManufacturado().getPrecio());
				manufacturado.setTiempoPreparacion(det.getManufacturado().getTiempoPreparacion());
				detalleDto.setManufacturado(manufacturado);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
				insumo.setId(det.getInsumo().getId());
				insumo.setNombre(det.getInsumo().getNombre());
				insumo.setDescripcion(det.getInsumo().getDescripcion());
				insumo.setStockActual(det.getInsumo().getStockActual());
				insumo.setStockMin(det.getInsumo().getStockMin());
				insumo.setStockMax(det.getInsumo().getStockMax());
				insumo.setPrecioCompra(det.getInsumo().getPrecioCompra());
				insumo.setPrecioVta(det.getInsumo().getPrecioVta());
				insumo.setEsInsumo(det.getInsumo().isEsInsumo());
				insumo.setEliminado(det.getInsumo().isEliminado());
				detalleDto.setInsumo(insumo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			result.add(detalleDto);
		}
		return result;
	}
	
	public CarritoDetalleDTO getOne(int id) {
		Optional<CarritoDetalle> opt=detalleRepository.findById(id);
		CarritoDetalleDTO detalleDto=new CarritoDetalleDTO();
		
		try {
			CarritoDetalle det=opt.get();
			detalleDto.setId(det.getId());
			detalleDto.setCantidad(det.getCantidad());
			detalleDto.setSubtotal(det.getSubtotal());
			
			try {
				ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
				manufacturado.setId(det.getManufacturado().getId());
				manufacturado.setNombre(det.getManufacturado().getNombre());
				manufacturado.setPrecio(det.getManufacturado().getPrecio());
				manufacturado.setTiempoPreparacion(det.getManufacturado().getTiempoPreparacion());
				detalleDto.setManufacturado(manufacturado);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
				insumo.setId(det.getInsumo().getId());
				insumo.setNombre(det.getInsumo().getNombre());
				insumo.setDescripcion(det.getInsumo().getDescripcion());
				insumo.setStockActual(det.getInsumo().getStockActual());
				insumo.setStockMin(det.getInsumo().getStockMin());
				insumo.setStockMax(det.getInsumo().getStockMax());
				insumo.setPrecioCompra(det.getInsumo().getPrecioCompra());
				insumo.setPrecioVta(det.getInsumo().getPrecioVta());
				insumo.setEsInsumo(det.getInsumo().isEsInsumo());
				insumo.setEliminado(det.getInsumo().isEliminado());
				detalleDto.setInsumo(insumo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return detalleDto;
	}
	
	public CarritoDetalleDTO save(CarritoDetalleDTO detalleDto) {
		CarritoDetalle det=new CarritoDetalle();
		det.setCantidad(detalleDto.getCantidad());
		
		try {
			ArticuloManufacturado manufacturado=new ArticuloManufacturado();
			manufacturado.setId(detalleDto.getManufacturado().getId());
			det.setManufacturado(manufacturado);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ArticuloInsumo insumo=new ArticuloInsumo();
			insumo.setId(detalleDto.getInsumo().getId());
			det.setInsumo(insumo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		detalleRepository.save(det);
		detalleDto.setId(det.getId());
		
		return detalleDto;
	}
	
	public CarritoDetalleDTO update(CarritoDetalleDTO detalleDto, int id) {
		Optional<CarritoDetalle> opt=detalleRepository.findById(id);
		CarritoDetalle det=new CarritoDetalle();
		try {
			det=opt.get();
			det.setCantidad(detalleDto.getCantidad());
			
			try {
				ArticuloManufacturado manufacturado=new ArticuloManufacturado();
				manufacturado.setId(detalleDto.getManufacturado().getId());
				det.setManufacturado(manufacturado);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				ArticuloInsumo insumo=new ArticuloInsumo();
				insumo.setId(detalleDto.getInsumo().getId());
				det.setInsumo(insumo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			detalleRepository.save(det);
			detalleDto.setId(det.getId());
		} catch (Exception e) {
			System.out.println("Bad Request");
			detalleDto.setId(0);
		}
		return detalleDto;
	}
	
	public boolean delete(int id) {
		try {
			detalleRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
