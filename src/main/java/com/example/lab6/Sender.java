package com.example.lab6;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Sender implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private static final String directExchangeName = "SeleznevVA-direct-exchange-2111439";
    private static final String fanoutExchangeName = "SeleznevVA-fanout-exchange-2111439";
    private static final String routingKey = "1234";

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        int i = 0;
        while (true) {
            System.out.printf("Iteration %d: Sending message to fanout exchange...\n", i);
            rabbitTemplate.convertAndSend(fanoutExchangeName, "", "Fanout Exchange -> Seleznev V A 2103829 | Time: " + LocalTime.now());
            System.out.printf("Iteration %d: Sending message to direct exchange...\n", i);
            rabbitTemplate.convertAndSend(directExchangeName, routingKey, "Direct Exchange -> Seleznev V A 2103829 | Time: " + LocalTime.now());
            i++;
            Thread.sleep(10000);
        }
    }
}