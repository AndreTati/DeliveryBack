package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer>{
	@Modifying
	@Transactional
	@Query("UPDATE Factura SET eliminado_factura=true WHERE id=?1")
	public int deleteById(int id);
	
	
	@Query(value="SELECT * FROM Factura WHERE fk_id_Pedido=?1", nativeQuery  =true)
	public Optional<Factura> getOneByIdPedido(int idPedido);
}
