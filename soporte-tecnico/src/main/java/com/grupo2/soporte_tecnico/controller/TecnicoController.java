package com.grupo2.soporte_tecnico.controller;

import com.grupo2.soporte_tecnico.model.Tecnico;
import com.grupo2.soporte_tecnico.service.TecnicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.lang.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
@Tag(name = "Técnicos", description = "Gestión de técnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los técnicos")
    public ResponseEntity<List<Tecnico>> listarTodos() {
        return ResponseEntity.ok(tecnicoService.listarTodos());
    }

    @GetMapping("/disponibles")
    @Operation(summary = "Listar técnicos disponibles")
    public ResponseEntity<List<Tecnico>> listarDisponibles() {
        return ResponseEntity.ok(tecnicoService.listarDisponibles());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener técnico por ID")
    public ResponseEntity<Tecnico> obtenerPorId(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(tecnicoService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo técnico")
    public ResponseEntity<Tecnico> crear(@Valid @RequestBody Tecnico tecnico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoService.crear(tecnico));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar técnico")
    public ResponseEntity<Tecnico> actualizar(@PathVariable @NonNull Long id,
                                               @Valid @RequestBody Tecnico tecnico) {
        return ResponseEntity.ok(tecnicoService.actualizar(id, tecnico));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar técnico")
    public ResponseEntity<Void> eliminar(@PathVariable @NonNull Long id) {
        tecnicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
