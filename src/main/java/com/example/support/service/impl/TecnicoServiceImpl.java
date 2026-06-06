package com.example.support.service.impl;

import com.example.support.exception.RecursoNoEncontradoException;
import com.example.support.model.Tecnico;
import com.example.support.service.TecnicoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TecnicoServiceImpl implements TecnicoService {

    private final List<Tecnico> tecnicos = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    @Override
    public List<Tecnico> listarTodos() {
        return tecnicos;
    }

    @Override
    public Tecnico obtenerPorId(Long id) {
        return tecnicos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RecursoNoEncontradoException("Técnico no encontrado con id: " + id));
    }

    @Override
    public Tecnico crear(Tecnico tecnico) {
        tecnico.setId(contador.getAndIncrement());
        tecnicos.add(tecnico);
        return tecnico;
    }
}