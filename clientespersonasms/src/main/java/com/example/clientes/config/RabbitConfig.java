package com.example.clientes.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${rabbit.exchange.clientes}")
    private String exchange;

    @Value("${rabbit.queue.clientes}")
    private String queue;

    @Value("${rabbit.routing.clienteCreado}")
    private String routingKey;

    @Bean
    public TopicExchange exchangeClientes() { return new TopicExchange(exchange); }

    @Bean
    public Queue queueClientes() { return new Queue(queue, true); }

    @Bean
    public Binding bindingClientes(Queue queueClientes, TopicExchange exchangeClientes) {
        return BindingBuilder.bind(queueClientes).to(exchangeClientes).with(routingKey);
    }
}
