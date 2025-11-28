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
docker-compose up --build
```

### Ejemplo de Respuesta JSON del Servicio de Clientes

```json
{
	"info": {
		"_postman_id": "2ad3aa24-f746-4553-8b18-1a0394d269b8",
		"name": "Microservicios Clientes y Cuentas",
		"description": "Colección para probar los microservicios de Clientes, Cuentas, Movimientos y Reportes.",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "5599530",
		"_collection_link": "https://orange-meteor-382662.postman.co/workspace/pruebasChatBot~07b3bf35-e039-4791-b607-1e5fb1e00341/collection/5599530-2ad3aa24-f746-4553-8b18-1a0394d269b8?action=share&source=collection_link&creator=5599530"
	},
	"item": [
		{
			"name": "Crear Cliente",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"nombre\": \"gabriel Pachacama\",\n    \"genero\": \"Femenino\",\n    \"edad\": 31,\n    \"identificacion\": \"1726189717\",\n    \"direccion\": \"santo domingo, plan piloto\",\n    \"telefono\": \"0991234567\",\n    \"clienteId\": \"CLI-004\",\n    \"contrasena\": \"1234\",\n    \"estado\": true\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/clientes",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"clientes"
					]
				}
			},
			"response": []
		},
		{
			"name": "Crear Cuenta",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"numeroCuenta\": \"21001234567\",\n    \"tipoCuenta\": \"Corriente\",\n    \"saldoInicial\": 5500.0,\n    \"estado\": true,\n    \"clienteId\": \"CLI-006\"\n}"
				},
				"url": {
					"raw": "http://localhost:8081/api/cuentas",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"api",
						"cuentas"
					]
				}
			},
			"response": []
		},
		{
			"name": "Registrar Movimiento",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"fecha\": \"2025-11-27\",\n    \"tipoMovimiento\": \"Deposito\",\n    \"valor\": 350.0\n}"
				},
				"url": {
					"raw": "http://localhost:8081/movimientos/2100123456",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"movimientos",
						"2100123456"
					]
				}
			},
			"response": []
		},
		{
			"name": "Obtener Reporte",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/reportes?clienteId=CLI-001&fechaInicio=2025-01-01&fechaFin=2025-12-31",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"reportes"
					],
					"query": [
						{
							"key": "clienteId",
							"value": "CLI-001"
						},
						{
							"key": "fechaInicio",
							"value": "2025-01-01"
						},
						{
							"key": "fechaFin",
							"value": "2025-12-31"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "listClient",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/clientes",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"clientes"
					]
				}
			},
			"response": []
		},
		{
			"name": "listCuentas",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/api/cuentas",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"api",
						"cuentas"
					]
				}
			},
			"response": []
		},
		{
			"name": "clienteId",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/api/clientes/3",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"clientes",
						"3"
					]
				}
			},
			"response": []
		},
		{
			"name": "updateCliente",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"nombre\": \"Natalia Pachacama\",\r\n    \"genero\": \"Femenino\",\r\n    \"edad\": 23,\r\n    \"identificacion\": \"1726189721\",\r\n    \"direccion\": \"santo domingo, plan piloto\",\r\n    \"telefono\": \"0991234567\",\r\n    \"clienteId\": \"CLI-003\",\r\n    \"contrasena\": \"1234\",\r\n    \"estado\": true\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/api/clientes/3",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"clientes",
						"3"
					]
				}
			},
			"response": []
		},
		{
			"name": "borrarCliente",
			"request": {
				"method": "DELETE",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"nombre\": \"Natalia Pachacama\",\r\n    \"genero\": \"Femenino\",\r\n    \"edad\": 23,\r\n    \"identificacion\": \"1726189721\",\r\n    \"direccion\": \"santo domingo, plan piloto\",\r\n    \"telefono\": \"0991234567\",\r\n    \"clienteId\": \"CLI-003\",\r\n    \"contrasena\": \"1234\",\r\n    \"estado\": true\r\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/clientes/4",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"clientes",
						"4"
					]
				}
			},
			"response": []
		},
		{
			"name": "cuentaById",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"numeroCuenta\": \"2100123487\",\n    \"tipoCuenta\": \"Corriente\",\n    \"saldoInicial\": 5500.0,\n    \"estado\": true,\n    \"clienteId\": \"CLI-002\"\n}"
				},
				"url": {
					"raw": "http://localhost:8081/api/cuentas/2100123456",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"api",
						"cuentas",
						"2100123456"
					]
				}
			},
			"response": []
		},
		{
			"name": "updateCuenta",
			"request": {
				"method": "PUT",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"numeroCuenta\": \"2100123456\",\n    \"tipoCuenta\": \"Ahorros\",\n    \"saldoInicial\": 4000.0,\n    \"estado\": true,\n    \"clienteId\": \"CLI-001\"\n}"
				},
				"url": {
					"raw": "http://localhost:8081/api/cuentas/2100123456",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"api",
						"cuentas",
						"2100123456"
					]
				}
			},
			"response": []
		},
		{
			"name": "deleteCuenta",
			"request": {
				"method": "DELETE",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"numeroCuenta\": \"2100123487\",\n    \"tipoCuenta\": \"Corriente\",\n    \"saldoInicial\": 5500.0,\n    \"estado\": true,\n    \"clienteId\": \"CLI-002\"\n}"
				},
				"url": {
					"raw": "http://localhost:8081/api/cuentas/21001234567",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"api",
						"cuentas",
						"21001234567"
					]
				}
			},
			"response": []
		}
	]
}
```