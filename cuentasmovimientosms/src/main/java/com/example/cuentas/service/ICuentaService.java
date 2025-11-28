package com.example.cuentas.service;

import com.example.cuentas.dto.CuentaDTO;
import com.example.cuentas.entity.Cuenta;

import java.util.List;

public interface ICuentaService {
    List<CuentaDTO> listar();
    CuentaDTO obtener(String numeroCuenta);
    CuentaDTO crearCuenta(CuentaDTO Cuenta);
    CuentaDTO actualizarCuenta(CuentaDTO Cuenta);
    void eliminar(String numeroCuenta);
}
