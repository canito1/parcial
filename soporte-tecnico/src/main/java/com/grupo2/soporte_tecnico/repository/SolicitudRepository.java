package com.grupo2.soporte_tecnico.repository;

import com.grupo2.soporte_tecnico.model.Solicitud;
import com.grupo2.soporte_tecnico.model.EstadoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    // Reemplaza tu findByClienteId() 
    List<Solicitud> findByClienteId(Long clienteId);

    // Reemplaza tu findByEstado() — ahora recibe el enum directamente 
    List<Solicitud> findByEstado(EstadoSolicitud estado);
}
