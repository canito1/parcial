# API de Gestión de Solicitudes de Soporte Técnico

## Descripción

Esta API RESTful está diseñada para registrar, consultar, actualizar y eliminar solicitudes de soporte técnico de una empresa de servicios tecnológicos. El objetivo es reemplazar el registro en papel y correos desordenados con una solución limpia basada en Java y Spring Boot.

## Objetivos

- Registrar solicitudes de soporte técnico.
- Consultar solicitudes existentes.
- Actualizar el estado y los datos de una solicitud.
- Eliminar solicitudes cuando corresponda.
- Simular almacenamiento en memoria con colecciones Java (`List`, `Map`).
- Aplicar una arquitectura por capas: `controller`, `service`, `model`.
- Implementar validaciones y manejo centralizado de errores.

## Estructura propuesta del proyecto

- `com.example.support.controller`
- `com.example.support.service`
- `com.example.support.model`
- `com.example.support.exception`

## Modelos principales

### Solicitud
- `id`: Long
- `titulo`: String
- `descripcion`: String
- `clienteId`: Long
- `tecnicoId`: Long
- `estado`: String (por ejemplo: `NUEVA`, `EN_PROGRESO`, `RESUELTA`)
- `fechaCreacion`: LocalDateTime
- `fechaActualizacion`: LocalDateTime

### Cliente
- `id`: Long
- `nombre`: String
- `email`: String
- `telefono`: String

### Tecnico
- `id`: Long
- `nombre`: String
- `especialidad`: String

## Endpoints CRUD sugeridos

### Solicitudes
- `GET /api/solicitudes` — Listar todas las solicitudes.
- `GET /api/solicitudes/{id}` — Obtener una solicitud por ID.
- `POST /api/solicitudes` — Crear una nueva solicitud.
- `PUT /api/solicitudes/{id}` — Actualizar una solicitud existente.
- `DELETE /api/solicitudes/{id}` — Eliminar una solicitud.

### Clientes
- `GET /api/clientes` — Listar clientes.
- `POST /api/clientes` — Crear cliente.

### Técnicos
- `GET /api/tecnicos` — Listar técnicos.
- `POST /api/tecnicos` — Crear técnico.

## Validaciones

- Usar `@Valid` en los controladores.
- Validar campos obligatorios con `@NotNull`, `@NotBlank`.
- Validar longitud con `@Size`.
- Validar formato de email con `@Email`.

## Manejo de errores

- Implementar un `@ControllerAdvice` global.
- Responder con JSON estructurado en errores.
- Incluir campos como `timestamp`, `status`, `error`, `message`, `path`.

## Ejemplo de petición para crear una solicitud

```json
{
  "titulo": "Problema de conexión VPN",
  "descripcion": "El cliente no puede conectarse a la VPN desde su equipo.",
  "clienteId": 1,
  "tecnicoId": 2,
  "estado": "NUEVA"
}
```

## Flujo de desarrollo

1. Modelar las entidades `Solicitud`, `Cliente`, `Tecnico`.
2. Crear clases DTO/entidad.
3. Implementar interfaces de servicio.
4. Crear servicios con almacenamiento en memoria.
5. Crear controladores REST.
6. Añadir validaciones y excepciones.
7. Probar manualmente con Postman o Swagger.

## Dependencias recomendadas

- Spring Boot Starter Web
- Spring Boot Starter Validation
- Spring Boot DevTools (opcional)
- Springdoc OpenAPI / Swagger (opcional)

## Cómo ejecutar

> Este repositorio actualmente contiene solo documentación. Para ejecutar la API debes crear el proyecto Spring Boot en un subdirectorio o importar un proyecto existente.

1. Abrir el proyecto en VS Code o IntelliJ.
2. Ejecutar la aplicación con `mvn spring-boot:run` o desde la clase principal.
3. Enviar solicitudes HTTP a los endpoints definidos.

## Pruebas funcionales

- Usar Postman para verificar todos los endpoints CRUD.
- Incluir casos de prueba para: creación, actualización, consulta, eliminación y errores de validación.
- Documentar ejemplos de peticiones y respuestas.

## Notas finales

Esta API debe funcionar en memoria durante la ejecución, sin conexión a una base de datos real. El almacenamiento puede ser simulado con `List` o `Map` en los servicios para mantener la información temporal mientras la aplicación está activa.