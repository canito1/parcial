# Sistema de Soporte Técnico

API REST para la gestión de solicitudes de soporte técnico, desarrollada con **Spring Boot 3.5** y persistencia en base de datos **H2**.


## Descripción

Sistema backend que permite administrar clientes, técnicos y solicitudes de soporte técnico. Incluye asignación de técnicos, seguimiento de estados y filtrado por cliente o estado de solicitud.

##  Tecnologías utilizadas

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Spring Boot | 3.5.0 |
| Spring Data JPA | 3.5.0 |
| H2 Database | (embedded) |
| Springdoc OpenAPI (Swagger) | 2.8.8 |
| Maven | 3.x |

## Estructura del proyecto

soporte-tecnico/
├── src/
│   └── main/
│       ├── java/com/grupo2/soporte_tecnico/
│       │   ├── controller/
│       │   │   ├── ClienteController.java
│       │   │   ├── TecnicoController.java
│       │   │   └── SolicitudController.java
│       │   ├── model/
│       │   │   ├── Cliente.java
│       │   │   ├── Tecnico.java
│       │   │   ├── Solicitud.java
│       │   │   └── EstadoSolicitud.java
│       │   ├── repository/
│       │   │   ├── ClienteRepository.java
│       │   │   ├── TecnicoRepository.java
│       │   │   └── SolicitudRepository.java
│       │   ├── service/
│       │   │   ├── ClienteService.java
│       │   │   ├── TecnicoService.java
│       │   │   ├── SolicitudService.java
│       │   │   └── impl/
│       │   │       ├── ClienteServiceImpl.java
│       │   │       ├── TecnicoServiceImpl.java
│       │   │       └── SolicitudServiceImpl.java
│       │   └── exception/
│       │       └── RecursoNoEncontradoException.java
│       └── resources/
│           └── application.properties
├── data/
│   └── soportedb.mv.db        ← base de datos H2 en archivo
└── pom.xml

#  Sistema de Soporte Técnico

El archivo application.properties contiene la configuración principal:

server.port=8080
spring.application.name=soporte-tecnico

##  base de datos H2 en archivo
spring.datasource.url=jdbc:h2:file:./data/soportedb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

##  JPA / Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

##  Consola H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

##  Swagger UI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true

##  DevTools
spring.devtools.restart.enabled=false

##  Ejecución del Proyecto

### Clonar el repositorio
git clone https://github.com/orlandoCalderon7/Sistema_Soporte_Tecnico
cd soporte-tecnico

### Limpiar y compilar
./mvnw clean
./mvnw dependency:resolve

### Ejecutar
./mvnw spring-boot:run

## Acceso a la Aplicación
Api Base: http://localhost:8080/api
Swagger UI: http://localhost:8080/swagger-ui.html
OpenAPI JSON: http://localhost:8080/api-docs
Consola H2: http://localhost:8080/h2-console

## Credenciales consola H2
JDBC URL: jdbc:h2:file:./data/soportedb
Usuario: sa
Contraseña: Vacia

##  Verificar en Consola H2
Abre: http://localhost:8080/h2-console

Alli se pueden hacer consulta sql directamente como también insertar datos diectos en consola H2

##  Proyecto Académico
Proyecto Académico realizado por el Grupo 2 



