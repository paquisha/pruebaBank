package com.example.cuentas.mapper;

import com.example.cuentas.dto.CuentaDTO;
import com.example.cuentas.entity.Cuenta;

public class Mapper {
    public static CuentaDTO toDTO(Cuenta cuenta) {
        if (cuenta == null) return null;
        return CuentaDTO.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .saldoInicial(cuenta.getSaldoInicial())
                .estado(cuenta.getEstado())
                .clienteId(cuenta.getClienteId())
                .build();
    }
}
