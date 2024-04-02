package com.example.lab6;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class Listener {
    @RabbitListener(queues = "SeleznevVA-fanout-queue-2103829")
    public void receiveMessageFromFanoutQueue(String message) {
        System.out.printf("%s %s | Received from fanout queue: %s\n", LocalDate.now(), LocalTime.now(), message);
    }

    @RabbitListener(queues = "SeleznevVA-direct-queue-2103829")
    public void receiveMessageFromDirectQueue(String message) {
        System.out.printf("%s %s | Received from direct queue: %s\n", LocalDate.now(), LocalTime.now(), message);
    }
}
