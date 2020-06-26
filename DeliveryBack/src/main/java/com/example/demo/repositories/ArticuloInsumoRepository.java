package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.ArticuloInsumo;


@Repository
public interface ArticuloInsumoRepository extends JpaRepository<ArticuloInsumo, Integer>{

	@Modifying
	@Transactional
	@Query("UPDATE ArticuloInsumo SET eliminado_articuloInsumo=true WHERE id=?1")
	public int deleteById(int id);
	
	@Query(value = "SELECT * FROM articuloinsumo WHERE esInsumo_articuloInsumo=?1", nativeQuery = true)
	public List<ArticuloInsumo> getAllNoInsumos(boolean esInsumo);
}
