# 💻 Microservicios: Clientes y Cuentas

Este proyecto está compuesto por dos microservicios principales:

* **`clientespersonasms`**: Gestiona la información de clientes.
* **`cuentasmovimientosms`**: Administra cuentas bancarias y movimientos.

---

## 🛠️ Instrucciones de Compilación y Ejecución

Sigue estos pasos para compilar, construir las imágenes de Docker y levantar los servicios.

### 📦 1. Compilación de Proyectos (Maven)

Compila cada proyecto individualmente usando Maven:

* **Clientes (Personas):**
    ```bash
    mvn -f clientespersonasms clean package
    ```
* **Cuentas y Movimientos:**
    ```bash
    mvn -f cuentasmovimientosms clean package
    ```

### 🐳 2. Construcción de Imágenes Docker

Una vez compilados, puedes construir las imágenes de Docker:

* **Clientes (Personas):**
    ```bash
    docker build -t clientesms:latest ./clientespersonasms
    ```
* **Cuentas y Movimientos:**
    ```bash
    docker build -t cuentasms:latest ./cuentas-movimientosms
    ```

### 🚀 3. Ejecución con Docker Compose (Recomendado)

La forma más sencilla de levantar ambos servicios y sus dependencias es utilizando **Docker Compose**:

```bash
docker-compose down --volumes --remove-orphans
docker-compose up --build
```

### Ejemplo de Respuesta Swagger del Servicio de Clientes

```bash
http://localhost:8080/swagger-ui/index.html?
http://localhost:8081/swagger-ui/index.html?
```