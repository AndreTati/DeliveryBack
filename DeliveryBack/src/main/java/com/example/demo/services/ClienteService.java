package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DomicilioDTO;
import com.example.demo.dto.ImagenDTO;
import com.example.demo.dto.LocalidadDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.dto.ProvinciaDTO;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Domicilio;
import com.example.demo.entities.Imagen;
import com.example.demo.entities.Localidad;
import com.example.demo.entities.Pais;
import com.example.demo.entities.Provincia;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public List<ClienteDTO> getAll(){
		List<ClienteDTO> result=new ArrayList<ClienteDTO>();
		
		for(Cliente cli: clienteRepository.findAll()) {
			ClienteDTO cliDto=new ClienteDTO();
			cliDto.setId(cli.getId());
			cliDto.setDni(cli.getDni());
			cliDto.setNombre(cli.getNombre());
			cliDto.setApellido(cli.getApellido());
			cliDto.setFechaNac(cli.getFechaNac());
			cliDto.setFechaAlta(cli.getFechaAlta());
			cliDto.setEmail(cli.getEmail());
			cliDto.setTelefono(cli.getTelefono());
			cliDto.setPass(cli.getPass());
			
			try {
				List<DomicilioDTO> domicilios=new ArrayList<DomicilioDTO>();
				for(Domicilio dom:cli.getDomicilios()) {
					DomicilioDTO domDto=new DomicilioDTO();
					domDto.setId(dom.getId());
					domDto.setCalle(dom.getCalle());
					domDto.setNro(dom.getNro());
					domDto.setPiso(dom.getPiso());
					domDto.setDpto(dom.getDpto());
					domDto.setCP(dom.getCP());
					domDto.setLatitud(dom.getLatitud());
					domDto.setLongitud(dom.getLongitud());
					
					try {
						LocalidadDTO localidad=new LocalidadDTO();
						localidad.setId(dom.getLocalidad().getId());
						localidad.setNombre(dom.getLocalidad().getNombre());
						
						try {
							ProvinciaDTO provincia=new ProvinciaDTO();
							provincia.setId(dom.getLocalidad().getProvincia().getId());
							provincia.setNombre(dom.getLocalidad().getProvincia().getNombre());
							
							try {
								PaisDTO pais=new PaisDTO();
								pais.setId(dom.getLocalidad().getProvincia().getPais().getId());
								pais.setNombre(dom.getLocalidad().getProvincia().getPais().getNombre());
								provincia.setPais(pais);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							localidad.setProvincia(provincia);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						domDto.setLocalidad(localidad);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					domicilios.add(domDto);
				}
				cliDto.setDomicilios(domicilios);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(cli.getImg().getId());
				img.setUrl(cli.getImg().getUrl());
				cliDto.setImg(img);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			result.add(cliDto);
		}
		return result;
	}
	
	public ClienteDTO getOne(int id) {
		Optional<Cliente> opt=clienteRepository.findById(id);
		ClienteDTO cliDto=new ClienteDTO();
		
		try {
			
			Cliente cli=opt.get();
			cliDto.setId(cli.getId());
			cliDto.setDni(cli.getDni());
			cliDto.setNombre(cli.getNombre());
			cliDto.setApellido(cli.getApellido());
			cliDto.setFechaNac(cli.getFechaNac());
			cliDto.setFechaAlta(cli.getFechaAlta());
			cliDto.setEmail(cli.getEmail());
			cliDto.setTelefono(cli.getTelefono());
			cliDto.setPass(cli.getPass());
			
			try {
				List<DomicilioDTO> domicilios=new ArrayList<DomicilioDTO>();
				for(Domicilio dom:cli.getDomicilios()) {
					DomicilioDTO domDto=new DomicilioDTO();
					domDto.setId(dom.getId());
					domDto.setCalle(dom.getCalle());
					domDto.setNro(dom.getNro());
					domDto.setPiso(dom.getPiso());
					domDto.setDpto(dom.getDpto());
					domDto.setCP(dom.getCP());
					domDto.setLatitud(dom.getLatitud());
					domDto.setLongitud(dom.getLongitud());
					
					try {
						LocalidadDTO localidad=new LocalidadDTO();
						localidad.setId(dom.getLocalidad().getId());
						localidad.setNombre(dom.getLocalidad().getNombre());
						
						try {
							ProvinciaDTO provincia=new ProvinciaDTO();
							provincia.setId(dom.getLocalidad().getProvincia().getId());
							provincia.setNombre(dom.getLocalidad().getProvincia().getNombre());
							
							try {
								PaisDTO pais=new PaisDTO();
								pais.setId(dom.getLocalidad().getProvincia().getPais().getId());
								pais.setNombre(dom.getLocalidad().getProvincia().getPais().getNombre());
								provincia.setPais(pais);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							localidad.setProvincia(provincia);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						domDto.setLocalidad(localidad);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					domicilios.add(domDto);
				}
				cliDto.setDomicilios(domicilios);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(cli.getImg().getId());
				img.setUrl(cli.getImg().getUrl());
				cliDto.setImg(img);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		return cliDto;
	}
	
	public ClienteDTO busquedaPorEmail(String email) {
		Optional<Cliente> opt=clienteRepository.buscarPorEmail(email);
		ClienteDTO cliDto=new ClienteDTO();
		
		try {
			Cliente cli=opt.get();
			cliDto.setId(cli.getId());
			cliDto.setDni(cli.getDni());
			cliDto.setNombre(cli.getNombre());
			cliDto.setApellido(cli.getApellido());
			cliDto.setFechaNac(cli.getFechaNac());
			cliDto.setFechaAlta(cli.getFechaAlta());
			cliDto.setEmail(cli.getEmail());
			cliDto.setTelefono(cli.getTelefono());
			cliDto.setPass(cli.getPass());
			
			try {
				List<DomicilioDTO> domicilios=new ArrayList<DomicilioDTO>();
				for(Domicilio dom:cli.getDomicilios()) {
					DomicilioDTO domDto=new DomicilioDTO();
					domDto.setId(dom.getId());
					domDto.setCalle(dom.getCalle());
					domDto.setNro(dom.getNro());
					domDto.setPiso(dom.getPiso());
					domDto.setDpto(dom.getDpto());
					domDto.setCP(dom.getCP());
					domDto.setLatitud(dom.getLatitud());
					domDto.setLongitud(dom.getLongitud());
					
					try {
						LocalidadDTO localidad=new LocalidadDTO();
						localidad.setId(dom.getLocalidad().getId());
						localidad.setNombre(dom.getLocalidad().getNombre());
						
						try {
							ProvinciaDTO provincia=new ProvinciaDTO();
							provincia.setId(dom.getLocalidad().getProvincia().getId());
							provincia.setNombre(dom.getLocalidad().getProvincia().getNombre());
							
							try {
								PaisDTO pais=new PaisDTO();
								pais.setId(dom.getLocalidad().getProvincia().getPais().getId());
								pais.setNombre(dom.getLocalidad().getProvincia().getPais().getNombre());
								provincia.setPais(pais);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							localidad.setProvincia(provincia);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						domDto.setLocalidad(localidad);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					domicilios.add(domDto);
				}
				cliDto.setDomicilios(domicilios);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(cli.getImg().getId());
				img.setUrl(cli.getImg().getUrl());
				cliDto.setImg(img);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("No existe el cliente");
		}
		return cliDto;
	}
	
	public ClienteDTO save(ClienteDTO clienteDto) {
		Cliente cli=new Cliente();
		cli.setDni(clienteDto.getDni());
		cli.setNombre(clienteDto.getNombre());
		cli.setApellido(clienteDto.getApellido());
		cli.setEmail(clienteDto.getEmail());
		cli.setPass(clienteDto.getPass());
		cli.setFechaNac(clienteDto.getFechaNac());
		cli.setTelefono(clienteDto.getTelefono());
		
		//Fecha alta
		Locale local=new Locale("es", "AR");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy", local);
		sdf.format(new Date());
		cli.setFechaAlta(sdf.format(new Date()));
		
		try {
			List<Domicilio> domicilios=new ArrayList<Domicilio>();
			
			for(DomicilioDTO domDto: clienteDto.getDomicilios()) {
				Domicilio d=new Domicilio();
				d.setCalle(domDto.getCalle());
				d.setNro(domDto.getNro());
				d.setDpto(domDto.getDpto());
				d.setPiso(domDto.getPiso());
				d.setLatitud(domDto.getLatitud());
				d.setLongitud(domDto.getLongitud());
				d.setCP(domDto.getCP());
				d.setCliente(cli);
				
				try {
					Localidad localidad=new Localidad();
					localidad.setId(domDto.getLocalidad().getId());
					localidad.setNombre(domDto.getLocalidad().getNombre());
					
					
					try {
						Provincia provincia=new Provincia();
						provincia.setId(domDto.getLocalidad().getProvincia().getId());
						provincia.setNombre(domDto.getLocalidad().getProvincia().getNombre());
						localidad.setProvincia(provincia);
						
						try {
							Pais pais=new Pais();
							pais.setId(domDto.getLocalidad().getProvincia().getPais().getId());
							pais.setNombre(domDto.getLocalidad().getProvincia().getPais().getNombre());
							provincia.setPais(pais);
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						localidad.setProvincia(provincia);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					d.setLocalidad(localidad);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				domicilios.add(d);
			}
			cli.setDomicilios(domicilios);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Imagen img=new Imagen();
			img.setId(clienteDto.getImg().getId());
			cli.setImg(img);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		clienteRepository.save(cli);
		clienteDto.setId(cli.getId());
		
		return clienteDto;
	}
	
	public ClienteDTO update(ClienteDTO clienteDto, int id) {
		Optional<Cliente> opt=clienteRepository.findById(id);
		
		Cliente cli=new Cliente();
		try {
			cli=opt.get();
			cli.setDni(clienteDto.getDni());
			cli.setNombre(clienteDto.getNombre());
			cli.setApellido(clienteDto.getApellido());
			cli.setEmail(clienteDto.getEmail());
			cli.setPass(clienteDto.getPass());
			cli.setFechaNac(clienteDto.getFechaNac());
			cli.setTelefono(clienteDto.getTelefono());
			cli.setFechaAlta(clienteDto.getFechaAlta());
			
			try {
				List<Domicilio> domicilios=new ArrayList<Domicilio>();
				
				for(DomicilioDTO domDto: clienteDto.getDomicilios()) {
					Domicilio d=new Domicilio();
					d.setCalle(domDto.getCalle());
					d.setNro(domDto.getNro());
					d.setDpto(domDto.getDpto());
					d.setPiso(domDto.getPiso());
					d.setLatitud(domDto.getLatitud());
					d.setLongitud(domDto.getLongitud());
					d.setCliente(cli);
					
					try {
						Localidad localidad=new Localidad();
						localidad.setId(domDto.getLocalidad().getId());
						localidad.setNombre(domDto.getLocalidad().getNombre());
						
						
						try {
							Provincia provincia=new Provincia();
							provincia.setId(domDto.getLocalidad().getProvincia().getId());
							provincia.setNombre(domDto.getLocalidad().getProvincia().getNombre());
							localidad.setProvincia(provincia);
							
							try {
								Pais pais=new Pais();
								pais.setId(domDto.getLocalidad().getProvincia().getPais().getId());
								pais.setNombre(domDto.getLocalidad().getProvincia().getPais().getNombre());
								provincia.setPais(pais);
								
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							localidad.setProvincia(provincia);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						d.setLocalidad(localidad);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					domicilios.add(d);
				}
				cli.setDomicilios(domicilios);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				Imagen img=new Imagen();
				img.setId(clienteDto.getImg().getId());
				cli.setImg(img);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			clienteRepository.save(cli);
			clienteDto.setId(cli.getId());
		}catch (Exception e) {
			System.out.println("Bad Request");
			clienteDto.setId(0);
		}
		return clienteDto;
	}
	
	public boolean delete(int id) {
		try {
			
			clienteRepository.deleteById(id);	
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}	
	}
}
