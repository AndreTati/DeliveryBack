package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Rol;

public interface RolRepository   extends JpaRepository<Rol, Integer>{
	@Modifying
	@Transactional
	@Query( "UPDATE Rol SET eliminado_rol = true WHERE id= ?1" )
	public int deleteLogico (int id);
}
