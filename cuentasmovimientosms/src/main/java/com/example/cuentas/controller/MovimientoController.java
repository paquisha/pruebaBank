package com.example.cuentas.controller;

import com.example.cuentas.entity.Movimiento;
import com.example.cuentas.service.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoService service;

    public MovimientoController(MovimientoService service) { this.service = service; }

    @PostMapping("/{numeroCuenta}")
    public ResponseEntity<?> registrar(@PathVariable String numeroCuenta, @RequestBody Movimiento mov) {
        try {
            Movimiento r = service.registrarMovimiento(numeroCuenta, mov);
            return ResponseEntity.ok(r);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}
