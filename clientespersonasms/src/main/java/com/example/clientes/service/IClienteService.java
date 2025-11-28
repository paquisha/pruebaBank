package com.example.clientes.service;

import com.example.clientes.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {
    List<ClienteDTO> getClientes();
    ClienteDTO getClienteById(Long id);
    ClienteDTO createCliente(ClienteDTO clienteDTO);
    ClienteDTO updateCliente(Long id,ClienteDTO clienteDTO);
    void deleteCliente(Long id);
}
