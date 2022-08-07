package com.zaidi.springrabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class QueueSender {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public QueueSender(final RabbitTemplate rabbitTemplate, final Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void send(String msg) {
        rabbitTemplate.convertAndSend(queue.getName(), msg);
    }

}
