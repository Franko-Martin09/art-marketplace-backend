# ArtMarketplace Backend

API REST para una plataforma de marketplace de arte, desarrollada con Java y Spring Boot. Permite gestionar obras (dibujos) con operaciones CRUD completas, validación de datos y manejo centralizado de errores.

---

## Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Jakarta Validation
- Postman (testing de endpoints)

---

## Arquitectura

El proyecto sigue una arquitectura en capas con separación clara de responsabilidades:

```
controller/   → Recibe las requests HTTP y devuelve las respuestas
service/      → Lógica de negocio
repository/   → Acceso a la base de datos (Spring Data JPA)
model/        → Entidades persistidas
dto/          → Objetos de transferencia de datos
exception/    → Manejo centralizado de errores
```

---

## Endpoints

Base URL: `/apiprueba`

| Método | Endpoint         | Descripción                        |
|--------|------------------|------------------------------------|
| GET    | /hola            | Health check de la API             |
| GET    | /dibujos         | Listar todos los dibujos           |
| GET    | /dibujos/{id}    | Obtener un dibujo por ID           |
| POST   | /dibujos         | Crear un nuevo dibujo              |
| PUT    | /dibujos/{id}    | Actualizar un dibujo existente     |
| DELETE | /dibujos/{id}    | Eliminar un dibujo por ID         |

### Ejemplo de request (POST /dibujos)

```json
{
  "titulo": "Paisaje urbano",
  "precio": 5000.00
}
```

### Ejemplo de response

```json
{
  "id": 1,
  "titulo": "Paisaje urbano",
  "precio": 5000.00
}
```

---

## Validaciones

- `titulo`: no puede estar vacío (`@NotBlank`)
- `precio`: debe ser mayor a 0 (`@Positive`)

Si los datos no cumplen las validaciones, la API devuelve un error descriptivo.

---

## Manejo de errores

El proyecto implementa un `GlobalExceptionHandler` con `@ControllerAdvice` que intercepta excepciones personalizadas y devuelve respuestas HTTP apropiadas:

- `404 Not Found` cuando se busca un dibujo con un ID que no existe.

---

## Configuración CORS

La API tiene CORS configurado para aceptar requests desde cualquier origen, permitiendo la integración con frontends externos durante el desarrollo.

---

## Cómo ejecutar el proyecto

### Requisitos
- Java 17+
- Maven
- PostgreSQL corriendo localmente

### Pasos

```bash
# 1. Clonar el repositorio
git clone https://github.com/Franko-Martin09/art-marketplace-backend.git
cd art-marketplace-backend

# 2. Configurar la base de datos en src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/artmarketplace
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

# 3. Ejecutar
./mvnw spring-boot:run
```

La API queda disponible en `http://localhost:8080/apiprueba`

---

## Autor

Franco Martin  
[LinkedIn](https://www.linkedin.com/in/franco-martin-b42967216) · [GitHub](https://github.com/Franko-Martin09)
