package com.example.demo.services;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.example.demo.dto.LocalidadDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.dto.PedidoDTO;
import com.example.demo.dto.PedidoDetalleDTO;
import com.example.demo.dto.ProvinciaDTO;
import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.entities.ArticuloInsumo;
import com.example.demo.entities.ArticuloManufacturado;
import com.example.demo.entities.ArticuloManufacturadoDetalle;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Domicilio;
import com.example.demo.entities.Estado;
import com.example.demo.entities.Factura;
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
	private FacturaService facturaService;

	

	public PedidoService(PedidoRepository pedidoRepositoy, ArticuloInsumoRepository insumoRepository,
			ArticuloManufacturadoRepository manufacturadoRepository, FacturaService facturaService) {
		this.pedidoRepositoy = pedidoRepositoy;
		this.insumoRepository = insumoRepository;
		this.manufacturadoRepository = manufacturadoRepository;
		this.facturaService=facturaService;
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
			pedDto.setFormaPago(pedido.getFormaPago());
			
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
				DomicilioDTO domCli=new DomicilioDTO();
				domCli.setId(pedido.getDomicilioCliente().getId());
				domCli.setCalle(pedido.getDomicilioCliente().getCalle());
				domCli.setNro(pedido.getDomicilioCliente().getNro());
				domCli.setDpto(pedido.getDomicilioCliente().getDpto());
				domCli.setPiso(pedido.getDomicilioCliente().getPiso());
				
				try {
					LocalidadDTO loc=new LocalidadDTO();
					loc.setId(pedido.getDomicilioCliente().getLocalidad().getId());
					loc.setNombre(pedido.getDomicilioCliente().getLocalidad().getNombre());
					
					try {
						ProvinciaDTO prov=new ProvinciaDTO();
						prov.setId(pedido.getDomicilioCliente().getLocalidad().getProvincia().getId());
						prov.setNombre(pedido.getDomicilioCliente().getLocalidad().getProvincia().getNombre());
						
						try {
							PaisDTO pais=new PaisDTO();
							pais.setId(pedido.getDomicilioCliente().getLocalidad().getProvincia().getPais().getId());
							pais.setNombre(pedido.getDomicilioCliente().getLocalidad().getProvincia().getPais().getNombre());
							prov.setPais(pais);
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						loc.setProvincia(prov);
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					domCli.setLocalidad(loc);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				pedDto.setDomicilioCliente(domCli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<PedidoDetalleDTO> detDto=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle detalle: pedido.getDetalles()) {
					PedidoDetalleDTO detalleDto=new PedidoDetalleDTO();
					detalleDto.setId(detalle.getId());
					detalleDto.setCantidad(detalle.getCantidad());
					PedidoDTO pedidoDto = new PedidoDTO();
					pedidoDto.setId(detalle.getPedido().getId());
					detalleDto.setPedido(pedidoDto);
					detalleDto.setSubtotal(detalle.getSubtotal());
					if(detalle.getFactura()!=null) {
						FacturaDTO facDto=new FacturaDTO();
						facDto.setId(detalle.getFactura().getId());
						detalleDto.setFactura(facDto);
					}
					
					
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
			Pedido pedido=opt.get();
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
			pedDto.setFormaPago(pedido.getFormaPago());
			
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
				DomicilioDTO domCli=new DomicilioDTO();
				domCli.setId(pedido.getDomicilioCliente().getId());
				domCli.setCalle(pedido.getDomicilioCliente().getCalle());
				domCli.setNro(pedido.getDomicilioCliente().getNro());
				domCli.setDpto(pedido.getDomicilioCliente().getDpto());
				domCli.setPiso(pedido.getDomicilioCliente().getPiso());
				
				try {
					LocalidadDTO loc=new LocalidadDTO();
					loc.setId(pedido.getDomicilioCliente().getLocalidad().getId());
					loc.setNombre(pedido.getDomicilioCliente().getLocalidad().getNombre());
					
					try {
						ProvinciaDTO prov=new ProvinciaDTO();
						prov.setId(pedido.getDomicilioCliente().getLocalidad().getProvincia().getId());
						prov.setNombre(pedido.getDomicilioCliente().getLocalidad().getProvincia().getNombre());
						
						try {
							PaisDTO pais=new PaisDTO();
							pais.setId(pedido.getDomicilioCliente().getLocalidad().getProvincia().getPais().getId());
							pais.setNombre(pedido.getDomicilioCliente().getLocalidad().getProvincia().getPais().getNombre());
							prov.setPais(pais);
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						loc.setProvincia(prov);
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					domCli.setLocalidad(loc);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				pedDto.setDomicilioCliente(domCli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<PedidoDetalleDTO> detDto=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle detalle: pedido.getDetalles()) {
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
				pedDto.setDetalles(detDto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return pedDto;
		
	}
	
	public List<PedidoDTO> getAllByClientePendientes(int idCliente) {
		List<PedidoDTO> result=new ArrayList<>();
		
		for(Pedido pedido : pedidoRepositoy.getAllByClientePendientes(idCliente)) {
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
			pedDto.setFormaPago(pedido.getFormaPago());
			
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
				DomicilioDTO domCli=new DomicilioDTO();
				domCli.setId(pedido.getDomicilioCliente().getId());
				domCli.setCalle(pedido.getDomicilioCliente().getCalle());
				domCli.setNro(pedido.getDomicilioCliente().getNro());
				domCli.setDpto(pedido.getDomicilioCliente().getDpto());
				domCli.setPiso(pedido.getDomicilioCliente().getPiso());
				
				try {
					LocalidadDTO loc=new LocalidadDTO();
					loc.setId(pedido.getDomicilioCliente().getLocalidad().getId());
					loc.setNombre(pedido.getDomicilioCliente().getLocalidad().getNombre());
					
					try {
						ProvinciaDTO prov=new ProvinciaDTO();
						prov.setId(pedido.getDomicilioCliente().getLocalidad().getProvincia().getId());
						prov.setNombre(pedido.getDomicilioCliente().getLocalidad().getProvincia().getNombre());
						
						try {
							PaisDTO pais=new PaisDTO();
							pais.setId(pedido.getDomicilioCliente().getLocalidad().getProvincia().getPais().getId());
							pais.setNombre(pedido.getDomicilioCliente().getLocalidad().getProvincia().getPais().getNombre());
							prov.setPais(pais);
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						loc.setProvincia(prov);
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					domCli.setLocalidad(loc);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				pedDto.setDomicilioCliente(domCli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<PedidoDetalleDTO> detDto=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle detalle: pedido.getDetalles()) {
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
				pedDto.setDetalles(detDto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			result.add(pedDto);
		}
		return result;
	}
	
	public List<PedidoDTO> getAllByClienteHistorial(int idCliente) {
		List<PedidoDTO> result=new ArrayList<>();
		
		for(Pedido pedido : pedidoRepositoy.getAllByClienteHistorial(idCliente)) {
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
			pedDto.setFormaPago(pedido.getFormaPago());
			
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
				DomicilioDTO domCli=new DomicilioDTO();
				domCli.setId(pedido.getDomicilioCliente().getId());
				domCli.setCalle(pedido.getDomicilioCliente().getCalle());
				domCli.setNro(pedido.getDomicilioCliente().getNro());
				domCli.setDpto(pedido.getDomicilioCliente().getDpto());
				domCli.setPiso(pedido.getDomicilioCliente().getPiso());
				
				try {
					LocalidadDTO loc=new LocalidadDTO();
					loc.setId(pedido.getDomicilioCliente().getLocalidad().getId());
					loc.setNombre(pedido.getDomicilioCliente().getLocalidad().getNombre());
					
					try {
						ProvinciaDTO prov=new ProvinciaDTO();
						prov.setId(pedido.getDomicilioCliente().getLocalidad().getProvincia().getId());
						prov.setNombre(pedido.getDomicilioCliente().getLocalidad().getProvincia().getNombre());
						
						try {
							PaisDTO pais=new PaisDTO();
							pais.setId(pedido.getDomicilioCliente().getLocalidad().getProvincia().getPais().getId());
							pais.setNombre(pedido.getDomicilioCliente().getLocalidad().getProvincia().getPais().getNombre());
							prov.setPais(pais);
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						loc.setProvincia(prov);
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					domCli.setLocalidad(loc);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				pedDto.setDomicilioCliente(domCli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<PedidoDetalleDTO> detDto=new ArrayList<PedidoDetalleDTO>();
				for(PedidoDetalle detalle: pedido.getDetalles()) {
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
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
							
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
	
	public PedidoDTO save(PedidoDTO pedidoDto) {
		
		Pedido pedido =new Pedido();
		
		pedido.setFecha(pedidoDto.getFecha());
		pedido.setMontoDescuento(pedidoDto.getMontoDescuento());
		pedido.setNro(pedidoDto.getNro());
		pedido.setTipoEnvio(pedidoDto.getTipoEnvio());
		pedido.setTotal(pedidoDto.getTotal());
		pedido.setEstado("Pendiente");
		pedido.setFormaPago(pedidoDto.getFormaPago());

		
		
		try {
			Cliente cli=new Cliente();
			cli.setId(pedidoDto.getCliente().getId());
			pedido.setCliente(cli);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Domicilio dom=new Domicilio();
			dom.setId(pedidoDto.getDomicilioCliente().getId());
			pedido.setDomicilioCliente(dom);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			int tiempoPedido=0;
			List<PedidoDetalle> detalle=new ArrayList<PedidoDetalle>();
			for(PedidoDetalleDTO detalleDto: pedidoDto.getDetalles()) {
				PedidoDetalle temp=new PedidoDetalle();
				temp.setCantidad(detalleDto.getCantidad());
				temp.setPedido(pedido);
				temp.setSubtotal(detalleDto.getSubtotal());
				
				try {
					if(detalleDto.getInsumo()!=null) {
						ArticuloInsumo insumo=new ArticuloInsumo();
						insumo.setId(detalleDto.getInsumo().getId());
						temp.setInsumo(insumo);
					}
					
					if(detalleDto.getManufacturado()!=null) {
						ArticuloManufacturado manufacturado=new ArticuloManufacturado();
						manufacturado.setId(detalleDto.getManufacturado().getId());
						tiempoPedido+=detalleDto.getManufacturado().getTiempoPreparacion();
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
			try {
				String sDate1=pedido.getFecha();
				Date d1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sDate1);
				int tiempoEnCocina=0;
				List<PedidoDTO> pedidos=this.getAll();
				for(PedidoDTO pedDto:pedidos) {
					if(pedDto.getEstado().equals("En cocina")) {
						for(PedidoDetalleDTO detDto:pedDto.getDetalles()) {
							if(detDto.getManufacturado()!=null) {
								tiempoEnCocina+=detDto.getManufacturado().getTiempoPreparacion();
							}
						}
					}
				}
				Calendar calendar=Calendar.getInstance();
				calendar.setTime(d1);
				int horaEstimada=0;
				if(pedidoDto.getTipoEnvio().equals("Delivery")) {
					horaEstimada=tiempoPedido+tiempoEnCocina+10;
				}else {
					horaEstimada=tiempoPedido+tiempoEnCocina;
				}
				if(horaEstimada>60) {
					horaEstimada=horaEstimada*60;
					int hora=horaEstimada/3600;
					int minuto=(horaEstimada-(hora*3600))/60;
					int segundos=horaEstimada-(hora*3600+minuto*60);
					calendar.add(Calendar.MINUTE, (int)minuto);
					calendar.add(Calendar.SECOND, segundos);
					calendar.add(Calendar.HOUR, hora);
				}else {
					calendar.add(Calendar.MINUTE, horaEstimada);
				}
				
				Date fechaSalida=calendar.getTime();
				
				Format f=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String strD=f.format(fechaSalida);
				
				pedido.setHoraEstimadaFin(strD);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
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
			
			if(estado.equals("Terminado")) {
				pedido.setEstado(estado);
				FacturaDTO fac=new FacturaDTO();
				fac.setPedido(pedidoDto);
				fac.setFecha(pedidoDto.getFecha());
				fac.setMontoDescuento(pedidoDto.getMontoDescuento());
				fac.setTotal(pedido.getTotal());
				fac.setTipoPago(pedidoDto.getFormaPago());
				try {
					fac.setCliente(pedidoDto.getCliente());
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				try {
					fac=facturaService.save(fac);
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				List<PedidoDetalle> detalle=new ArrayList<PedidoDetalle>();
				for(PedidoDetalleDTO detalleDto: pedidoDto.getDetalles()) {
					PedidoDetalle temp=new PedidoDetalle();
					temp.setId(detalleDto.getId());
					temp.setCantidad(detalleDto.getCantidad());
					temp.setSubtotal(detalleDto.getSubtotal());
					Pedido pedido2=new Pedido();
					pedido2.setId(detalleDto.getPedido().getId());
					temp.setPedido(pedido2);
					try {
						Factura factura=new Factura();
						factura.setId(fac.getId());
						temp.setFactura(factura);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
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
				
				
			}else if(estado.equals("Demorado")) {
				pedido.setEstado(estado);
				String sDate1=pedido.getHoraEstimadaFin();
				Date d1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sDate1);
				
				Calendar calendar=Calendar.getInstance();
				calendar.setTime(d1);
				calendar.add(Calendar.MINUTE, 10);
				Date fechaSalida=calendar.getTime();
				
				Format f=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String strD=f.format(fechaSalida);
				
				pedido.setHoraEstimadaFin(strD);
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
			pedido.setTotal(pedidoDto.getTotal());
			pedido.setFormaPago(pedidoDto.getFormaPago());
			
			try {
				Cliente cli=new Cliente();
				cli.setId(pedidoDto.getCliente().getId());
				pedido.setCliente(cli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				Domicilio dom=new Domicilio();
				dom.setId(pedidoDto.getDomicilioCliente().getId());
				pedido.setDomicilioCliente(dom);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			List<PedidoDetalle> detalle=new ArrayList<PedidoDetalle>();
			try {
				for(PedidoDetalleDTO detalleDto: pedidoDto.getDetalles()) {
					PedidoDetalle temp=new PedidoDetalle();
					temp.setId(detalleDto.getId());
					temp.setCantidad(detalleDto.getCantidad());
					temp.setPedido(pedido);
					temp.setSubtotal(detalleDto.getSubtotal());
					Factura factura= new Factura();
					factura.setId(detalleDto.getFactura().getId());
					temp.setFactura(factura);
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
