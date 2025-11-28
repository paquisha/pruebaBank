package com.example.cuentas.repository;

import com.example.cuentas.dto.MovimientoDTO;
import com.example.cuentas.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByFechaBetweenAndNumeroCuenta(LocalDate start, LocalDate end, String numeroCuenta);
}
