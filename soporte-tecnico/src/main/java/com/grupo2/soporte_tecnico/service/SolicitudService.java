package com.grupo2.soporte_tecnico.service;

import com.grupo2.soporte_tecnico.model.EstadoSolicitud;
import com.grupo2.soporte_tecnico.model.Solicitud;
import org.springframework.lang.NonNull;
import java.util.List;

public interface SolicitudService {
    List<Solicitud> listarTodas();
    Solicitud obtenerPorId(@NonNull Long id);
    List<Solicitud> listarPorCliente(@NonNull Long clienteId);
    List<Solicitud> listarPorEstado(EstadoSolicitud estado);
    Solicitud crear(Solicitud solicitud);
    Solicitud actualizar(@NonNull Long id, Solicitud solicitud);
    void eliminar(@NonNull Long id);
}
