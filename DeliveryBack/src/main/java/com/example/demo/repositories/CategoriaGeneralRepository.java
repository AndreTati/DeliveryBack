package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.CategoriaGeneral;

public interface CategoriaGeneralRepository extends JpaRepository<CategoriaGeneral, Integer> {
	@Modifying
	@Transactional
	@Query( "UPDATE CategoriaGeneral SET eliminado_categoriaGeneral = true WHERE id= ?1" )
	public int deleteCategoriaGeneralById (int id);
}
