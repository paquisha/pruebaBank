package com.example.clientes.events;

import com.example.clientes.entity.Cliente;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClienteProducer {

    private final AmqpTemplate amqpTemplate;

    @Value("${rabbit.exchange.clientes}")
    private String exchange;

    @Value("${rabbit.routing.clienteCreado}")
    private String routingKey;

    public ClienteProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendClienteCreado(Cliente cliente) {
        amqpTemplate.convertAndSend(exchange, routingKey, cliente);
    }
}
