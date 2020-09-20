package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.CategoriaInsumo;

@Repository
public interface CategoriaInsumoRepository extends JpaRepository<CategoriaInsumo, Integer>{

	
	@Modifying
	@Transactional
	@Query("UPDATE CategoriaInsumo SET eliminado_categoriaInsumo=true WHERE id=?1")
	public int deleteById(int id);
}
