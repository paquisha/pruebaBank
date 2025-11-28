package com.example.cuentas.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RabbitConfig {

    @Value("${rabbit.queue.clientes}")
    private String queue;

    @Bean
    public Queue queueClientes() { return new Queue(queue, true); }
}
