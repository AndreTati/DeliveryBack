package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Localidad;

public interface LocalidadRepository  extends JpaRepository<Localidad, Integer>{
	@Modifying
	@Transactional
	@Query( "UPDATE Localidad SET eliminado_localidad= true WHERE id= ?1" )
	public int deleteLogico (int id);
}
