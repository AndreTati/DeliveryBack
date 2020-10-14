package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ArticuloInsumoDTO;
import com.example.demo.dto.ArticuloManufacturadoDTO;
import com.example.demo.dto.ArticuloManufacturadoDetalleDTO;
import com.example.demo.dto.CarritoDTO;
import com.example.demo.dto.CarritoDetalleDTO;
import com.example.demo.dto.CategoriaInsumoDTO;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DomicilioDTO;
import com.example.demo.dto.LocalidadDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.dto.PedidoDetalleDTO;
import com.example.demo.dto.ProvinciaDTO;
import com.example.demo.dto.UnidadDeMedidaDTO;
import com.example.demo.entities.ArticuloInsumo;
import com.example.demo.entities.ArticuloManufacturado;
import com.example.demo.entities.ArticuloManufacturadoDetalle;
import com.example.demo.entities.Carrito;
import com.example.demo.entities.CarritoDetalle;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Domicilio;
import com.example.demo.repositories.ArticuloInsumoRepository;
import com.example.demo.repositories.ArticuloManufacturadoRepository;
import com.example.demo.repositories.CarritoRepository;

@Service
public class CarritoService {
	private CarritoRepository carritoRepository;
	public CarritoService(CarritoRepository carritoRepository) {
		this.carritoRepository = carritoRepository;
	}
	
	public List<CarritoDTO> getAll(){
		List<CarritoDTO> result=new ArrayList<>();
		
		for(Carrito carrito : carritoRepository.findAll()) {
			CarritoDTO carDto=new CarritoDTO();
			carDto.setId(carrito.getId());
			carDto.setFecha(carrito.getFecha());
			carDto.setMontoDescuento(carrito.getMontoDescuento());
			carDto.setTipoEnvio(carrito.getTipoEnvio());
			carDto.setTotal(carrito.getTotal());
			
			try {
				ClienteDTO cli=new ClienteDTO();
				cli.setId(carrito.getCliente().getId());
				cli.setNombre(carrito.getCliente().getNombre());
				cli.setApellido(carrito.getCliente().getApellido());
				cli.setDni(carrito.getCliente().getDni());
				cli.setEmail(carrito.getCliente().getEmail());
				carDto.setCliente(cli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				DomicilioDTO domCli=new DomicilioDTO();
				domCli.setId(carrito.getDomicilioCliente().getId());
				domCli.setCalle(carrito.getDomicilioCliente().getCalle());
				domCli.setNro(carrito.getDomicilioCliente().getNro());
				domCli.setDpto(carrito.getDomicilioCliente().getDpto());
				domCli.setPiso(carrito.getDomicilioCliente().getPiso());
				
				try {
					LocalidadDTO loc=new LocalidadDTO();
					loc.setId(carrito.getDomicilioCliente().getLocalidad().getId());
					loc.setNombre(carrito.getDomicilioCliente().getLocalidad().getNombre());
					
					try {
						ProvinciaDTO prov=new ProvinciaDTO();
						prov.setId(carrito.getDomicilioCliente().getLocalidad().getProvincia().getId());
						prov.setNombre(carrito.getDomicilioCliente().getLocalidad().getProvincia().getNombre());
						
						try {
							PaisDTO pais=new PaisDTO();
							pais.setId(carrito.getDomicilioCliente().getLocalidad().getProvincia().getPais().getId());
							pais.setNombre(carrito.getDomicilioCliente().getLocalidad().getProvincia().getPais().getNombre());
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
				carDto.setDomicilioCliente(domCli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<CarritoDetalleDTO> detDto=new ArrayList<>();
				for(CarritoDetalle detalle:carrito.getDetallesCarrito()) {
					CarritoDetalleDTO detalleDto=new CarritoDetalleDTO();
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
				carDto.setDetallesCarrito(detDto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			result.add(carDto);
		}
		return result;
	}
	
	public CarritoDTO getOne(int id) {
		Optional<Carrito> opt=carritoRepository.findById(id);
		CarritoDTO carDto=new CarritoDTO();
		
		try {
			Carrito carrito=opt.get();
			carDto.setId(carrito.getId());
			carDto.setFecha(carrito.getFecha());
			carDto.setMontoDescuento(carrito.getMontoDescuento());
			carDto.setTipoEnvio(carrito.getTipoEnvio());
			carDto.setTotal(carrito.getTotal());
			
			try {
				ClienteDTO cli=new ClienteDTO();
				cli.setId(carrito.getCliente().getId());
				cli.setNombre(carrito.getCliente().getNombre());
				cli.setApellido(carrito.getCliente().getApellido());
				cli.setDni(carrito.getCliente().getDni());
				cli.setEmail(carrito.getCliente().getEmail());
				carDto.setCliente(cli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				DomicilioDTO domCli=new DomicilioDTO();
				domCli.setId(carrito.getDomicilioCliente().getId());
				domCli.setCalle(carrito.getDomicilioCliente().getCalle());
				domCli.setNro(carrito.getDomicilioCliente().getNro());
				domCli.setDpto(carrito.getDomicilioCliente().getDpto());
				domCli.setPiso(carrito.getDomicilioCliente().getPiso());
				
				try {
					LocalidadDTO loc=new LocalidadDTO();
					loc.setId(carrito.getDomicilioCliente().getLocalidad().getId());
					loc.setNombre(carrito.getDomicilioCliente().getLocalidad().getNombre());
					
					try {
						ProvinciaDTO prov=new ProvinciaDTO();
						prov.setId(carrito.getDomicilioCliente().getLocalidad().getProvincia().getId());
						prov.setNombre(carrito.getDomicilioCliente().getLocalidad().getProvincia().getNombre());
						
						try {
							PaisDTO pais=new PaisDTO();
							pais.setId(carrito.getDomicilioCliente().getLocalidad().getProvincia().getPais().getId());
							pais.setNombre(carrito.getDomicilioCliente().getLocalidad().getProvincia().getPais().getNombre());
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
				carDto.setDomicilioCliente(domCli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<CarritoDetalleDTO> detDto=new ArrayList<>();
				for(CarritoDetalle detalle:carrito.getDetallesCarrito()) {
					CarritoDetalleDTO detalleDto=new CarritoDetalleDTO();
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
						try {
							UnidadDeMedidaDTO uniMed=new UnidadDeMedidaDTO();
							uniMed.setId(detalle.getInsumo().getUnidadMed().getId());
							uniMed.setNombre(detalle.getInsumo().getUnidadMed().getNombre());
							uniMed.setAbreviatura(detalle.getInsumo().getUnidadMed().getAbreviatura());
							insumo.setUnidadDeMed(uniMed);
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						detalleDto.setInsumo(insumo);
					}
					
					if(detalle.getManufacturado()!=null) {
						ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
						manufacturado.setId(detalle.getManufacturado().getId());
						manufacturado.setNombre(detalle.getManufacturado().getNombre());
						manufacturado.setPrecio(detalle.getManufacturado().getPrecio());
						manufacturado.setTiempoPreparacion(detalle.getManufacturado().getTiempoPreparacion());
						
						try {
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
						} catch (Exception e) {
							
						}
						
						detalleDto.setManufacturado(manufacturado);
					}
					detDto.add(detalleDto);
				}
				carDto.setDetallesCarrito(detDto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return carDto;
	}
	
	public CarritoDTO getOneByCliente(int idCliente) {
		Optional<Carrito> opt=carritoRepository.getOneByCliente(idCliente);
		
		CarritoDTO carDto=new CarritoDTO();
		
		try {
			Carrito carrito=opt.get();
			carDto.setId(carrito.getId());
			carDto.setFecha(carrito.getFecha());
			carDto.setMontoDescuento(carrito.getMontoDescuento());
			carDto.setTipoEnvio(carrito.getTipoEnvio());
			carDto.setTotal(carrito.getTotal());
			
			try {
				ClienteDTO cli=new ClienteDTO();
				cli.setId(carrito.getCliente().getId());
				cli.setNombre(carrito.getCliente().getNombre());
				cli.setApellido(carrito.getCliente().getApellido());
				cli.setDni(carrito.getCliente().getDni());
				cli.setEmail(carrito.getCliente().getEmail());
				carDto.setCliente(cli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				DomicilioDTO domCli=new DomicilioDTO();
				domCli.setId(carrito.getDomicilioCliente().getId());
				domCli.setCalle(carrito.getDomicilioCliente().getCalle());
				domCli.setNro(carrito.getDomicilioCliente().getNro());
				domCli.setDpto(carrito.getDomicilioCliente().getDpto());
				domCli.setPiso(carrito.getDomicilioCliente().getPiso());
				
				try {
					LocalidadDTO loc=new LocalidadDTO();
					loc.setId(carrito.getDomicilioCliente().getLocalidad().getId());
					loc.setNombre(carrito.getDomicilioCliente().getLocalidad().getNombre());
					
					try {
						ProvinciaDTO prov=new ProvinciaDTO();
						prov.setId(carrito.getDomicilioCliente().getLocalidad().getProvincia().getId());
						prov.setNombre(carrito.getDomicilioCliente().getLocalidad().getProvincia().getNombre());
						
						try {
							PaisDTO pais=new PaisDTO();
							pais.setId(carrito.getDomicilioCliente().getLocalidad().getProvincia().getPais().getId());
							pais.setNombre(carrito.getDomicilioCliente().getLocalidad().getProvincia().getPais().getNombre());
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
				carDto.setDomicilioCliente(domCli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<CarritoDetalleDTO> detDto=new ArrayList<>();
				for(CarritoDetalle detalle:carrito.getDetallesCarrito()) {
					CarritoDetalleDTO detalleDto=new CarritoDetalleDTO();
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
							insumo.setUnidadDeMed(uniMed);
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						detalleDto.setInsumo(insumo);
					}
					
					if(detalle.getManufacturado()!=null) {
						ArticuloManufacturadoDTO manufacturado=new ArticuloManufacturadoDTO();
						manufacturado.setId(detalle.getManufacturado().getId());
						manufacturado.setNombre(detalle.getManufacturado().getNombre());
						manufacturado.setPrecio(detalle.getManufacturado().getPrecio());
						manufacturado.setTiempoPreparacion(detalle.getManufacturado().getTiempoPreparacion());
						
						try {
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
						} catch (Exception e) {
							
						}
						
						detalleDto.setManufacturado(manufacturado);
					}
					detDto.add(detalleDto);
				}
				carDto.setDetallesCarrito(detDto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return carDto;
	}
	
	public CarritoDTO save(CarritoDTO carritoDto) {
		Carrito carrito=new Carrito();
		
		carrito.setFecha(carritoDto.getFecha());
		carrito.setMontoDescuento(carritoDto.getMontoDescuento());
		carrito.setTipoEnvio(carritoDto.getTipoEnvio());
		carrito.setTotal(carritoDto.getTotal());
		
		try {
			Cliente cli=new Cliente();
			cli.setId(carritoDto.getCliente().getId());
			carrito.setCliente(cli);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Domicilio dom=new Domicilio();
			dom.setId(carritoDto.getDomicilioCliente().getId());
			carrito.setDomicilioCliente(dom);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<CarritoDetalle> detalle=new ArrayList<CarritoDetalle>();
			for(CarritoDetalleDTO detalleDto:carritoDto.getDetallesCarrito()) {
				CarritoDetalle temp=new CarritoDetalle();
				temp.setCantidad(detalleDto.getCantidad());
				temp.setSubtotal(detalleDto.getSubtotal());
				temp.setCarrito(carrito);
				
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
			carrito.setDetallesCarrito(detalle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		carritoRepository.save(carrito);
		carritoDto.setId(carrito.getId());
		return carritoDto;
	}
	
	public CarritoDTO update(CarritoDTO carritoDto, int id) {
		Optional<Carrito> opt=carritoRepository.findById(id);
		Carrito carrito=new Carrito();
		
		try {
			carrito=opt.get();
			carrito.setFecha(carritoDto.getFecha());
			carrito.setMontoDescuento(carritoDto.getMontoDescuento());
			carrito.setTipoEnvio(carritoDto.getTipoEnvio());
			carrito.setTotal(carritoDto.getTotal());
			
			try {
				Cliente cli=new Cliente();
				cli.setId(carritoDto.getCliente().getId());
				carrito.setCliente(cli);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				Domicilio dom=new Domicilio();
				dom.setId(carritoDto.getDomicilioCliente().getId());
				carrito.setDomicilioCliente(dom);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List<CarritoDetalle> detalle=new ArrayList<CarritoDetalle>();
				for(CarritoDetalleDTO detalleDto:carritoDto.getDetallesCarrito()) {
					CarritoDetalle temp=new CarritoDetalle();
					if(detalleDto.getId()!=0) {
						temp.setId(detalleDto.getId());
					}
					temp.setCantidad(detalleDto.getCantidad());
					temp.setSubtotal(detalleDto.getSubtotal());
					temp.setCarrito(carrito);
					
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
				carrito.setDetallesCarrito(detalle);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			carritoRepository.save(carrito);
			carritoDto.setId(carrito.getId());
			

		} catch (Exception e) {
			System.out.println("Bad Request");
			carritoDto.setId(0);
		}
		return carritoDto;
	}
	
	public boolean delete(int id) {
		try {
			carritoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
