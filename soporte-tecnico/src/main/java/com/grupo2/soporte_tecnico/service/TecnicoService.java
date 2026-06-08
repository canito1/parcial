package com.grupo2.soporte_tecnico.service;

import com.grupo2.soporte_tecnico.model.Tecnico;
import org.springframework.lang.NonNull;
import java.util.List;

public interface TecnicoService {
    List<Tecnico> listarTodos();
    List<Tecnico> listarDisponibles();
    Tecnico obtenerPorId(@NonNull Long id);
    Tecnico crear(Tecnico tecnico);
    Tecnico actualizar(@NonNull Long id, Tecnico tecnico);
    void eliminar(@NonNull Long id);
}
