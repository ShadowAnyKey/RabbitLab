package com.example.RabbitLab5;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
            System.out.printf("Итерация %d: Отправка соообщения в fanout обменник...\n", i);
            rabbitTemplate.convertAndSend(fanoutExchangeName, "", "Fanout обменник -> Seleznev V A 2111439");
            System.out.printf("Итерация %d: Отправка соообщения в direct обменник...\n", i);
            rabbitTemplate.convertAndSend(directExchangeName, routingKey, "Direct обменник -> Seleznev V A 2111439");
            i++;
            Thread.sleep(5000);
        }
    }
}