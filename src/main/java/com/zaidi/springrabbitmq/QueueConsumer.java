package com.zaidi.springrabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload Message message) {
        message.getMessageProperties().getHeaders().forEach((k,v) -> System.out.println("Headers " + k + " value " + v));
        System.out.println("Message " + new String(message.getBody()));
    }

}
