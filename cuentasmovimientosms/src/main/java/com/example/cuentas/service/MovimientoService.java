package com.example.cuentas.service;

import com.example.cuentas.dto.MovimientoDTO;
import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.entity.Movimiento;
import com.example.cuentas.exception.NotFoundException;
import com.example.cuentas.mapper.Mapper;
import com.example.cuentas.repository.CuentaRepository;
import com.example.cuentas.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovimientoService implements IMovimientoService {

    @Autowired
    private  MovimientoRepository movRepo;
    @Autowired
    private CuentaRepository cuentaRepo;

    //public MovimientoService(MovimientoRepository movRepo, CuentaRepository cuentaRepo) {
        //this.movRepo = movRepo; this.cuentaRepo = cuentaRepo;
    //}

    @Transactional
    public Movimiento registrarMovimiento(String numeroCuenta, Movimiento mov) {
        Cuenta cuenta = cuentaRepo.findById(numeroCuenta).orElseThrow(() -> new NotFoundException("Cuenta no existe"));
        Double saldoActual = cuenta.getSaldoInicial() == null ? 0.0 : cuenta.getSaldoInicial();
        Double nuevoSaldo = saldoActual + mov.getValor();

        if (nuevoSaldo < 0) {
            throw new NotFoundException("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepo.save(cuenta);

        mov.setSaldo(nuevoSaldo);
        mov.setFecha(LocalDate.now());
        mov.setNumeroCuenta(numeroCuenta);

        return movRepo.save(mov);
    }

    @Override
    public List<MovimientoDTO> getMovimientos() {
        return movRepo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public MovimientoDTO getMovimientoById(Long id) {
        Movimiento movimiento = movRepo.findById(id).orElseThrow(() -> new NotFoundException("movimiento no encontrado"));
        return Mapper.toDTO(movimiento);
    }

    @Override
    public List<MovimientoDTO> getMovimientosByNumeroCuenta(String numeroCuenta) {
        return List.of();
    }

    @Override
    public MovimientoDTO updateMovimiento(Long id,MovimientoDTO movimientoDTO) {
        Movimiento movimiento = movRepo.findById(id).orElseThrow(() -> new NotFoundException("movimiento no encontrado"));

        movimiento.setFecha(LocalDate.now());
        movimiento.setTipoMovimiento(movimientoDTO.getTipoMovimiento());
        movimiento.setValor(movimientoDTO.getValor());
        movimiento.setSaldo(movimientoDTO.getSaldo());
        movimiento.setNumeroCuenta(movimientoDTO.getNumeroCuenta());

        return Mapper.toDTO(movRepo.save(movimiento));
    }

    @Override
    public void deleteMovimientoById(Long id) {
        Movimiento movimiento = movRepo.findById(id).orElse(null);
        if (movimiento != null) throw new RuntimeException("Movimiento no encontrado");
        movRepo.delete(movimiento);
    }
}
