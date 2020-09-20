package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	@Modifying
	@Transactional
	@Query(value="UPDATE Persona SET eliminado_persona=true WHERE id_persona=?1",nativeQuery = true)
	public int deleteById(int id);
}
