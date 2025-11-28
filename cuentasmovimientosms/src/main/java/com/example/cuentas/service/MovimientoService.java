package com.example.cuentas.service;

import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.entity.Movimiento;
import com.example.cuentas.repository.CuentaRepository;
import com.example.cuentas.repository.MovimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class MovimientoService {

    private final MovimientoRepository movRepo;
    private final CuentaRepository cuentaRepo;

    public MovimientoService(MovimientoRepository movRepo, CuentaRepository cuentaRepo) {
        this.movRepo = movRepo; this.cuentaRepo = cuentaRepo;
    }

    @Transactional
    public Movimiento registrarMovimiento(String numeroCuenta, Movimiento mov) {
        Cuenta cuenta = cuentaRepo.findById(numeroCuenta).orElseThrow(() -> new RuntimeException("Cuenta no existe"));
        Double saldoActual = cuenta.getSaldoInicial() == null ? 0.0 : cuenta.getSaldoInicial();
        Double nuevoSaldo = saldoActual + mov.getValor();

        if (nuevoSaldo < 0) {
            throw new RuntimeException("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepo.save(cuenta);

        mov.setSaldo(nuevoSaldo);
        mov.setFecha(LocalDate.now());
        mov.setNumeroCuenta(numeroCuenta);

        return movRepo.save(mov);
    }
}
