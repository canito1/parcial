package com.grupo2.soporte_tecnico.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Estado posible de una solicitud de soporte")
public enum EstadoSolicitud {
    PENDIENTE,
    EN_PROCESO,
    RESUELTO,
    CANCELADO
}
