package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
	@Modifying
	@Transactional
	@Query( "UPDATE Provincia SET eliminado_provincia = true WHERE id= ?1" )
	public int deleteLogico (int id);
}
