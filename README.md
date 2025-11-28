Microservicios (clientespersonasms y cuentasmovimientosms)

Cómo compilar (por proyecto):
  mvn -f clientespersonasms clean package
  mvn -f cuentasmovimientosms clean package

Luego construir imágenes (ejemplo):
  docker build -t clientesms:latest ./clientespersonasms
  docker build -t cuentasms:latest ./cuentas-movimientosms

O usar docker-compose:
  docker-compose up --build

Endpoints:
  Clientes: POST/GET /clientes (puerto 8080)
  Cuentas: POST/GET /cuentas (puerto 8081)
  Movimientos: POST /movimientos/{numeroCuenta} (puerto 8082)
  Reportes: GET /reportes?clienteId=...&inicio=YYYY-MM-DD&fin=YYYY-MM-DD