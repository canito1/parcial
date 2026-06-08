package com.grupo2.soporte_tecnico;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
    title = "Sistema Soporte Técnico",
    version = "1.0.0",
    description = "API REST para gestión de solicitudes de soporte técnico"
))
@SpringBootApplication
public class SoporteTecnicoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoporteTecnicoApplication.class, args);
    }
}
