package com.example.cuentas.service;

import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.entity.Movimiento;
import com.example.cuentas.repository.CuentaRepository;
import com.example.cuentas.repository.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    private final CuentaRepository cuentaRepo;
    private final MovimientoRepository movRepo;

    public ReporteService(CuentaRepository cuentaRepo, MovimientoRepository movRepo) {
        this.cuentaRepo = cuentaRepo; this.movRepo = movRepo;
    }

    public Map<String,Object> generarReporte(String clienteId, LocalDate inicio, LocalDate fin) {
        Map<String,Object> out = new HashMap<>();
        List<Cuenta> cuentas = cuentaRepo.findAll().stream().filter(c->clienteId.equals(c.getClienteId())).toList();
        out.put("cuentas", cuentas);
        List<Movimiento> movimientos = cuentas.stream()
                .flatMap(c -> movRepo.findByFechaBetweenAndNumeroCuenta(inicio, fin, c.getNumeroCuenta()).stream())
                .toList();
        out.put("movimientos", movimientos);
        return out;
    }
}
