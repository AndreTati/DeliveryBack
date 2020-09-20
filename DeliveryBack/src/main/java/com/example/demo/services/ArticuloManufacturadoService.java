package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ArticuloInsumoDTO;
import com.example.demo.dto.ArticuloManufacturadoDTO;
import com.example.demo.dto.ArticuloManufacturadoDetalleDTO;
import com.example.demo.dto.CategoriaGeneralDTO;
import com.example.demo.dto.CategoriaInsumoDTO;
import com.example.demo.dto.ImagenDTO;
import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.entities.ArticuloInsumo;
import com.example.demo.entities.ArticuloManufacturado;
import com.example.demo.entities.ArticuloManufacturadoDetalle;
import com.example.demo.entities.CategoriaGeneral;
import com.example.demo.entities.CategoriaInsumo;
import com.example.demo.entities.Imagen;
import com.example.demo.repositories.ArticuloManufacturadoRepository;

@Service
public class ArticuloManufacturadoService {

	private ArticuloManufacturadoRepository manufacturadoRepository;

	public ArticuloManufacturadoService(ArticuloManufacturadoRepository manufacturadoRepository) {
		this.manufacturadoRepository = manufacturadoRepository;
	}
	
	public List<ArticuloManufacturadoDTO> getAll(){
		List<ArticuloManufacturadoDTO> result=new ArrayList<ArticuloManufacturadoDTO>();
		
		for(ArticuloManufacturado manuf : manufacturadoRepository.findAll()) {
			ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
			manufacturado.setId(manuf.getId());
			manufacturado.setNombre(manuf.getNombre());
			manufacturado.setTiempoPreparacion(manuf.getTiempoPreparacion());
			manufacturado.setEliminado(manuf.isEliminado());
			
			try {
				manufacturado.setPrecio(manuf.getPrecio());
			}catch(Exception e) {
				System.out.println("Vacío");
			}
			
			try {
				List<ArticuloManufacturadoDetalleDTO> detalles=new ArrayList<ArticuloManufacturadoDetalleDTO>();
				for(ArticuloManufacturadoDetalle manufacturadoDetalle : manuf.getDetalles()) {
					ArticuloManufacturadoDetalleDTO manufacturadoDetalleDto= new ArticuloManufacturadoDetalleDTO();
					manufacturadoDetalleDto.setId(manufacturadoDetalle.getId());
					manufacturadoDetalleDto.setCantidad(manufacturadoDetalle.getCantidad());
					
					ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
					insumo.setId(manufacturadoDetalle.getInsumo().getId());
					insumo.setNombre(manufacturadoDetalle.getInsumo().getNombre());
					insumo.setDescripcion(manufacturadoDetalle.getInsumo().getDescripcion());
					insumo.setStockActual(manufacturadoDetalle.getInsumo().getStockActual());
					insumo.setStockMin(manufacturadoDetalle.getInsumo().getStockMin());
					insumo.setStockMax(manufacturadoDetalle.getInsumo().getStockMax());
					insumo.setPrecioCompra(manufacturadoDetalle.getInsumo().getPrecioCompra());
					insumo.setPrecioVta(manufacturadoDetalle.getInsumo().getPrecioVta());
					insumo.setEsInsumo(manufacturadoDetalle.getInsumo().isEsInsumo());
					insumo.setEliminado(manufacturadoDetalle.getInsumo().isEsInsumo());
					try {
						CategoriaInsumoDTO cat= new CategoriaInsumoDTO();
						cat.setId(manufacturadoDetalle.getInsumo().getCategoria().getId());
						cat.setDenominacion(manufacturadoDetalle.getInsumo().getCategoria().getDenominacion());
						cat.setEliminado(manufacturadoDetalle.getInsumo().getCategoria().isEliminado());
						insumo.setCategoria(cat);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					try {
						UnidadDeMedidaDTO unidadMedida= new UnidadDeMedidaDTO();
						unidadMedida.setId(manufacturadoDetalle.getInsumo().getUnidadMed().getId());
						unidadMedida.setNombre(manufacturadoDetalle.getInsumo().getUnidadMed().getNombre());
						unidadMedida.setAbreviatura(manufacturadoDetalle.getInsumo().getUnidadMed().getAbreviatura());
						unidadMedida.setEliminado(manufacturadoDetalle.getInsumo().getUnidadMed().isEliminado());
						insumo.setUnidadDeMed(unidadMedida);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					
					manufacturadoDetalleDto.setInsumo(insumo);
					
					detalles.add(manufacturadoDetalleDto);
					
				}
				manufacturado.setDetalles(detalles);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				CategoriaGeneralDTO categoria=new CategoriaGeneralDTO();
				categoria.setId(manuf.getCategoria().getId());
				categoria.setDenominacion(manuf.getCategoria().getDenominacion());
				categoria.setEliminado(manuf.getCategoria().isEliminado());
				manufacturado.setCategoriaGral(categoria);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(manuf.getImg().getId());
				img.setUrl(manuf.getImg().getUrl());
				manufacturado.setImg(img);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			result.add(manufacturado);
		}
		return result;
	}
	
	public ArticuloManufacturadoDTO getOne(int id) {
		Optional<ArticuloManufacturado> opt=manufacturadoRepository.findById(id);
		ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
		
		try {
			ArticuloManufacturado manuf=opt.get();
			manufacturado.setId(manuf.getId());
			manufacturado.setNombre(manuf.getNombre());
			manufacturado.setTiempoPreparacion(manuf.getTiempoPreparacion());
			try {
				manufacturado.setPrecio(manuf.getPrecio());
			}catch(Exception e) {
				System.out.println("Vacío");
			}
			
			try {
				List<ArticuloManufacturadoDetalleDTO> detalles=new ArrayList<ArticuloManufacturadoDetalleDTO>();
				for(ArticuloManufacturadoDetalle manufacturadoDetalle : manuf.getDetalles()) {
					ArticuloManufacturadoDetalleDTO manufacturadoDetalleDto= new ArticuloManufacturadoDetalleDTO();
					manufacturadoDetalleDto.setId(manufacturadoDetalle.getId());
					manufacturadoDetalleDto.setCantidad(manufacturadoDetalle.getCantidad());
					
					ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
					insumo.setId(manufacturadoDetalle.getInsumo().getId());
					insumo.setNombre(manufacturadoDetalle.getInsumo().getNombre());
					insumo.setDescripcion(manufacturadoDetalle.getInsumo().getDescripcion());
					insumo.setStockActual(manufacturadoDetalle.getInsumo().getStockActual());
					insumo.setStockMin(manufacturadoDetalle.getInsumo().getStockMin());
					insumo.setStockMax(manufacturadoDetalle.getInsumo().getStockMax());
					insumo.setPrecioCompra(manufacturadoDetalle.getInsumo().getPrecioCompra());
					insumo.setPrecioVta(manufacturadoDetalle.getInsumo().getPrecioVta());
					insumo.setEsInsumo(manufacturadoDetalle.getInsumo().isEsInsumo());
					insumo.setEliminado(manufacturadoDetalle.getInsumo().isEsInsumo());
					
					try {
						CategoriaInsumoDTO cat= new CategoriaInsumoDTO();
						cat.setId(manufacturadoDetalle.getInsumo().getCategoria().getId());
						cat.setDenominacion(manufacturadoDetalle.getInsumo().getCategoria().getDenominacion());
						cat.setEliminado(manufacturadoDetalle.getInsumo().getCategoria().isEliminado());
						insumo.setCategoria(cat);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					try {
						UnidadDeMedidaDTO unidadMedida= new UnidadDeMedidaDTO();
						unidadMedida.setId(manufacturadoDetalle.getInsumo().getUnidadMed().getId());
						unidadMedida.setNombre(manufacturadoDetalle.getInsumo().getUnidadMed().getNombre());
						unidadMedida.setAbreviatura(manufacturadoDetalle.getInsumo().getUnidadMed().getAbreviatura());
						unidadMedida.setEliminado(manufacturadoDetalle.getInsumo().getUnidadMed().isEliminado());
						insumo.setUnidadDeMed(unidadMedida);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					manufacturadoDetalleDto.setInsumo(insumo);;
					detalles.add(manufacturadoDetalleDto);
					
				}
				manufacturado.setDetalles(detalles);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				CategoriaGeneralDTO categoria=new CategoriaGeneralDTO();
				categoria.setId(manuf.getCategoria().getId());
				categoria.setDenominacion(manuf.getCategoria().getDenominacion());
				categoria.setEliminado(manuf.getCategoria().isEliminado());
				manufacturado.setCategoriaGral(categoria);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(manuf.getImg().getId());
				img.setUrl(manuf.getImg().getUrl());
				manufacturado.setImg(img);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}catch(Exception e) {
			System.out.println("No existe el id");
		}
		return manufacturado;
	}
	
	public ArticuloManufacturadoDTO save(ArticuloManufacturadoDTO manufacturadoDto) {
		
		ArticuloManufacturado manufacturado=new ArticuloManufacturado();
		manufacturado.setNombre( manufacturadoDto.getNombre());
		manufacturado.setPrecio(manufacturadoDto.getPrecio());
		manufacturado.setTiempoPreparacion(manufacturadoDto.getTiempoPreparacion());
		
		try {
			List<ArticuloManufacturadoDetalle> detalles=new ArrayList<ArticuloManufacturadoDetalle>();
			for(ArticuloManufacturadoDetalleDTO detalleDto : manufacturadoDto.getDetalles()) {
				ArticuloManufacturadoDetalle dt=new ArticuloManufacturadoDetalle();
				dt.setCantidad(detalleDto.getCantidad());
				
				ArticuloInsumo insumo=new ArticuloInsumo();
				insumo.setId(detalleDto.getInsumo().getId());
				dt.setInsumo(insumo);
				dt.setManufacturado(manufacturado);
				detalles.add(dt);
			}
			manufacturado.setDetalles(detalles);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Imagen img=new Imagen();
			img.setUrl(manufacturadoDto.getImg().getUrl());
			manufacturado.setImg(img);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		manufacturadoRepository.save(manufacturado);
		manufacturadoDto.setId(manufacturado.getId());
		return manufacturadoDto;
	}
	
	public ArticuloManufacturadoDTO update(ArticuloManufacturadoDTO manufacturadoDto, int id) {
		
		Optional<ArticuloManufacturado> opt=manufacturadoRepository.findById(id);
		ArticuloManufacturado manufacturado=new ArticuloManufacturado();
		
		try {
			manufacturado=opt.get();
			manufacturado.setNombre(manufacturadoDto.getNombre());
			manufacturado.setTiempoPreparacion(manufacturadoDto.getTiempoPreparacion());
			manufacturado.setPrecio(manufacturadoDto.getPrecio());
			
			try {
				List<ArticuloManufacturadoDetalle> detalle=new ArrayList<ArticuloManufacturadoDetalle>();
				for(ArticuloManufacturadoDetalleDTO detalleDto : manufacturadoDto.getDetalles()) {
					ArticuloManufacturadoDetalle dt=new ArticuloManufacturadoDetalle();
					dt.setId(detalleDto.getId());
					dt.setCantidad(detalleDto.getCantidad());
					
					ArticuloInsumo insumo=new ArticuloInsumo();
					insumo.setId(detalleDto.getInsumo().getId());
					
					dt.setInsumo(insumo);
				}
				manufacturado.setDetalles(detalle);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				CategoriaGeneral categoria=new CategoriaGeneral();
				categoria.setId(manufacturadoDto.getCategoriaGral().getId());
				manufacturado.setCategoria(categoria);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				Imagen img=new Imagen();
				img.setUrl(manufacturadoDto.getImg().getUrl());
				manufacturado.setImg(img);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			manufacturadoRepository.save(manufacturado);
			manufacturadoDto.setId(manufacturado.getId());
		}catch(Exception e) {
			System.out.println("Bad Request");
			manufacturadoDto.setId(0);
		}
		return manufacturadoDto;
	}
	
	public boolean delete(int id) {
		try {
			
			manufacturadoRepository.deleteById(id);
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		
	}
}
