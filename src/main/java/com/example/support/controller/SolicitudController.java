package com.example.support.controller;

import com.example.support.model.Solicitud;
import com.example.support.service.SolicitudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public ResponseEntity<List<Solicitud>> listar() {
        return ResponseEntity.ok(solicitudService.listarTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener solicitud por ID")
    public ResponseEntity<Solicitud> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear una nueva solicitud")
    public ResponseEntity<Solicitud> crear(@RequestBody Solicitud solicitud) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudService.crear(solicitud));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una solicitud existente")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Long id, @RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(solicitudService.actualizar(id, solicitud));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una solicitud")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ NUEVO: Marcar como completada (lo que pidió el profesor)
    @PatchMapping("/{id}/completar")
    @Operation(summary = "Marcar una solicitud como COMPLETADA")
    public ResponseEntity<Solicitud> completar(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.completar(id));
    }

    // ✅ NUEVO: Asignar técnico a una solicitud
    @PatchMapping("/{solicitudId}/asignar-tecnico/{tecnicoId}")
    @Operation(summary = "Asignar un técnico a una solicitud")
    public ResponseEntity<Solicitud> asignarTecnico(
            @PathVariable Long solicitudId,
            @PathVariable Long tecnicoId) {
        return ResponseEntity.ok(solicitudService.asignarTecnico(solicitudId, tecnicoId));
    }

    // ✅ NUEVO: Filtrar solicitudes por estado
    @GetMapping("/estado/{estado}")
    @Operation(summary = "Filtrar solicitudes por estado: NUEVA, EN_PROCESO, COMPLETADA, CANCELADA")
    public ResponseEntity<List<Solicitud>> filtrarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(solicitudService.filtrarPorEstado(estado));
    }
}