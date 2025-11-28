package com.example.clientes.mapper;

import com.example.clientes.dto.ClienteDTO;
import com.example.clientes.entity.Cliente;

public class Mapper {
    //Mapeo de cliente
    public static ClienteDTO toDTO(Cliente c) {
        if (c == null) return null;

        return ClienteDTO.builder()
                .id(c.getId())
                .nombre(c.getNombre())
                .genero(c.getGenero())
                .edad(c.getEdad())
                .identificacion(c.getIdentificacion())
                .direccion(c.getDireccion())
                .telefono(c.getTelefono())
                .clienteId(c.getClienteId())
                .contrasena(c.getContrasena())
                .estado(c.getEstado())
                .build();
    }

    public static Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;

        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setGenero(dto.getGenero());
        cliente.setEdad(dto.getEdad());
        cliente.setIdentificacion(dto.getIdentificacion());
        cliente.setDireccion(dto.getDireccion());
        cliente.setTelefono(dto.getTelefono());
        cliente.setClienteId(dto.getClienteId());
        cliente.setContrasena(dto.getContrasena());
        cliente.setEstado(dto.getEstado());

        return cliente;
    }
}
