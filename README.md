# 🩺 API Citas Médicas — Proyecto Final

Proyecto desarrollado con **Spring Boot  (Java 21)** y base de datos **PostgreSQL (Docker)**.  
Desplegado en una **VPS pública de Oracle Cloud (Ubuntu 22.04)** con conexión abierta para pruebas externas mediante Postman o navegador.

El sistema gestiona **citas médicas, pacientes, médicos y usuarios administrativos**, usando autenticación **JWT (tokens)** y arquitectura **REST**.

---

## 🌐 URL pública de la API

- **Swagger UI:**  
  👉 [http://158.247.124.84:8080/swagger-ui/index.html](http://158.247.124.84:8080/swagger-ui/index.html)


---

## 🔐 Credenciales de acceso (para prueba)

**Endpoint de login:**
POST /api/auth/login


**Body (JSON):**
```json
{
  "email": "admin@example.com",
  "password": "password123"
}
