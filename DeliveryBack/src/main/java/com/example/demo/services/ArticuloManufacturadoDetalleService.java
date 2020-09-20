package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ArticuloInsumoDTO;
import com.example.demo.dto.ArticuloManufacturadoDTO;
import com.example.demo.dto.ArticuloManufacturadoDetalleDTO;
import com.example.demo.dto.CategoriaInsumoDTO;
import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.entities.ArticuloInsumo;
import com.example.demo.entities.ArticuloManufacturado;
import com.example.demo.entities.ArticuloManufacturadoDetalle;
import com.example.demo.repositories.ArticuloManufacturadoDetalleRepository;

@Service
public class ArticuloManufacturadoDetalleService {

	private ArticuloManufacturadoDetalleRepository detalleRepository;

	public ArticuloManufacturadoDetalleService(ArticuloManufacturadoDetalleRepository detalleRepository) {
		this.detalleRepository = detalleRepository;
	}
	
	public List<ArticuloManufacturadoDetalleDTO> getAll(){
		List<ArticuloManufacturadoDetalleDTO>result=new ArrayList<ArticuloManufacturadoDetalleDTO>();
		for(ArticuloManufacturadoDetalle det:detalleRepository.findAll()) {
			ArticuloManufacturadoDetalleDTO detalleDto=new ArticuloManufacturadoDetalleDTO();
			detalleDto.setId(det.getId());
			detalleDto.setCantidad(det.getCantidad());
			
			try {
				ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
				insumo.setId(det.getInsumo().getId());
				insumo.setNombre(det.getInsumo().getNombre());
				insumo.setDescripcion(det.getInsumo().getDescripcion());
				insumo.setPrecioCompra(det.getInsumo().getPrecioCompra());
				insumo.setPrecioVta(det.getInsumo().getPrecioVta());
				insumo.setEsInsumo(det.getInsumo().isEsInsumo());
				insumo.setStockActual(det.getInsumo().getStockActual());
				insumo.setStockMin(det.getInsumo().getStockMin());
				insumo.setStockMax(det.getInsumo().getStockMax());
				insumo.setEliminado(det.getInsumo().isEliminado());
				try {
					CategoriaInsumoDTO cat=new CategoriaInsumoDTO();
					cat.setId(det.getInsumo().getCategoria().getId());
					cat.setDenominacion(det.getInsumo().getCategoria().getDenominacion());
					insumo.setCategoria(cat);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				try {
					UnidadDeMedidaDTO uniMed=new UnidadDeMedidaDTO();
					uniMed.setId(det.getInsumo().getUnidadMed().getId());
					uniMed.setNombre(det.getInsumo().getUnidadMed().getNombre());
					uniMed.setAbreviatura(det.getInsumo().getUnidadMed().getAbreviatura());
					insumo.setUnidadDeMed(uniMed);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				detalleDto.setInsumo(insumo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
				manufacturado.setId(det.getManufacturado().getId());
				detalleDto.setManufacturado(manufacturado);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			result.add(detalleDto);
		}
		return result;
	}
	
	public ArticuloManufacturadoDetalleDTO getOne(int id) {
		Optional<ArticuloManufacturadoDetalle> opt=detalleRepository.findById(id);
		ArticuloManufacturadoDetalleDTO detalleDto=new ArticuloManufacturadoDetalleDTO();
		
		try {
			ArticuloManufacturadoDetalle det=opt.get();
			detalleDto.setId(det.getId());
			detalleDto.setCantidad(det.getCantidad());
			try {
				ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
				insumo.setId(det.getInsumo().getId());
				insumo.setNombre(det.getInsumo().getNombre());
				insumo.setDescripcion(det.getInsumo().getDescripcion());
				insumo.setPrecioCompra(det.getInsumo().getPrecioCompra());
				insumo.setPrecioVta(det.getInsumo().getPrecioVta());
				insumo.setEsInsumo(det.getInsumo().isEsInsumo());
				insumo.setStockActual(det.getInsumo().getStockActual());
				insumo.setStockMin(det.getInsumo().getStockMin());
				insumo.setStockMax(det.getInsumo().getStockMax());
				insumo.setEliminado(det.getInsumo().isEliminado());
				CategoriaInsumoDTO cat=new CategoriaInsumoDTO();
				cat.setId(det.getInsumo().getCategoria().getId());
				cat.setDenominacion(det.getInsumo().getCategoria().getDenominacion());
				insumo.setCategoria(cat);
				UnidadDeMedidaDTO uniMed=new UnidadDeMedidaDTO();
				uniMed.setId(det.getInsumo().getUnidadMed().getId());
				uniMed.setNombre(det.getInsumo().getUnidadMed().getNombre());
				uniMed.setAbreviatura(det.getInsumo().getUnidadMed().getAbreviatura());
				insumo.setUnidadDeMed(uniMed);
				detalleDto.setInsumo(insumo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
				manufacturado.setId(det.getManufacturado().getId());
				detalleDto.setManufacturado(manufacturado);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return detalleDto;
	}
	
	public ArticuloManufacturadoDetalleDTO save(ArticuloManufacturadoDetalleDTO detalleDto) {
		ArticuloManufacturadoDetalle det=new ArticuloManufacturadoDetalle();
		det.setCantidad(detalleDto.getCantidad());
		try {
			ArticuloInsumo insumo=new ArticuloInsumo();
			insumo.setId(detalleDto.getInsumo().getId());
			det.setInsumo(insumo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ArticuloManufacturado manufacturado=new ArticuloManufacturado();
			manufacturado.setId(detalleDto.getManufacturado().getId());
			det.setManufacturado(manufacturado);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		detalleRepository.save(det);
		detalleDto.setId(det.getId());
		return detalleDto;
	}
	
	public ArticuloManufacturadoDetalleDTO update(ArticuloManufacturadoDetalleDTO detalleDto, int id) {
		Optional<ArticuloManufacturadoDetalle>opt=detalleRepository.findById(id);
		ArticuloManufacturadoDetalle det=new ArticuloManufacturadoDetalle();
		try {
			det=opt.get();
			det.setCantidad(detalleDto.getCantidad());
			try {
				ArticuloInsumo insumo=new ArticuloInsumo();
				insumo.setId(detalleDto.getInsumo().getId());
				det.setInsumo(insumo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			detalleRepository.save(det);
			detalleDto.setId(det.getId());
		}catch (Exception e) {
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
	public List<ArticuloManufacturadoDetalleDTO> getAllFromId(int id) {
		List<ArticuloManufacturadoDetalleDTO> lista = new ArrayList<>();
		for (ArticuloManufacturadoDetalle cg :  detalleRepository.getAllFromId(id)  ) {
			
			ArticuloManufacturadoDetalleDTO temp = new ArticuloManufacturadoDetalleDTO();
			
			temp.setId(cg.getId());
			temp.setCantidad(cg.getCantidad());

			try {
				ArticuloInsumoDTO aiDto = new ArticuloInsumoDTO();
				aiDto.setId(cg.getInsumo().getId());
				aiDto.setNombre(cg.getInsumo().getNombre());
				aiDto.setDescripcion(cg.getInsumo().getDescripcion());
				aiDto.setPrecioCompra(cg.getInsumo().getPrecioCompra());
				aiDto.setStockActual(cg.getInsumo().getStockActual());
				aiDto.setStockMax(cg.getInsumo().getStockMax());
				aiDto.setStockMin(cg.getInsumo().getStockMin());
				aiDto.setPrecioVta(cg.getInsumo().getPrecioVta());
				aiDto.setEliminado(cg.getInsumo().isEliminado());
				aiDto.setEsInsumo(cg.getInsumo().isEsInsumo());
				
				try {

					CategoriaInsumoDTO categoria = new CategoriaInsumoDTO();
					categoria.setId(aiDto.getCategoria().getId());
					categoria.setDenominacion(aiDto.getCategoria().getDenominacion());
					categoria.setEliminado(aiDto.getCategoria().isEliminado());

					aiDto.setCategoria(categoria);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				try {
					UnidadDeMedidaDTO unidadMedida = new UnidadDeMedidaDTO();
					unidadMedida.setId(aiDto.getUnidadDeMed().getId());
					unidadMedida.setNombre(aiDto.getUnidadDeMed().getNombre());
					unidadMedida.setAbreviatura(aiDto.getUnidadDeMed().getAbreviatura());
					unidadMedida.setEliminado(aiDto.getUnidadDeMed().isEliminado());

					aiDto.setUnidadDeMed(unidadMedida);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
			}catch(Exception e){ 
				System.out.println(e.getMessage());
			}
			lista.add(temp);
		}
		return lista;
		}
	
}
