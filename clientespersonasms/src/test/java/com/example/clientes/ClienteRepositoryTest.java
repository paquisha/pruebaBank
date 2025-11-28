package com.example.clientes;

import com.example.clientes.entity.Cliente;
import com.example.clientes.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository repo;

    @Test
    public void testCreateAndFind() {
        Cliente c = new Cliente();
        c.setNombre("Jose Lema");
        c.setClienteId("jose123");
        c.setContrasena("1234");
        c.setEstado(true);

        Cliente saved = repo.save(c);
        assertThat(saved.getId()).isNotNull();

        Cliente found = repo.findByClienteId("jose123").orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getNombre()).isEqualTo("Jose Lema");
    }
}
