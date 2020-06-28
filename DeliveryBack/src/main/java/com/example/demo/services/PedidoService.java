package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ArticuloInsumoDTO;
import com.example.demo.dto.ArticuloManufacturadoDTO;
import com.example.demo.dto.ArticuloManufacturadoDetalleDTO;
import com.example.demo.dto.CategoriaInsumoDTO;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.PedidoDTO;
import com.example.demo.dto.PedidoDetalleDTO;
import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.entities.ArticuloInsumo;
import com.example.demo.entities.ArticuloManufacturado;
import com.example.demo.entities.ArticuloManufacturadoDetalle;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Pedido;
import com.example.demo.entities.PedidoDetalle;
import com.example.demo.repositories.ArticuloInsumoRepository;
import com.example.demo.repositories.ArticuloManufacturadoRepository;
import com.example.demo.repositories.PedidoRepository;

@Service
public class PedidoService {
	private PedidoRepository pedidoRepositoy;
	private ArticuloInsumoRepository insumoRepository;
	private ArticuloManufacturadoRepository manufacturadoRepository;

	

	public PedidoService(PedidoRepository pedidoRepositoy, ArticuloInsumoRepository insumoRepository,
			ArticuloManufacturadoRepository manufacturadoRepository) {
		this.pedidoRepositoy = pedidoRepositoy;
		this.insumoRepository = insumoRepository;
		this.manufacturadoRepository = manufacturadoRepository;
	}

	public List<PedidoDTO> getAll(){
		List<PedidoDTO> result=new ArrayList<>();
		
		for(Pedido pedido : pedidoRepositoy.findAll()) {
			PedidoDTO pedDto=new PedidoDTO();
			pedDto.setId(pedido.getId());
			pedDto.setEliminado(pedido.isEliminado());
			pedDto.setFecha(pedido.getFecha());
			pedDto.setHoraEstimadaFin(pedido.getHoraEstimadaFin());
			pedDto.setNro(pedido.getNro());
			pedDto.setTipoEnvio(pedido.getTipoEnvio());
			pedDto.setMontoDescuento(pedido.getMontoDescuento());
			pedDto.setTotal(pedido.getTotal());
			pedDto.setEstado(pedido.getEstado());
			pedDto.setNro(pedido.getNro());
			
			try {
				ClienteDTO cli=new ClienteDTO();
				cli.setId(pedido.getCliente().getId());
				cli.setNombre(pedido.getCliente().getNombre());
				cli.setApellido(pedido.getCliente().getApellido());
				cli.setDni(pedido.getCliente().getDni());
				cli.setEmail(pedido.getCliente().getEmail());
				pedDto.setCliente(cli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<PedidoDetalleDTO> detDto=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle detalle: pedido.getDetalles()) {
					PedidoDetalleDTO detalleDto=new PedidoDetalleDTO();
					detalleDto.setId(detalle.getId());
					detalleDto.setCantidad(detalle.getCantidad());
					
					if(detalle.getInsumo()!=null) {
						ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
						insumo.setId(detalle.getInsumo().getId());
						insumo.setNombre(detalle.getInsumo().getNombre());
						insumo.setDescripcion(detalle.getInsumo().getDescripcion());
						insumo.setEsInsumo(detalle.getInsumo().isEsInsumo());
						insumo.setPrecioCompra(detalle.getInsumo().getPrecioCompra());
						insumo.setPrecioVta(detalle.getInsumo().getPrecioVta());
						insumo.setStockActual(detalle.getInsumo().getStockActual());
						insumo.setStockMax(detalle.getInsumo().getStockMax());
						insumo.setStockMin(detalle.getInsumo().getStockMin());
						UnidadDeMedidaDTO uniMed=new UnidadDeMedidaDTO();
						uniMed.setId(detalle.getInsumo().getUnidadMed().getId());
						uniMed.setNombre(detalle.getInsumo().getUnidadMed().getNombre());
						uniMed.setAbreviatura(detalle.getInsumo().getUnidadMed().getAbreviatura());
						uniMed.setEliminado(detalle.getInsumo().getUnidadMed().isEliminado());
						insumo.setUnidadDeMed(uniMed);
						detalleDto.setInsumo(insumo);
					}
					
					if(detalle.getManufacturado()!=null) {
						ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
						manufacturado.setId(detalle.getManufacturado().getId());
						manufacturado.setNombre(detalle.getManufacturado().getNombre());
						manufacturado.setPrecio(detalle.getManufacturado().getPrecio());
						manufacturado.setTiempoPreparacion(detalle.getManufacturado().getTiempoPreparacion());
						
						List<ArticuloManufacturadoDetalleDTO> detallesManuf=new ArrayList<ArticuloManufacturadoDetalleDTO>();
						for(ArticuloManufacturadoDetalle det: detalle.getManufacturado().getDetalles()) {
							ArticuloManufacturadoDetalleDTO temp=new ArticuloManufacturadoDetalleDTO();
							temp.setId(det.getId());
							temp.setCantidad(det.getCantidad());
							ArticuloInsumoDTO insumoDetalle =new ArticuloInsumoDTO();
							insumoDetalle.setId(det.getInsumo().getId());
							insumoDetalle.setNombre(det.getInsumo().getNombre());
							insumoDetalle.setDescripcion(det.getInsumo().getDescripcion());
							insumoDetalle.setPrecioCompra(det.getInsumo().getPrecioCompra());
							insumoDetalle.setPrecioVta(det.getInsumo().getPrecioVta());
							insumoDetalle.setStockActual(det.getInsumo().getStockActual());
							insumoDetalle.setStockMax(det.getInsumo().getStockMax());
							insumoDetalle.setStockMin(det.getInsumo().getStockMin());
							insumoDetalle.setEsInsumo(det.getInsumo().isEsInsumo());
							CategoriaInsumoDTO categoria=new CategoriaInsumoDTO();
							categoria.setId(det.getInsumo().getCategoria().getId());
							categoria.setDenominacion(det.getInsumo().getCategoria().getDenominacion());
							insumoDetalle.setCategoria(categoria);
							UnidadDeMedidaDTO unidad=new UnidadDeMedidaDTO();
							unidad.setId(det.getInsumo().getUnidadMed().getId());
							unidad.setNombre(det.getInsumo().getUnidadMed().getNombre());
							unidad.setAbreviatura(det.getInsumo().getUnidadMed().getAbreviatura());
							insumoDetalle.setUnidadDeMed(unidad);
							
							temp.setInsumo(insumoDetalle);
							
							detallesManuf.add(temp);
						}
						manufacturado.setDetalles(detallesManuf);
						
						detalleDto.setManufacturado(manufacturado);
					}
					detDto.add(detalleDto);
				}
				pedDto.setDetalles(detDto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			result.add(pedDto);
		}
		return result;
	}
	
	public PedidoDTO getOne(int id) {
		Optional<Pedido> opt=pedidoRepositoy.findById(id);
		PedidoDTO pedDto=new PedidoDTO();
		
		try {
			Pedido pedido=new Pedido();
			pedDto.setId(pedido.getId());
			pedDto.setEliminado(pedido.isEliminado());
			pedDto.setFecha(pedido.getFecha());
			pedDto.setHoraEstimadaFin(pedido.getHoraEstimadaFin());
			pedDto.setNro(pedido.getNro());
			pedDto.setTipoEnvio(pedido.getTipoEnvio());
			pedDto.setMontoDescuento(pedido.getMontoDescuento());
			pedDto.setTotal(pedido.getTotal());
			pedDto.setEstado(pedido.getEstado());
			pedDto.setNro(pedido.getNro());
			
			try {
				ClienteDTO cli=new ClienteDTO();
				cli.setId(pedido.getCliente().getId());
				cli.setNombre(pedido.getCliente().getNombre());
				cli.setApellido(pedido.getCliente().getApellido());
				cli.setDni(pedido.getCliente().getDni());
				cli.setEmail(pedido.getCliente().getEmail());
				pedDto.setCliente(cli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<PedidoDetalleDTO> detDto=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle detalle: pedido.getDetalles()) {
					PedidoDetalleDTO detalleDto=new PedidoDetalleDTO();
					detalleDto.setId(detalle.getId());
					detalleDto.setCantidad(detalle.getCantidad());
					
					if(detalle.getInsumo()!=null) {
						ArticuloInsumoDTO insumo=new ArticuloInsumoDTO();
						insumo.setId(detalle.getInsumo().getId());
						insumo.setNombre(detalle.getInsumo().getNombre());
						insumo.setDescripcion(detalle.getInsumo().getDescripcion());
						insumo.setEsInsumo(detalle.getInsumo().isEsInsumo());
						insumo.setPrecioCompra(detalle.getInsumo().getPrecioCompra());
						insumo.setPrecioVta(detalle.getInsumo().getPrecioVta());
						insumo.setStockActual(detalle.getInsumo().getStockActual());
						insumo.setStockMax(detalle.getInsumo().getStockMax());
						insumo.setStockMin(detalle.getInsumo().getStockMin());
						UnidadDeMedidaDTO uniMed=new UnidadDeMedidaDTO();
						uniMed.setId(detalle.getInsumo().getUnidadMed().getId());
						uniMed.setNombre(detalle.getInsumo().getUnidadMed().getNombre());
						uniMed.setAbreviatura(detalle.getInsumo().getUnidadMed().getAbreviatura());
						uniMed.setEliminado(detalle.getInsumo().getUnidadMed().isEliminado());
						insumo.setUnidadDeMed(uniMed);
						detalleDto.setInsumo(insumo);
					}
					
					if(detalle.getManufacturado()!=null) {
						ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
						manufacturado.setId(detalle.getManufacturado().getId());
						manufacturado.setNombre(detalle.getManufacturado().getNombre());
						manufacturado.setPrecio(detalle.getManufacturado().getPrecio());
						manufacturado.setTiempoPreparacion(detalle.getManufacturado().getTiempoPreparacion());
						
						List<ArticuloManufacturadoDetalleDTO> detallesManuf=new ArrayList<ArticuloManufacturadoDetalleDTO>();
						for(ArticuloManufacturadoDetalle det: detalle.getManufacturado().getDetalles()) {
							ArticuloManufacturadoDetalleDTO temp=new ArticuloManufacturadoDetalleDTO();
							temp.setId(det.getId());
							temp.setCantidad(det.getCantidad());
							ArticuloInsumoDTO insumoDetalle =new ArticuloInsumoDTO();
							insumoDetalle.setId(det.getInsumo().getId());
							insumoDetalle.setNombre(det.getInsumo().getNombre());
							insumoDetalle.setDescripcion(det.getInsumo().getDescripcion());
							insumoDetalle.setPrecioCompra(det.getInsumo().getPrecioCompra());
							insumoDetalle.setPrecioVta(det.getInsumo().getPrecioVta());
							insumoDetalle.setStockActual(det.getInsumo().getStockActual());
							insumoDetalle.setStockMax(det.getInsumo().getStockMax());
							insumoDetalle.setStockMin(det.getInsumo().getStockMin());
							insumoDetalle.setEsInsumo(det.getInsumo().isEsInsumo());
							CategoriaInsumoDTO categoria=new CategoriaInsumoDTO();
							categoria.setId(det.getInsumo().getCategoria().getId());
							categoria.setDenominacion(det.getInsumo().getCategoria().getDenominacion());
							insumoDetalle.setCategoria(categoria);
							UnidadDeMedidaDTO unidad=new UnidadDeMedidaDTO();
							unidad.setId(det.getInsumo().getUnidadMed().getId());
							unidad.setNombre(det.getInsumo().getUnidadMed().getNombre());
							unidad.setAbreviatura(det.getInsumo().getUnidadMed().getAbreviatura());
							insumoDetalle.setUnidadDeMed(unidad);
							
							temp.setInsumo(insumoDetalle);
							
							detallesManuf.add(temp);
						}
						manufacturado.setDetalles(detallesManuf);
						
						detalleDto.setManufacturado(manufacturado);
					}
					detDto.add(detalleDto);
				}
				pedDto.setDetalles(detDto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return pedDto;
		
	}
	
	public PedidoDTO save(PedidoDTO pedidoDto) {
		
		Pedido pedido =new Pedido();
		
		pedido.setHoraEstimadaFin(pedidoDto.getHoraEstimadaFin());
		pedido.setFecha(pedidoDto.getFecha());
		pedido.setMontoDescuento(pedidoDto.getMontoDescuento());
		pedido.setNro(pedidoDto.getNro());
		pedido.setTipoEnvio(pedidoDto.getTipoEnvio());
		pedido.setEstado(pedidoDto.getEstado());
		pedido.setTotal(pedido.getTotal());
		
		try {
			Cliente cli=new Cliente();
			cli.setId(pedidoDto.getCliente().getId());
			pedido.setCliente(cli);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<PedidoDetalle> detalle=new ArrayList<PedidoDetalle>();
		try {
			for(PedidoDetalleDTO detalleDto: pedidoDto.getDetalles()) {
				PedidoDetalle temp=new PedidoDetalle();
				temp.setCantidad(detalleDto.getCantidad());
				
				try {
					if(detalleDto.getInsumo()!=null) {
						ArticuloInsumo insumo=new ArticuloInsumo();
						insumo.setId(detalleDto.getInsumo().getId());
						temp.setInsumo(insumo);
					}
					
					if(detalleDto.getManufacturado()!=null) {
						ArticuloManufacturado manufacturado=new ArticuloManufacturado();
						manufacturado.setId(detalleDto.getManufacturado().getId());
						for(ArticuloManufacturadoDetalle manufDetalle : manufacturado.getDetalles()) {
							ArticuloInsumo ins=new ArticuloInsumo();
							ins.setId(manufDetalle.getInsumo().getId());
							manufDetalle.setInsumo(ins);
						}
						temp.setManufacturado(manufacturado);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				detalle.add(temp);
			}
			pedido.setDetalles(detalle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		pedidoRepositoy.save(pedido);
		pedidoDto.setId(pedido.getId());
		return pedidoDto;
	}
	
	public PedidoDTO updateEstado(PedidoDTO pedidoDto, int id, String estado) {
		Optional<Pedido> opt=pedidoRepositoy.findById(id);
		Pedido pedido=new Pedido();
		try {
			pedido=opt.get();
			
			if(estado.equals("terminado")) {
				List<PedidoDetalle> detalle=new ArrayList<PedidoDetalle>();
				for(PedidoDetalleDTO detalleDto: pedidoDto.getDetalles()) {
					PedidoDetalle temp=new PedidoDetalle();
					temp.setCantidad(detalleDto.getCantidad());
					
					try {
						if(detalleDto.getInsumo()!=null) {
							//Proceso de stock
							ArticuloInsumo insumo=insumoRepository.findById(detalleDto.getInsumo().getId()).get();
							insumo.setStockActual((insumo.getStockActual())-(detalleDto.getCantidad()));
							insumoRepository.save(insumo);
							temp.setInsumo(insumo);
						}
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					try {
						if(detalleDto.getManufacturado()!=null) {
							//Proceso de stock
							ArticuloManufacturado manufacturado=manufacturadoRepository.findById(detalleDto.getManufacturado().getId()).get();
							for(ArticuloManufacturadoDetalle manufDetalle : manufacturado.getDetalles()) {
								ArticuloInsumo ins=insumoRepository.findById(manufDetalle.getInsumo().getId()).get();
								ins.setStockActual((ins.getStockActual())-((detalleDto.getCantidad())*(manufDetalle.getCantidad())));
								insumoRepository.save(ins);
							}
							manufacturado.setId(detalleDto.getManufacturado().getId());
							temp.setManufacturado(manufacturado);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					detalle.add(temp);
				}
				pedido.setDetalles(detalle);
			}
			pedidoRepositoy.save(pedido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		pedidoDto.setId(pedido.getId());
		return pedidoDto;
		
	}
	
	public PedidoDTO update(PedidoDTO pedidoDto, int id) {
		Optional<Pedido> opt=pedidoRepositoy.findById(id);
		Pedido pedido=new Pedido();
		
		try {
			pedido=opt.get();
			pedido.setHoraEstimadaFin(pedidoDto.getHoraEstimadaFin());
			pedido.setFecha(pedidoDto.getFecha());
			pedido.setMontoDescuento(pedidoDto.getMontoDescuento());
			pedido.setNro(pedidoDto.getNro());
			pedido.setTipoEnvio(pedidoDto.getTipoEnvio());
			pedido.setEstado(pedidoDto.getEstado());
			pedido.setTotal(pedido.getTotal());
			
			try {
				Cliente cli=new Cliente();
				cli.setId(pedidoDto.getCliente().getId());
				pedido.setCliente(cli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			List<PedidoDetalle> detalle=new ArrayList<PedidoDetalle>();
			try {
				for(PedidoDetalleDTO detalleDto: pedidoDto.getDetalles()) {
					PedidoDetalle temp=new PedidoDetalle();
					temp.setCantidad(detalleDto.getCantidad());
					
					try {
						if(detalleDto.getInsumo()!=null) {
							ArticuloInsumo insumo=new ArticuloInsumo();
							insumo.setId(detalleDto.getInsumo().getId());
							temp.setInsumo(insumo);
						}
						
						if(detalleDto.getManufacturado()!=null) {
							ArticuloManufacturado manufacturado=new ArticuloManufacturado();
							manufacturado.setId(detalleDto.getManufacturado().getId());
							for(ArticuloManufacturadoDetalle manufDetalle : manufacturado.getDetalles()) {
								ArticuloInsumo ins=new ArticuloInsumo();
								ins.setId(manufDetalle.getInsumo().getId());
								manufDetalle.setInsumo(ins);
							}
							temp.setManufacturado(manufacturado);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					detalle.add(temp);
				}
				pedido.setDetalles(detalle);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			pedidoRepositoy.save(pedido);
			pedidoDto.setId(pedido.getId());
		} catch (Exception e) {
			System.out.println("Bad Request");
			pedidoDto.setId(0);
		}
		return pedidoDto;
	}
	
	public boolean delete(int id) {
		try {
			pedidoRepositoy.deleteById(id);
			return true;
		}catch (Exception e) {
			
			return false;
			
		}
	}
}
