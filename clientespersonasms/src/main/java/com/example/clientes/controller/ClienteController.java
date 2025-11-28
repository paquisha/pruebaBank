package com.example.clientes.controller;

import com.example.clientes.dto.ClienteDTO;
import com.example.clientes.entity.Cliente;
import com.example.clientes.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;


    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        return ResponseEntity.ok(service.getClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClienteById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO cliente) {
        ClienteDTO creado = service.createCliente(cliente);
        return ResponseEntity.created(URI.create("/api/clientes" + creado.getClienteId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizar(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(service.updateCliente(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
