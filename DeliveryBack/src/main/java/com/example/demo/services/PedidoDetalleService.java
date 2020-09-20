package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ArticuloInsumoDTO;
import com.example.demo.dto.ArticuloManufacturadoDTO;
import com.example.demo.dto.PedidoDetalleDTO;
import com.example.demo.entities.ArticuloInsumo;
import com.example.demo.entities.ArticuloManufacturado;
import com.example.demo.entities.PedidoDetalle;
import com.example.demo.repositories.PedidoDetalleRepository;

@Service
public class PedidoDetalleService {

	private PedidoDetalleRepository detalleRepository;

	public PedidoDetalleService(PedidoDetalleRepository detalleRepository) {
		this.detalleRepository = detalleRepository;
	}
	
	public List<PedidoDetalleDTO> getAll(){
		List<PedidoDetalleDTO> result=new ArrayList<PedidoDetalleDTO>();
		
		for(PedidoDetalle det:detalleRepository.findAll()) {
			PedidoDetalleDTO detalleDto=new PedidoDetalleDTO();
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
	
	public PedidoDetalleDTO getOne(int id) {
		Optional<PedidoDetalle> opt=detalleRepository.findById(id);
		PedidoDetalleDTO detalleDto=new PedidoDetalleDTO();
		
		try {
			PedidoDetalle det=opt.get();
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
	
	public PedidoDetalleDTO save(PedidoDetalleDTO detalleDto) {
		PedidoDetalle det=new PedidoDetalle();
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
	
	public PedidoDetalleDTO update(PedidoDetalleDTO detalleDto, int id) {
		
		Optional<PedidoDetalle> opt=detalleRepository.findById(id);
		PedidoDetalle det=new PedidoDetalle();
		
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
