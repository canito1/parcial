package com.grupo2.soporte_tecnico.repository;

import com.grupo2.soporte_tecnico.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    // Reemplaza tu findDisponibles() — Spring genera el SQL automáticamente
    List<Tecnico> findByDisponibleTrue();
}
