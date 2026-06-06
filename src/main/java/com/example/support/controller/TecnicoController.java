package com.example.support.controller;

import com.example.support.model.Tecnico;
import com.example.support.service.TecnicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public ResponseEntity<List<Tecnico>> listar() {
        return ResponseEntity.ok(tecnicoService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener técnico por ID")
    public ResponseEntity<Tecnico> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(tecnicoService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo técnico")
    public ResponseEntity<Tecnico> crear(@RequestBody Tecnico tecnico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoService.crear(tecnico));
    }
}