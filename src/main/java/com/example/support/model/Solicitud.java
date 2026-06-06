package com.example.support.model;

public class Solicitud {
    private Long id;
    private String titulo;
    private String descripcion;
    private Long clienteId;
    private Long tecnicoId;
    private EstadoSolicitud estado;

    public Solicitud() {}

    public Solicitud(Long id, String titulo, String descripcion, Long clienteId) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.clienteId = clienteId;
        this.estado = EstadoSolicitud.NUEVA;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getTecnicoId() { return tecnicoId; }
    public void setTecnicoId(Long tecnicoId) { this.tecnicoId = tecnicoId; }
    public EstadoSolicitud getEstado() { return estado; }
    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }
}