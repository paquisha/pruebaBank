package com.example.cuentas.controller;

import com.example.cuentas.dto.CuentaDTO;
import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.service.CuentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
@Tag(name = "Cuentas", description = "Operaciones para la gestión de cuentas bancarias")
public class CuentaController {

    @Autowired
    private CuentaService service;

    @Operation(summary = "Listar cuentas")
    @GetMapping
    public ResponseEntity<List<CuentaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @Operation(summary = "Obtener una cuenta")
    @GetMapping("/{id}")
    public ResponseEntity<CuentaDTO> obtener(@PathVariable String id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @Operation(summary = "Crear cuenta")
    @PostMapping
    public ResponseEntity<CuentaDTO> crear(@RequestBody CuentaDTO cuentaDTO) {
        CuentaDTO creado = service.crearCuenta(cuentaDTO);
        return ResponseEntity.created(URI.create("/api/cuentas/" + creado.getClienteId())).body(creado);
    }

    @Operation(summary = "Obtener una cuenta por ID")
    @PutMapping("/{id}")
    public ResponseEntity<CuentaDTO> actualizar(@PathVariable String id, @RequestBody CuentaDTO cuentaDTO) {
        return ResponseEntity.ok(service.actualizarCuenta(id, cuentaDTO));
    }

    @Operation(summary = "Eliminar una cuenta", description = "Elimina un cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente eliminado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
