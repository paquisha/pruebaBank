package com.example.cuentas.service;

import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService implements ICuentaService {

    private final CuentaRepository repo;

    public CuentaService(CuentaRepository repo) { this.repo = repo; }


    public List<Cuenta> listar() { return repo.findAll(); }

    public Cuenta obtener(String id) { return repo.findById(id).orElse(null); }

    public Cuenta crearCuenta(Cuenta c) { return repo.save(c); }

    public void eliminar(String id) { repo.deleteById(id); }
}
