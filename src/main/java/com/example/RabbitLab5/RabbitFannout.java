package com.example.RabbitLab5;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFannout {

    final static String fanoutExchange = "SeleznevVA-fanout-exchange-2111439";
    final static String fanoutQueue = "SeleznevVA-fanout-queue-2111439";

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    Queue fanoutQueue() {
        return new Queue(fanoutQueue, true);
    }

    @Bean
    Binding fanoutBinding(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }
}
