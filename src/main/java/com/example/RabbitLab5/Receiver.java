package com.example.RabbitLab5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "SeleznevVA-fanout-queue-2111439")
    public void receiveMessageFromFanoutQueue(String message) {
        System.out.printf("Полученное сообщение из fanout очереди: %s\n", message);
    }

    @RabbitListener(queues = "SeleznevVA-direct-queue-2111439")
    public void receiveMessageFromDirectQueue(String message) {
        System.out.printf("Полученное сообщение из direct очереди: %s\n", message);
    }
}
