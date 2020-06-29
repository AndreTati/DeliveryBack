package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DomicilioDTO;
import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.dto.LocalidadDTO;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Domicilio;
import com.example.demo.entities.Empleado;
import com.example.demo.entities.Localidad;
import com.example.demo.repositories.DomicilioRepository;

@Service
public class DomicilioService {
	private DomicilioRepository repository;

	public DomicilioService(DomicilioRepository repository) {
		this.repository = repository;
	}

	public List<DomicilioDTO> getAll() {
		List<DomicilioDTO> result = new ArrayList<>();

		for (Domicilio ins : repository.findAll()) {

			DomicilioDTO dom = new DomicilioDTO();
			dom.setId(ins.getId());
			dom.setCalle(ins.getCalle());
			dom.setNro(ins.getNro());
			dom.setPiso(ins.getPiso());
			dom.setDpto(ins.getDpto());
			dom.setCP(ins.getCP());
			dom.setLatitud(ins.getLatitud());
			dom.setLongitud(ins.getLongitud());

			try {
				LocalidadDTO localidad = new LocalidadDTO();
				localidad.setId(ins.getLocalidad().getId());

				dom.setLocalidad(localidad);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				EmpleadoDTO empleado = new EmpleadoDTO();
				empleado.setId(ins.getEmpleado().getId());

				dom.setEmpleado(empleado);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				ClienteDTO cliente = new ClienteDTO();
				cliente.setId(ins.getCliente().getId());
				dom.setCliente(cliente);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			result.add(dom);

		}
		return result;
	}

	public DomicilioDTO getOne(int id) {

		Optional<Domicilio> optional = repository.findById(id);
		DomicilioDTO dom = new DomicilioDTO();
		try {

			Domicilio ins = optional.get();
			dom.setId(ins.getId());
			dom.setCalle(ins.getCalle());
			dom.setNro(ins.getNro());
			dom.setPiso(ins.getPiso());
			dom.setDpto(ins.getDpto());
			dom.setCP(ins.getCP());
			dom.setLatitud(ins.getLatitud());
			dom.setLongitud(ins.getLongitud());

			try {
				LocalidadDTO localidad = new LocalidadDTO();
				localidad.setId(ins.getLocalidad().getId());

				dom.setLocalidad(localidad);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				EmpleadoDTO empleado = new EmpleadoDTO();
				empleado.setId(ins.getEmpleado().getId());

				dom.setEmpleado(empleado);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				ClienteDTO cliente = new ClienteDTO();
				cliente.setId(ins.getCliente().getId());
				dom.setCliente(cliente);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			System.out.println("No existe el id");
		}

		return dom;
	}

	public DomicilioDTO save(DomicilioDTO domicilioDTO) {

		Domicilio dom = new Domicilio();
		dom.setCalle(domicilioDTO.getCalle());
		dom.setNro(domicilioDTO.getNro());
		dom.setPiso(domicilioDTO.getPiso());
		dom.setDpto(domicilioDTO.getDpto());
		dom.setCP(domicilioDTO.getCP());
		dom.setLatitud(domicilioDTO.getLatitud());
		dom.setLongitud(domicilioDTO.getLongitud());

		try {
			Localidad localidad = new Localidad();
			localidad.setId(domicilioDTO.getLocalidad().getId());

			dom.setLocalidad(localidad);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Empleado empleado = new Empleado();
			empleado.setId(domicilioDTO.getEmpleado().getId());

			dom.setEmpleado(empleado);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Cliente cliente = new Cliente();
			cliente.setId(domicilioDTO.getCliente().getId());
			dom.setCliente(cliente);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		repository.save(dom);
		domicilioDTO.setId(dom.getId());

		return domicilioDTO;
	}

	public DomicilioDTO update(DomicilioDTO domicilioDTO, int id) {

		Optional<Domicilio> optional = repository.findById(id);
		Domicilio dom = new Domicilio();

		try {

			dom = optional.get();
			dom.setCalle(domicilioDTO.getCalle());
			dom.setNro(domicilioDTO.getNro());
			dom.setPiso(domicilioDTO.getPiso());
			dom.setDpto(domicilioDTO.getDpto());
			dom.setCP(domicilioDTO.getCP());
			dom.setLatitud(domicilioDTO.getLatitud());
			dom.setLongitud(domicilioDTO.getLongitud());
			try {
				Localidad localidad = new Localidad();
				localidad.setId(domicilioDTO.getLocalidad().getId());

				dom.setLocalidad(localidad);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				Empleado empleado = new Empleado();
				empleado.setId(domicilioDTO.getEmpleado().getId());

				dom.setEmpleado(empleado);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			try {
				Cliente cliente = new Cliente();
				cliente.setId(domicilioDTO.getCliente().getId());
				dom.setCliente(cliente);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			repository.save(dom);
			domicilioDTO.setId(dom.getId());

		} catch (Exception e) {
			System.out.println("Bad Request");
			domicilioDTO.setId(0);
		}

		return domicilioDTO;
	}

	public boolean delete(int id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
