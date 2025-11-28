package com.example.clientes.controller;

import com.example.clientes.dto.ClienteDTO;
import com.example.clientes.entity.Cliente;
import com.example.clientes.service.IClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Operaciones del microservicio de clientes y personas")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @Operation(
            summary = "Listar clientes",
            description = "Devuelve todos los clientes registrados"
    )
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        return ResponseEntity.ok(service.getClientes());
    }

    @Operation(
            summary = "Obtener cliente",
            description = "Devuelve un cliente por ID"
    )
    @ApiResponse(responseCode = "200", description = "Cliente encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClienteById(id));
    }

    @Operation(
            summary = "Crear cliente",
            description = "Crea un nuevo cliente en el sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos")
    })
    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO cliente) {
        ClienteDTO creado = service.createCliente(cliente);
        return ResponseEntity.created(URI.create("/api/clientes" + creado.getClienteId())).body(creado);
    }

    @Operation(
            summary = "Actualizar cliente",
            description = "actualiva un cliente en el sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizar(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(service.updateCliente(id, cliente));
    }

    @Operation(
            summary = "Eliminar cliente",
            description = "Elimina un cliente por ID"
    )
    @ApiResponse(responseCode = "200", description = "Cliente eliminado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
