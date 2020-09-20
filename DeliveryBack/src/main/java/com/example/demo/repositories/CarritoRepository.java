package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{

}
