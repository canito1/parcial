package com.grupo2.soporte_tecnico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 5, max = 150, message = "El título debe tener entre 5 y 150 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String descripcion;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    private Long tecnicoId;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;

    @NotBlank(message = "La prioridad no puede estar vacía")
    @Pattern(
        regexp = "^(Alta|Media|Baja)$",
        message = "La prioridad debe ser: Alta, Media o Baja"
    )
    private String prioridad;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public Solicitud() {
        this.estado             = EstadoSolicitud.PENDIENTE;
        this.prioridad          = "Baja";
        this.fechaCreacion      = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Long getId()                               { return id; }
    public void setId(Long id)                        { this.id = id; }
    public String getTitulo()                         { return titulo; }
    public void setTitulo(String titulo)              { this.titulo = titulo; }
    public String getDescripcion()                    { return descripcion; }
    public void setDescripcion(String descripcion)    { this.descripcion = descripcion; }
    public Long getClienteId()                        { return clienteId; }
    public void setClienteId(Long clienteId)          { this.clienteId = clienteId; }
    public Long getTecnicoId()                        { return tecnicoId; }
    public void setTecnicoId(Long tecnicoId)          { this.tecnicoId = tecnicoId; }
    public EstadoSolicitud getEstado()                { return estado; }
    public void setEstado(EstadoSolicitud estado)     { this.estado = estado; }
    public String getPrioridad()                      { return prioridad; }
    public void setPrioridad(String prioridad)        { this.prioridad = prioridad; }
    public LocalDateTime getFechaCreacion()           { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime f)     { this.fechaCreacion = f; }
    public LocalDateTime getFechaActualizacion()      { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime f){ this.fechaActualizacion = f; }
}
