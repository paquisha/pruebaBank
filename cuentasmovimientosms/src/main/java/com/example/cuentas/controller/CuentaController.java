package com.example.cuentas.controller;

import com.example.cuentas.dto.CuentaDTO;
import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService service;

    @GetMapping
    public ResponseEntity<List<CuentaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaDTO> obtener(@PathVariable String id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @PostMapping
    public ResponseEntity<CuentaDTO> crear(@RequestBody CuentaDTO cuentaDTO) {
        CuentaDTO creado = service.crearCuenta(cuentaDTO);
        return ResponseEntity.created(URI.create("/api/cuentas/" + creado.getClienteId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaDTO> actualizar(@PathVariable String id, @RequestBody CuentaDTO cuentaDTO) {
        return ResponseEntity.ok(service.actualizarCuenta(id, cuentaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
