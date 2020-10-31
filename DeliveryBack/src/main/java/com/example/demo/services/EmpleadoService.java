package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DomicilioDTO;
import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.dto.ImagenDTO;
import com.example.demo.dto.RolDTO;
import com.example.demo.entities.Domicilio;
import com.example.demo.entities.Empleado;
import com.example.demo.entities.Imagen;
import com.example.demo.entities.Rol;
import com.example.demo.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	private EmpleadoRepository empleadoRepository;

	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	public List<EmpleadoDTO> getAll(){
		List<EmpleadoDTO> result=new ArrayList<>();
		
		for(Empleado emp:empleadoRepository.findAll()) {
			EmpleadoDTO eDto=new EmpleadoDTO();
			eDto.setId(emp.getId());
			eDto.setNombre(emp.getNombre());
			eDto.setApellido(emp.getApellido());
			eDto.setDni(emp.getDni());
			eDto.setEmail(emp.getEmail());
			eDto.setFechaAlta(emp.getFechaAlta());
			eDto.setFechaNac(emp.getFechaNac());
			eDto.setPass(emp.getPass());
			eDto.setTelefono(emp.getTelefono());
			
			try {
				RolDTO rol=new RolDTO();
				rol.setId(emp.getRol().getId());
				rol.setNombre(emp.getRol().getNombre());
				eDto.setRol(rol);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				DomicilioDTO domicilio=new DomicilioDTO();
				domicilio.setId(emp.getDomicilio().getId());
				domicilio.setCalle(emp.getDomicilio().getCalle());
				domicilio.setNro(emp.getDomicilio().getNro());
				eDto.setDomicilio(domicilio);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(emp.getImg().getId());
				img.setUrl(emp.getImg().getUrl());
				eDto.setImg(img);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			result.add(eDto);
		}
		return result;
	}
	
	public EmpleadoDTO getOne(int id) {
		Optional<Empleado> opt=empleadoRepository.findById(id);
		EmpleadoDTO eDto=new EmpleadoDTO();
		
		try {
			Empleado emp=opt.get();
			eDto.setId(emp.getId());
			eDto.setNombre(emp.getNombre());
			eDto.setApellido(emp.getApellido());
			eDto.setDni(emp.getDni());
			eDto.setEmail(emp.getEmail());
			eDto.setFechaAlta(emp.getFechaAlta());
			eDto.setFechaNac(emp.getFechaNac());
			eDto.setPass(emp.getPass());
			eDto.setTelefono(emp.getTelefono());
			
			try {
				RolDTO rol=new RolDTO();
				rol.setId(emp.getRol().getId());
				rol.setNombre(emp.getRol().getNombre());
				eDto.setRol(rol);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				DomicilioDTO domicilio=new DomicilioDTO();
				domicilio.setId(emp.getDomicilio().getId());
				domicilio.setCalle(emp.getDomicilio().getCalle());
				domicilio.setNro(emp.getDomicilio().getNro());
				eDto.setDomicilio(domicilio);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(emp.getImg().getId());
				img.setUrl(emp.getImg().getUrl());
				eDto.setImg(img);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println("No se encuentra el id");
		}
		return eDto;
	}
	
	public EmpleadoDTO getOneByEmail(String email) {
		Optional<Empleado> opt=empleadoRepository.buscarPorEmail(email);
		EmpleadoDTO eDto=new EmpleadoDTO();
		
		try {
			Empleado emp=opt.get();
			eDto.setId(emp.getId());
			eDto.setNombre(emp.getNombre());
			eDto.setApellido(emp.getApellido());
			eDto.setDni(emp.getDni());
			eDto.setEmail(emp.getEmail());
			eDto.setFechaAlta(emp.getFechaAlta());
			eDto.setFechaNac(emp.getFechaNac());
			eDto.setPass(emp.getPass());
			
			try {
				RolDTO rol=new RolDTO();
				rol.setId(emp.getRol().getId());
				rol.setNombre(emp.getRol().getNombre());
				eDto.setRol(rol);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				DomicilioDTO domicilio=new DomicilioDTO();
				domicilio.setId(emp.getDomicilio().getId());
				domicilio.setCalle(emp.getDomicilio().getCalle());
				domicilio.setNro(emp.getDomicilio().getNro());
				eDto.setDomicilio(domicilio);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(emp.getImg().getId());
				img.setUrl(emp.getImg().getUrl());
				eDto.setImg(img);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println("No se encuentra el id");
		}
		return eDto;
	}
	
	public EmpleadoDTO loguin(String email, String pass) {
		Optional<Empleado> opt=empleadoRepository.loguin(email, pass);
		EmpleadoDTO eDto=new EmpleadoDTO();
		
		try {
			Empleado emp=opt.get();
			eDto.setId(emp.getId());
			eDto.setNombre(emp.getNombre());
			eDto.setApellido(emp.getApellido());
			eDto.setDni(emp.getDni());
			eDto.setEmail(emp.getEmail());
			eDto.setFechaAlta(emp.getFechaAlta());
			eDto.setFechaNac(emp.getFechaNac());
			eDto.setPass(emp.getPass());
			
			try {
				RolDTO rol=new RolDTO();
				rol.setId(emp.getRol().getId());
				rol.setNombre(emp.getRol().getNombre());
				eDto.setRol(rol);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				DomicilioDTO domicilio=new DomicilioDTO();
				domicilio.setId(emp.getDomicilio().getId());
				domicilio.setCalle(emp.getDomicilio().getCalle());
				domicilio.setNro(emp.getDomicilio().getNro());
				eDto.setDomicilio(domicilio);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				ImagenDTO img=new ImagenDTO();
				img.setId(emp.getImg().getId());
				img.setUrl(emp.getImg().getUrl());
				eDto.setImg(img);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println("Usuario no encontrado");
		}
		return eDto;
	}
	
	public EmpleadoDTO save(EmpleadoDTO eDto) {
		Empleado emp=new Empleado();
		
		emp.setNombre(eDto.getNombre());
		emp.setApellido(eDto.getApellido());
		emp.setDni(eDto.getDni());
		emp.setEmail(eDto.getEmail());
		emp.setPass(eDto.getPass());
		emp.setFechaNac(eDto.getFechaNac());
		emp.setFechaAlta(eDto.getFechaAlta());
		emp.setTelefono(eDto.getTelefono());
		
		//Fecha alta
		Locale local=new Locale("es", "AR");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy", local);
		sdf.format(new Date());
		emp.setFechaAlta(sdf.format(new Date()));
		
		try {
			Rol rol=new Rol();
			rol.setId(eDto.getRol().getId());
			rol.setNombre(eDto.getRol().getNombre());
			emp.setRol(rol);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Domicilio domicilio=new Domicilio();
			domicilio.setId(eDto.getDomicilio().getId());
			domicilio.setCalle(eDto.getDomicilio().getCalle());
			domicilio.setNro(eDto.getDomicilio().getNro());
			emp.setDomicilio(domicilio);
			domicilio.setEmpleado(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Imagen img=new Imagen();
			img.setId(eDto.getImg().getId());
			img.setUrl(eDto.getImg().getUrl());
			emp.setImg(img);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		empleadoRepository.save(emp);
		eDto.setId(emp.getId());
		return eDto;
	}
	
	public EmpleadoDTO update(EmpleadoDTO eDto, int id) {
		Optional<Empleado> opt=empleadoRepository.findById(id);
		Empleado emp=new Empleado();
		
		try {
			emp=opt.get();
			emp.setNombre(eDto.getNombre());
			emp.setApellido(eDto.getApellido());
			emp.setDni(eDto.getDni());
			emp.setEmail(eDto.getEmail());
			emp.setPass(eDto.getPass());
			emp.setFechaNac(eDto.getFechaNac());
			emp.setFechaAlta(eDto.getFechaAlta());
			emp.setTelefono(eDto.getTelefono());
			
			try {
				Rol rol=new Rol();
				rol.setId(eDto.getRol().getId());
				rol.setNombre(eDto.getRol().getNombre());
				emp.setRol(rol);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				Domicilio domicilio=new Domicilio();
				domicilio.setId(eDto.getDomicilio().getId());
				domicilio.setCalle(eDto.getDomicilio().getCalle());
				domicilio.setNro(eDto.getDomicilio().getNro());
				emp.setDomicilio(domicilio);
				domicilio.setEmpleado(emp);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				Imagen img=new Imagen();
				img.setId(eDto.getImg().getId());
				img.setUrl(eDto.getImg().getUrl());
				emp.setImg(img);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			empleadoRepository.save(emp);
			eDto.setId(emp.getId());
		} catch (Exception e) {
			System.out.println("Bad Request");
			eDto.setId(0);
		}
		return eDto;
	}
	
	public boolean delete(int id) {
		try {

			empleadoRepository.deleteById(id);
			return true;

		} catch (Exception e) {

			return false;

		}

		
	}
}
