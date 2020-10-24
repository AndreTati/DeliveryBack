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
import com.example.demo.dto.DomicilioDTO;
import com.example.demo.dto.FacturaDTO;
import com.example.demo.dto.PedidoDTO;
import com.example.demo.dto.PedidoDetalleDTO;
import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.entities.ArticuloManufacturadoDetalle;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Domicilio;
import com.example.demo.entities.Factura;
import com.example.demo.entities.Pedido;
import com.example.demo.entities.PedidoDetalle;
import com.example.demo.repositories.FacturaRepository;

@Service
public class FacturaService {

	private FacturaRepository facturaRepository;

	public FacturaService(FacturaRepository facturaRepository) {
		this.facturaRepository = facturaRepository;
	}
	
	public List<FacturaDTO> getAll(){
		List<FacturaDTO> result=new ArrayList<FacturaDTO>();
		
		for(Factura fac:facturaRepository.findAll()) {
			FacturaDTO factDto=new FacturaDTO();
			factDto.setId(fac.getId());
			factDto.setNro(fac.getNro());
			factDto.setFecha(fac.getFecha());
			factDto.setMontoDescuento(fac.getMontoDescuento());
			factDto.setTipoPago(fac.getTipoPago());
			factDto.setNroTarjeta(fac.getNroTarjeta());
			factDto.setEliminado(fac.isEliminado());
			try {
				List<PedidoDetalleDTO> detalle=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle det :fac.getDetalles()) {
					PedidoDetalleDTO detalleDto=new PedidoDetalleDTO();
					detalleDto.setId(det.getId());
					detalleDto.setCantidad(det.getCantidad());
					detalleDto.setSubtotal(det.getSubtotal());
					detalle.add(detalleDto);
				}
				factDto.setDetalles(detalle);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				ClienteDTO cliente=new ClienteDTO();
				cliente.setId(fac.getCliente().getId());
				cliente.setNombre(fac.getCliente().getNombre());
				cliente.setApellido(fac.getCliente().getApellido());
				cliente.setDni(fac.getCliente().getDni());
				cliente.setEmail(fac.getCliente().getEmail());
				cliente.setFechaNac(fac.getCliente().getFechaNac());
				cliente.setTelefono(fac.getCliente().getTelefono());
				factDto.setCliente(cliente);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			result.add(factDto);
		}
		return result;
	}
	
	public FacturaDTO getOne(int id) {
		Optional<Factura> opt=facturaRepository.findById(id);
		FacturaDTO factDto=new FacturaDTO();
		
		try {
			Factura fac=opt.get();
			factDto.setId(fac.getId());
			factDto.setNro(fac.getNro());
			factDto.setFecha(fac.getFecha());
			factDto.setMontoDescuento(fac.getMontoDescuento());
			factDto.setTotal(fac.getTotal());
			factDto.setTipoPago(fac.getTipoPago());
			factDto.setNroTarjeta(fac.getNroTarjeta());
			factDto.setEliminado(fac.isEliminado());
			
			try {
				List<PedidoDetalleDTO> detalle=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle det :fac.getDetalles()) {
					PedidoDetalleDTO detalleDto=new PedidoDetalleDTO();
					detalleDto.setId(det.getId());
					detalleDto.setCantidad(det.getCantidad());
					detalleDto.setSubtotal(det.getSubtotal());
					detalle.add(detalleDto);
				}
				factDto.setDetalles(detalle);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				ClienteDTO cliente=new ClienteDTO();
				cliente.setId(fac.getCliente().getId());
				cliente.setNombre(fac.getCliente().getNombre());
				cliente.setApellido(fac.getCliente().getApellido());
				cliente.setDni(fac.getCliente().getDni());
				cliente.setEmail(fac.getCliente().getEmail());
				cliente.setFechaNac(fac.getCliente().getFechaNac());
				cliente.setTelefono(fac.getCliente().getTelefono());
				factDto.setCliente(cliente);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}catch(Exception e) {
			System.out.println("No existe el id");
		}
		return factDto;
	}
	
	public FacturaDTO getOneByPedido(int idPedido) {
		Optional<Factura> opt=facturaRepository.getOneByIdPedido(idPedido);
		FacturaDTO factDto=new FacturaDTO();
		
		try {
			Factura fac=opt.get();
			factDto.setId(fac.getId());
			factDto.setNro(fac.getNro());
			factDto.setFecha(fac.getFecha());
			factDto.setMontoDescuento(fac.getMontoDescuento());
			factDto.setTotal(fac.getTotal());
			factDto.setTipoPago(fac.getTipoPago());
			factDto.setNroTarjeta(fac.getNroTarjeta());
			factDto.setEliminado(fac.isEliminado());
			
			try {
				PedidoDTO ped = new PedidoDTO();
				ped.setId(factDto.getPedido().getId());
				try {
					DomicilioDTO dom=new DomicilioDTO();
					dom.setId(fac.getPedido().getDomicilioCliente().getId());
					dom.setCalle(fac.getPedido().getDomicilioCliente().getCalle());
					dom.setNro(fac.getPedido().getDomicilioCliente().getNro());
					ped.setDomicilioCliente(dom);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				factDto.setPedido(ped);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<PedidoDetalleDTO> detDto=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle detalle: fac.getDetalles()) {
					PedidoDetalleDTO detalleDto=new PedidoDetalleDTO();
					detalleDto.setId(detalle.getId());
					detalleDto.setCantidad(detalle.getCantidad());
					detalleDto.setSubtotal(detalle.getSubtotal());
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
						try {
							UnidadDeMedidaDTO uniMed=new UnidadDeMedidaDTO();
							uniMed.setId(detalle.getInsumo().getUnidadMed().getId());
							uniMed.setNombre(detalle.getInsumo().getUnidadMed().getNombre());
							uniMed.setAbreviatura(detalle.getInsumo().getUnidadMed().getAbreviatura());
							uniMed.setEliminado(detalle.getInsumo().getUnidadMed().isEliminado());
							insumo.setUnidadDeMed(uniMed);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
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
							try {
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
								try {
									CategoriaInsumoDTO categoria=new CategoriaInsumoDTO();
									categoria.setId(det.getInsumo().getCategoria().getId());
									categoria.setDenominacion(det.getInsumo().getCategoria().getDenominacion());
									insumoDetalle.setCategoria(categoria);
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								try {
									UnidadDeMedidaDTO unidad=new UnidadDeMedidaDTO();
									unidad.setId(det.getInsumo().getUnidadMed().getId());
									unidad.setNombre(det.getInsumo().getUnidadMed().getNombre());
									unidad.setAbreviatura(det.getInsumo().getUnidadMed().getAbreviatura());
									insumoDetalle.setUnidadDeMed(unidad);
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								temp.setInsumo(insumoDetalle);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
							detallesManuf.add(temp);
						}
						manufacturado.setDetalles(detallesManuf);
						
						detalleDto.setManufacturado(manufacturado);
					}
					detDto.add(detalleDto);
				}
				factDto.setDetalles(detDto);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				ClienteDTO cliente=new ClienteDTO();
				cliente.setId(fac.getCliente().getId());
				cliente.setNombre(fac.getCliente().getNombre());
				cliente.setApellido(fac.getCliente().getApellido());
				cliente.setDni(fac.getCliente().getDni());
				cliente.setEmail(fac.getCliente().getEmail());
				cliente.setFechaNac(fac.getCliente().getFechaNac());
				cliente.setTelefono(fac.getCliente().getTelefono());
				factDto.setCliente(cliente);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}catch(Exception e) {
			System.out.println("No existe el id");
		}
		return factDto;
	}
	
	public FacturaDTO save(FacturaDTO facturaDto) {
		Factura factura=new Factura();
		
		factura.setTipoPago(facturaDto.getTipoPago());
		factura.setFecha(facturaDto.getFecha());
		factura.setMontoDescuento(facturaDto.getMontoDescuento());
		factura.setTotal(facturaDto.getTotal());
		factura.setNro(facturaDto.getNro());
		factura.setNroTarjeta(facturaDto.getNroTarjeta());
		
		try {
			List<PedidoDetalle> detalle=new ArrayList<PedidoDetalle>();
			for(PedidoDetalleDTO detalleDto : facturaDto.getDetalles()) {
				PedidoDetalle dt=new PedidoDetalle();
				dt.setId(detalleDto.getId());
				detalle.add(dt);
			}
			factura.setDetalles(detalle);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Cliente cli=new Cliente();
			cli.setId(facturaDto.getCliente().getId());
			factura.setCliente(cli);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		facturaRepository.save(factura);
		
		facturaDto.setId(factura.getId());
		return facturaDto;
	}
	
	public FacturaDTO update(FacturaDTO facturaDto, int id) {
		
		Optional<Factura> opt=facturaRepository.findById(id);
		Factura factura=new Factura();
		
		try {
			factura=opt.get();
			factura.setTipoPago(facturaDto.getTipoPago());
			factura.setFecha(facturaDto.getFecha());
			factura.setMontoDescuento(facturaDto.getMontoDescuento());
			factura.setNro(facturaDto.getNro());
			factura.setNroTarjeta(facturaDto.getNroTarjeta());
			try {
				List<PedidoDetalle> detalle=new ArrayList<PedidoDetalle>();
				for(PedidoDetalleDTO detalleDto : facturaDto.getDetalles()) {
					PedidoDetalle dt=new PedidoDetalle();
					dt.setId(detalleDto.getId());
					detalle.add(dt);
				}
				factura.setDetalles(detalle);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				Cliente cli=new Cliente();
				cli.setId(facturaDto.getCliente().getId());
				factura.setCliente(cli);
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			facturaRepository.save(factura);
			
			facturaDto.setId(factura.getId());
			
			} catch(Exception e) {
		
				System.out.println("Bad Request");
				facturaDto.setId(0);
		
			}
		
			return facturaDto;
		

	}
	
	public boolean delete(int id) {
		try {
			
			facturaRepository.deleteById(id);	
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		
	}
}
