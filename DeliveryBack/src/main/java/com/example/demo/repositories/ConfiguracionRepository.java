package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Configuracion;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer>{

	@Modifying
	@Transactional
	@Query("UPDATE Configuracion SET eliminado_configuracion=true WHERE id=?1")
	public int deleteById(int id);
}
