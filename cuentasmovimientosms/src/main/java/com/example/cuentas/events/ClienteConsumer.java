package com.example.cuentas.events;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ClienteConsumer {

    @RabbitListener(queues = "${rabbit.queue.clientes}")
    public void receiveCliente(Map<String,Object> cliente) {
        // simple log; in real app map to DTO and persist or update
        System.out.println("Cliente recibido: " + cliente);
    }
}
