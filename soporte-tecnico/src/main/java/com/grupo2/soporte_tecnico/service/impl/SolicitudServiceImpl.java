package com.grupo2.soporte_tecnico.service.impl;

import com.grupo2.soporte_tecnico.exception.RecursoNoEncontradoException;
import com.grupo2.soporte_tecnico.model.EstadoSolicitud;
import com.grupo2.soporte_tecnico.model.Solicitud;
import com.grupo2.soporte_tecnico.repository.SolicitudRepository;
import com.grupo2.soporte_tecnico.service.SolicitudService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public SolicitudServiceImpl(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public List<Solicitud> listarTodas() { return solicitudRepository.findAll(); }

    @Override
    public List<Solicitud> listarPorCliente(@NonNull Long id) {
        return solicitudRepository.findByClienteId(id);
    }

    @Override
    public List<Solicitud> listarPorEstado(EstadoSolicitud estado) {
        return solicitudRepository.findByEstado(estado);
    }

    @Override
    public Solicitud obtenerPorId(@NonNull Long id) {
        return solicitudRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Solicitud no encontrada con ID: " + id));
    }

    @Override
    public Solicitud crear(Solicitud solicitud) {
        solicitud.setId(null);
        solicitud.setFechaCreacion(LocalDateTime.now());
        solicitud.setFechaActualizacion(LocalDateTime.now());
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud actualizar(@NonNull Long id, Solicitud datos) {
        Solicitud existente = obtenerPorId(id);
        existente.setTitulo(datos.getTitulo());
        existente.setDescripcion(datos.getDescripcion());
        existente.setPrioridad(datos.getPrioridad());
        existente.setEstado(datos.getEstado());
        existente.setTecnicoId(datos.getTecnicoId());
        existente.setFechaActualizacion(LocalDateTime.now());
        return solicitudRepository.save(existente);
    }

    @Override
    public void eliminar(@NonNull Long id) {
        if (!solicitudRepository.existsById(id))
            throw new RecursoNoEncontradoException("Solicitud no encontrada con ID: " + id);
        solicitudRepository.deleteById(id);
    }
}
