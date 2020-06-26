package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.UnidadDeMedida;

@Repository
public interface UnidadDeMedidaRepository extends JpaRepository<UnidadDeMedida, Integer>{

	
	@Modifying
	@Transactional
	@Query("UPDATE UnidadDeMedida SET eliminado_unidadDeMedida=true WHERE id=?1")
	public int deleteById(int id);
	
}
