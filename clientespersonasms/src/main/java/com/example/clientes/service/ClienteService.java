package com.example.clientes.service;

import com.example.clientes.dto.ClienteDTO;
import com.example.clientes.entity.Cliente;
import com.example.clientes.entity.Persona;
import com.example.clientes.exception.NotFoundException;
import com.example.clientes.mapper.Mapper;
import com.example.clientes.repository.ClienteRepository;
import com.example.clientes.events.ClienteProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    private final ClienteRepository repo;
    private final ClienteProducer producer;

    public ClienteService(ClienteRepository repo,ClienteProducer producer) {
        this.repo = repo;
        this.producer = producer;
    }

    //public Cliente guardar(Cliente c) {
      //  Cliente saved = repo.save(c);
        // publicar evento
        //try { producer.sendClienteCreado(saved); } catch(Exception e) { /* log error */ }
        //return saved;
    //}

    @Override
    public List<ClienteDTO> getClientes() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ClienteDTO getClienteById(Long id) {
        Cliente cliente = repo.findById(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
        return Mapper.toDTO(cliente);
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente =  Mapper.toEntity(clienteDTO);

        Cliente saved = repo.save(cliente);

        try {
            producer.sendClienteCreado(saved);
        }catch (Exception e){
            System.err.println("Error enviando evento: " + e.getMessage());
        }

        return Mapper.toDTO(saved);
    }

    @Override
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = repo.findById(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado"));

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setGenero(clienteDTO.getGenero());
        cliente.setEdad(clienteDTO.getEdad());
        cliente.setIdentificacion(clienteDTO.getIdentificacion());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setContrasena( clienteDTO.getContrasena());
        cliente.setEstado(clienteDTO.getEstado());

        return Mapper.toDTO(repo.save(cliente));
    }

    @Override
    public void deleteCliente(Long id) {
        if(!repo.existsById(id)) {
            throw new NotFoundException("Cliente no encontrado para eliminar");
        }
        repo.deleteById(id);
    }
}
