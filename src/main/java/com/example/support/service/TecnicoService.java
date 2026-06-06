package com.example.support.service;

import com.example.support.model.Tecnico;
import java.util.List;

public interface TecnicoService {
    List<Tecnico> listarTodos();
    Tecnico obtenerPorId(Long id);
    Tecnico crear(Tecnico tecnico);
}
