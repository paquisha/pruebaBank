package com.example.cuentas.controller;

import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.service.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService service;

    public CuentaController(CuentaService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Cuenta> crear(@RequestBody Cuenta c) {
        return ResponseEntity.ok(service.crearCuenta(c));
    }

    @GetMapping
    public List<Cuenta> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtener(@PathVariable String id) {
        Cuenta c = service.obtener(id);
        return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
