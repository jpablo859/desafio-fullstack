# Instrucciones de Ejecución

## Requisitos Previos

- Docker
- Docker Compose

## Pasos para Ejecutar

1. Clonar el repositorio: git clone https://github.com/jpablo859/desafio-fullstack.git
2. Ejecutar con Docker Compose: docker compose up --build
3. Para detener los servicios: docker compose down

## Servicios Disponibles

### Frontend (React + Vite)

- URL: [http://localhost:5173](http://localhost:5173)
- Tecnologías: React 19, TypeScript, Bootstrap 5
- Variables de entorno: VITE_API_URL

### Backend (Spring Boot)

- URL: [http://localhost:8080](http://localhost:8080)
- Documentación API: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- OpenAPI JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

### Base de Datos (H2)

- Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: jdbc:h2:mem:platform
- Usuario: sa
- Contraseña: (vacía)

## Endpoints API

### Usuarios

- POST /user/create - Crear usuario
- GET /user/all - Listar usuarios
- GET /user/by-id/{id} - Obtener usuario por ID
- PUT /user/update - Actualizar usuario
- DELETE /user/delete/{id} - Eliminar usuario

## Notas

- El frontend tiene hot-reload habilitado
- La base de datos H2 es en memoria y se reinicia al reiniciar el servicio
- La documentación OpenAPI está disponible en formato YAML y a través de Swagger UI
