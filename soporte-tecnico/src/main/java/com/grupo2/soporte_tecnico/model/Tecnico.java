package com.grupo2.soporte_tecnico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La especialidad no puede estar vacía")
    @Pattern(
        regexp = "^(Desarrollo de Software|Ciberseguridad|Administración de Redes|Gestión de TI|Big Data)$",
        message = "La especialidad debe ser: Desarrollo de Software, Ciberseguridad, Administración de Redes, Gestión de TI o Big Data"
    )
    private String especialidad;

    @NotBlank(message = "El turno no puede estar vacío")
    @Pattern(
        regexp = "^(Mañana|Tarde|Noche)$",
        message = "El turno debe ser: Mañana, Tarde o Noche"
    )
    private String turno;

    private boolean disponible;

    public Tecnico() {}

    public Tecnico(Long id, String nombre, String especialidad,
                   String turno, boolean disponible) {
        this.id           = id;
        this.nombre       = nombre;
        this.especialidad = especialidad;
        this.turno        = turno;
        this.disponible   = disponible;
    }

    public Long getId()                           { return id; }
    public void setId(Long id)                    { this.id = id; }
    public String getNombre()                     { return nombre; }
    public void setNombre(String nombre)          { this.nombre = nombre; }
    public String getEspecialidad()               { return especialidad; }
    public void setEspecialidad(String e)         { this.especialidad = e; }
    public String getTurno()                      { return turno; }
    public void setTurno(String turno)            { this.turno = turno; }
    public boolean isDisponible()                 { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
