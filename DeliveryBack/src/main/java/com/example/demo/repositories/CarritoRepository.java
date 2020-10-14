package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{

	@Query(value = "SELECT * FROM Carrito WHERE fk_id_cliente =?1", nativeQuery  =true)
	public Optional<Carrito> getOneByCliente(int idCliente);
}
