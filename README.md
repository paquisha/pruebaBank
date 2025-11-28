Microservicios ejemplo (clientespersonasms y cuentasmovimientosms)

Estructura creada en /mnt/data/microservices_project

Cómo compilar (por proyecto):
  mvn -f clientespersonasms clean package
  mvn -f cuentasmovimientosms clean package

Luego construir imágenes (ejemplo):
  docker build -t clientes-ms:latest ./clientes-personas-ms
  docker build -t cuentas-ms:latest ./cuentas-movimientos-ms

O usar docker-compose:
  docker-compose up --build

Endpoints:
  Clientes: POST/GET /clientes (puerto 8081)
  Cuentas: POST/GET /cuentas (puerto 8082)
  Movimientos: POST /movimientos/{numeroCuenta} (puerto 8082)
  Reportes: GET /reportes?clienteId=...&inicio=YYYY-MM-DD&fin=YYYY-MM-DD

Notas:
