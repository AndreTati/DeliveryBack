package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ConfiguracionDTO;
import com.example.demo.dto.FacturaDTO;
import com.example.demo.entities.Configuracion;
import com.example.demo.repositories.ConfiguracionRepository;

@Service
public class ConfiguracionService {

	private ConfiguracionRepository configuracionRepository;
	@Autowired
	private JavaMailSender javaMailSender;

	public ConfiguracionService(ConfiguracionRepository configuracionRepository) {
		this.configuracionRepository = configuracionRepository;
	}
	
	public void sendMail(FacturaDTO factura) {
		try {
			String message="Ya se encuentra disponible su factura por el pedido realizado número: "+factura.getPedido().getId()+"\nEl total es de: $"+factura.getTotal()+"\nEl detalle podrá descargarlo de su perfil de EL BUEN SABOR DELIVERY \n\nMuchas Gracias por su compra!!!";
			SimpleMailMessage mailMessage= new SimpleMailMessage();
			mailMessage.setFrom("delivery2020.elbuensabor@gmail.com");
			mailMessage.setTo(factura.getCliente().getEmail());
			mailMessage.setSubject("Aviso de factura disponible");
			mailMessage.setText(message);
			
			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			
		}
	}
	
	public ConfiguracionDTO getConfiguracion() {
		List<Configuracion> config=configuracionRepository.findAll();
		
		ConfiguracionDTO configDto=new ConfiguracionDTO();
		try {
			for(Configuracion c:config) {
				configDto.setId(c.getId());
				configDto.setHorarioApertura(c.getHorarioApertura());
				configDto.setHorarioCierre(c.getHorarioCierre());
				configDto.setCantidadCocineros(c.getCantidadCocineros());
				configDto.setCuit(c.getCuit());
				configDto.setNombreEmpresa(c.getNombreEmpresa());
				configDto.setNumeroFiscal(c.getNumeroFiscal());
				configDto.setEmailEmpresa(c.getEmailEmpresa());
				configDto.setSociedad(c.getSociedad());
				configDto.setPaginaWeb(c.getPaginaWeb());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return configDto;
	}
	
	public ConfiguracionDTO save(ConfiguracionDTO configuracionDto) {
		Configuracion config=new Configuracion();
		try {
			config.setHorarioApertura(configuracionDto.getHorarioApertura());
			config.setHorarioCierre(configuracionDto.getHorarioCierre());
			config.setNombreEmpresa(configuracionDto.getNombreEmpresa());
			config.setCantidadCocineros(configuracionDto.getCantidadCocineros());
			config.setEmailEmpresa(configuracionDto.getEmailEmpresa());
			config.setCuit(configuracionDto.getCuit());
			config.setNumeroFiscal(configuracionDto.getNumeroFiscal());
			config.setSociedad(configuracionDto.getSociedad());
			config.setPaginaWeb(configuracionDto.getPaginaWeb());
			
			configuracionRepository.save(config);
			configuracionDto.setId(config.getId());
		}catch (Exception e) {
			System.out.println(e.getMessage());
			configuracionDto.setId(0);
		}
		return configuracionDto;
	}
	
	public ConfiguracionDTO update(ConfiguracionDTO configuracionDto, int id) {
		Optional<Configuracion> opt=configuracionRepository.findById(id);
		
		try {
			Configuracion config=opt.get();
			config.setHorarioApertura(configuracionDto.getHorarioApertura());
			config.setHorarioCierre(configuracionDto.getHorarioCierre());
			config.setNombreEmpresa(configuracionDto.getNombreEmpresa());
			config.setCantidadCocineros(configuracionDto.getCantidadCocineros());
			config.setEmailEmpresa(configuracionDto.getEmailEmpresa());
			config.setCuit(configuracionDto.getCuit());
			config.setNumeroFiscal(configuracionDto.getNumeroFiscal());
			config.setSociedad(configuracionDto.getSociedad());
			config.setPaginaWeb(configuracionDto.getPaginaWeb());
			
			configuracionRepository.save(config);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return configuracionDto;
	}
	
	public boolean delete(int id) {
		try {
			configuracionRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
