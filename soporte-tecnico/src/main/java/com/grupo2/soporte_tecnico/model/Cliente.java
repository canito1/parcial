package com.grupo2.soporte_tecnico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^[0-9]{7,15}$", message = "El teléfono solo debe contener números (entre 7 y 15 dígitos)")
    private String telefono;

    @NotBlank(message = "La empresa no puede estar vacía")
    private String empresa;

    public Cliente() {}

    public Cliente(Long id, String nombre, String email,
                   String telefono, String empresa) {
        this.id       = id;
        this.nombre   = nombre;
        this.email    = email;
        this.telefono = telefono;
        this.empresa  = empresa;
    }

    public Long getId()                          { return id; }
    public void setId(Long id)                   { this.id = id; }
    public String getNombre()                    { return nombre; }
    public void setNombre(String nombre)         { this.nombre = nombre; }
    public String getEmail()                     { return email; }
    public void setEmail(String email)           { this.email = email; }
    public String getTelefono()                  { return telefono; }
    public void setTelefono(String telefono)     { this.telefono = telefono; }
    public String getEmpresa()                   { return empresa; }
    public void setEmpresa(String empresa)       { this.empresa = empresa; }
}
