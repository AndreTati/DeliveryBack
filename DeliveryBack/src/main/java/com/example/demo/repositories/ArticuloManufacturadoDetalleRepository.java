package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ArticuloManufacturadoDetalle;

@Repository
public interface ArticuloManufacturadoDetalleRepository extends JpaRepository<ArticuloManufacturadoDetalle, Integer>{
	@Query(value = "SELECT * FROM ArticuloManufacturadoDetalle WHERE  fk_id_articuloManufacturado=?1", nativeQuery = true)
	public List<ArticuloManufacturadoDetalle> getAllFromId(int ig);
}
