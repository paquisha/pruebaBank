package com.example.cuentas.mapper;

import com.example.cuentas.dto.CuentaDTO;
import com.example.cuentas.dto.MovimientoDTO;
import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.entity.Movimiento;

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

    public static MovimientoDTO toDTO(Movimiento movimiento) {
        if (movimiento == null) return null;
        return MovimientoDTO.builder()
                .id(movimiento.getId())
                .fecha(movimiento.getFecha())
                .tipoMovimiento(movimiento.getTipoMovimiento())
                .valor(movimiento.getValor())
                .saldo(movimiento.getSaldo())
                .numeroCuenta(movimiento.getNumeroCuenta())
                .build();
    }
}
