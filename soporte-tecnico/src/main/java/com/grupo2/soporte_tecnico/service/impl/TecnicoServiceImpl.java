package com.grupo2.soporte_tecnico.service.impl;

import com.grupo2.soporte_tecnico.exception.RecursoNoEncontradoException;
import com.grupo2.soporte_tecnico.model.Tecnico;
import com.grupo2.soporte_tecnico.repository.TecnicoRepository;
import com.grupo2.soporte_tecnico.service.TecnicoService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TecnicoServiceImpl implements TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoServiceImpl(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    @Override
    public List<Tecnico> listarTodos() { return tecnicoRepository.findAll(); }

    @Override
    public List<Tecnico> listarDisponibles() { return tecnicoRepository.findByDisponibleTrue(); }

    @Override
    public Tecnico obtenerPorId(@NonNull Long id) {
        return tecnicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Técnico no encontrado con ID: " + id));
    }

    @Override
    public Tecnico crear(Tecnico tecnico) {
        tecnico.setId(null);
        return tecnicoRepository.save(tecnico);
    }

    @Override
    public Tecnico actualizar(@NonNull Long id, Tecnico datos) {
        Tecnico existente = obtenerPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setEspecialidad(datos.getEspecialidad());
        existente.setTurno(datos.getTurno());
        existente.setDisponible(datos.isDisponible());
        return tecnicoRepository.save(existente);
    }

    @Override
    public void eliminar(@NonNull Long id) {
        if (!tecnicoRepository.existsById(id))
            throw new RecursoNoEncontradoException("Técnico no encontrado con ID: " + id);
        tecnicoRepository.deleteById(id);
    }
}
