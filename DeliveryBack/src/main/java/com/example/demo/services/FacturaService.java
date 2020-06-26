package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.FacturaDTO;
import com.example.demo.dto.PedidoDetalleDTO;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Factura;
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
			cli.setId(facturaDto.getId());
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
				cli.setId(facturaDto.getId());
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
