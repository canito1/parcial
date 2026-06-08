package com.grupo2.soporte_tecnico.repository;

import com.grupo2.soporte_tecnico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // findAll, findById, existsById, deleteById y save
    // ya vienen incluidos en JpaRepository 
}
