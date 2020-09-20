package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Modifying
	@Transactional
	@Query("UPDATE Pedido SET eliminado_pedido=true WHERE id=?1")
	public int deleteById(int id);
}
