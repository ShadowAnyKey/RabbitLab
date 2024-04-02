package com.example.lab6;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitDirect {

    final static String directExchangeName = "SeleznevVA-direct-exchange-2111439";
    final static String directQueueName = "SeleznevVA-direct-queue-2111439";
    final static String routingKey = "1234";

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchangeName);
    }

    @Bean
    Queue directQueue() {
        return new Queue(directQueueName, true);
    }

    @Bean
    Binding directBinding(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(routingKey);
    }
}
