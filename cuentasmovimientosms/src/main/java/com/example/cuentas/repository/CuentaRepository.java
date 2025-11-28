package com.example.cuentas.repository;

import com.example.cuentas.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {
}
