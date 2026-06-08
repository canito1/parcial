package com.grupo2.soporte_tecnico.controller;

import com.grupo2.soporte_tecnico.model.EstadoSolicitud;
import com.grupo2.soporte_tecnico.model.Solicitud;
import com.grupo2.soporte_tecnico.service.SolicitudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.lang.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@Tag(name = "Solicitudes", description = "Gestión de solicitudes de soporte técnico")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    @Operation(summary = "Listar todas las solicitudes")
    public ResponseEntity<List<Solicitud>> listarTodas() {
        return ResponseEntity.ok(solicitudService.listarTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener solicitud por ID")
    public ResponseEntity<Solicitud> obtenerPorId(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(solicitudService.obtenerPorId(id));
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Solicitudes por cliente")
    public ResponseEntity<List<Solicitud>> listarPorCliente(@PathVariable @NonNull Long clienteId) {
        return ResponseEntity.ok(solicitudService.listarPorCliente(clienteId));
    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Solicitudes por estado")
    public ResponseEntity<List<Solicitud>> listarPorEstado(
            @PathVariable EstadoSolicitud estado) {
        return ResponseEntity.ok(solicitudService.listarPorEstado(estado));
    }

    @PostMapping
    @Operation(summary = "Crear nueva solicitud")
    public ResponseEntity<Solicitud> crear(@Valid @RequestBody Solicitud solicitud) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudService.crear(solicitud));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar solicitud")
    public ResponseEntity<Solicitud> actualizar(@PathVariable @NonNull Long id,
                                                 @Valid @RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(solicitudService.actualizar(id, solicitud));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar solicitud")
    public ResponseEntity<Void> eliminar(@PathVariable @NonNull Long id) {
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
