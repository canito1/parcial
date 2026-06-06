package com.example.support.service.impl;

import com.example.support.exception.RecursoNoEncontradoException;
import com.example.support.model.EstadoSolicitud;
import com.example.support.model.Solicitud;
import com.example.support.service.SolicitudService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final List<Solicitud> solicitudes = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    @Override
    public List<Solicitud> listarTodas() {
        return solicitudes;
    }

    @Override
    public Solicitud obtenerPorId(Long id) {
        return solicitudes.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RecursoNoEncontradoException("Solicitud no encontrada con id: " + id));
    }

    @Override
    public Solicitud crear(Solicitud solicitud) {
        solicitud.setId(contador.getAndIncrement());
        solicitud.setEstado(EstadoSolicitud.NUEVA);
        solicitudes.add(solicitud);
        return solicitud;
    }

    @Override
    public Solicitud actualizar(Long id, Solicitud datos) {
        Solicitud solicitud = obtenerPorId(id);
        solicitud.setTitulo(datos.getTitulo());
        solicitud.setDescripcion(datos.getDescripcion());
        solicitud.setClienteId(datos.getClienteId());
        solicitud.setTecnicoId(datos.getTecnicoId());
        if (datos.getEstado() != null) {
            solicitud.setEstado(datos.getEstado());
        }
        return solicitud;
    }

    @Override
    public void eliminar(Long id) {
        Solicitud solicitud = obtenerPorId(id);
        solicitudes.remove(solicitud);
    }

    @Override
    public Solicitud completar(Long id) {
        Solicitud solicitud = obtenerPorId(id);
        solicitud.setEstado(EstadoSolicitud.COMPLETADA);
        return solicitud;
    }

    @Override
    public Solicitud asignarTecnico(Long solicitudId, Long tecnicoId) {
        Solicitud solicitud = obtenerPorId(solicitudId);
        solicitud.setTecnicoId(tecnicoId);
        return solicitud;
    }

    @Override
    public List<Solicitud> filtrarPorEstado(String estado) {
        EstadoSolicitud estadoEnum = EstadoSolicitud.valueOf(estado.toUpperCase());
        return solicitudes.stream()
                .filter(s -> s.getEstado() == estadoEnum)
                .collect(Collectors.toList());
    }
}