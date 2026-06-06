package com.example.support.service;

import com.example.support.model.Solicitud;
import java.util.List;

public interface SolicitudService {
    List<Solicitud> listarTodas();
    Solicitud obtenerPorId(Long id);
    Solicitud crear(Solicitud solicitud);
    Solicitud actualizar(Long id, Solicitud solicitud);
    void eliminar(Long id);
    Solicitud completar(Long id);
    Solicitud asignarTecnico(Long solicitudId, Long tecnicoId);
    List<Solicitud> filtrarPorEstado(String estado);
}