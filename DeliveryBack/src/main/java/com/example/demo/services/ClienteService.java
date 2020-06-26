package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.ImagenDTO;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Imagen;
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
			Cliente cli=new Cliente();
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
	
	public ClienteDTO save(ClienteDTO clienteDto) {
		Cliente cli=new Cliente();
		cli.setDni(clienteDto.getDni());
		cli.setNombre(clienteDto.getNombre());
		cli.setApellido(clienteDto.getApellido());
		cli.setEmail(clienteDto.getEmail());
		cli.setPass(clienteDto.getPass());
		cli.setFechaNac(clienteDto.getFechaNac());
		cli.setTelefono(clienteDto.getTelefono());
		cli.setFechaAlta(clienteDto.getFechaAlta());
		
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
	
	/*public boolean delete(int id) {
		try {
			
			clienteRepository.deleteById(id);	
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}	
	}*/
}
