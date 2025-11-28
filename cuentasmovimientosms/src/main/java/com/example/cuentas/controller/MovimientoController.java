package com.example.cuentas.controller;

import com.example.cuentas.dto.MovimientoDTO;
import com.example.cuentas.entity.Movimiento;
import com.example.cuentas.service.IMovimientoService;
import com.example.cuentas.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService service;
    @Autowired
    private IMovimientoService movimientoService;
    //public MovimientoController(MovimientoService service) { this.service = service; }

    @PostMapping("/{numeroCuenta}")
    public ResponseEntity<?> registrar(@PathVariable String numeroCuenta, @RequestBody Movimiento mov) {
        try {
            Movimiento r = service.registrarMovimiento(numeroCuenta, mov);
            return ResponseEntity.ok(r);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<MovimientoDTO>> listarMovimientos() {
        return ResponseEntity.ok(movimientoService.getMovimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDTO> getMovimientoById(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoService.getMovimientoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoDTO> actualizarMovimiento(@PathVariable Long id, @RequestBody MovimientoDTO mov) {
        return ResponseEntity.ok(movimientoService.updateMovimiento(id, mov));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimientoById(id);
        return ResponseEntity.noContent().build();
    }
}
