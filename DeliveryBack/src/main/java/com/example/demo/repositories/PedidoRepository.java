package com.example.demo.repositories;

import java.util.List;

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
	
	@Query(value = "SELECT * FROM Pedido WHERE fk_id_cliente =?1 AND (estado_pedido!='Facturado' AND estado_pedido!='Rechazado')", nativeQuery  =true)
	public List<Pedido> getAllByClientePendientes(int idCliente);
	
	@Query(value = "SELECT * FROM Pedido WHERE fk_id_cliente =?1 AND (estado_pedido='Facturado' OR estado_pedido='Rechazado')", nativeQuery  =true)
	public List<Pedido> getAllByClienteHistorial(int idCliente);
	
	@Query(value = "SELECT * FROM Pedido WHERE fk_id_cliente =?1 AND (estado_pedido='Facturado' OR estado_pedido='Rechazado') ORDER BY id_pedido DESC", nativeQuery  =true)
	public List<Pedido> getAllByClienteHistorialDescendente(int idCliente);
}
