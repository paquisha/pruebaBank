package com.example.cuentas.service;

import com.example.cuentas.dto.CuentaDTO;
import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.exception.NotFoundException;
import com.example.cuentas.mapper.Mapper;
import com.example.cuentas.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService implements ICuentaService {

    @Autowired
    private CuentaRepository repo;


    @Override
    public List<CuentaDTO> listar() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public CuentaDTO obtener(String id) {
        Cuenta cuenta = repo.findById(id).orElseThrow(() -> new NotFoundException("Cuenta no encontrado"));
        return Mapper.toDTO(cuenta);
    }

    @Override
    public CuentaDTO crearCuenta(CuentaDTO cuentaDTO) {
        var cuenta = Cuenta.builder()
                .numeroCuenta(cuentaDTO.getNumeroCuenta())
                .tipoCuenta(cuentaDTO.getTipoCuenta())
                .saldoInicial(cuentaDTO.getSaldoInicial())
                .estado(cuentaDTO.getEstado())
                .clienteId(cuentaDTO.getClienteId())
                .build();
        return Mapper.toDTO(repo.save(cuenta));
    }

    @Override
    public CuentaDTO actualizarCuenta(String id,CuentaDTO cuentaDTO) {
        Cuenta cuenta = repo.findById(id).orElseThrow(() -> new NotFoundException("Cuenta no encontrada para actualizar"));

        cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDTO.getSaldoInicial());
        cuenta.setEstado(cuentaDTO.getEstado());
        cuenta.setClienteId(cuentaDTO.getClienteId());

        return Mapper.toDTO(repo.save(cuenta));
    }

    @Override
    public void eliminar(String id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Cuenta no encontrado para elimdnar");
        }
        repo.deleteById(id);
    }
}
