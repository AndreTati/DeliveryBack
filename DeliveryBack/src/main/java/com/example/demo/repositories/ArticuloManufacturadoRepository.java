package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.ArticuloManufacturado;

@Repository
public interface ArticuloManufacturadoRepository extends JpaRepository<ArticuloManufacturado, Integer>{

	@Modifying
	@Transactional
	@Query("UPDATE ArticuloManufacturado SET eliminado_articuloManufacturado=true WHERE id=?1")
	public int deleteById(int id);
}
