package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer>{
	@Modifying
	@Transactional
	@Query( "UPDATE Pais SET eliminado_pais = true WHERE id= ?1" )
	public int deleteLogico (int id);
}
