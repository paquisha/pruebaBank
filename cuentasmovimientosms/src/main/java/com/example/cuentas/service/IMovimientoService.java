package com.example.cuentas.service;

import com.example.cuentas.dto.MovimientoDTO;
import com.example.cuentas.entity.Movimiento;

import java.util.List;

public interface IMovimientoService {
    List<MovimientoDTO> getMovimientos();
    MovimientoDTO getMovimientoById(Long id);
    List<MovimientoDTO> getMovimientosByNumeroCuenta(String numeroCuenta);
    MovimientoDTO updateMovimiento(Long id,MovimientoDTO movimiento);
    void deleteMovimientoById(Long id);

}