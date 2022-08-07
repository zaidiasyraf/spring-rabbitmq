package com.zaidi.springrabbitmq;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
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

    public void sendWithRouting(String msg) {
        rabbitTemplate.convertAndSend("test-exchange", "test-routing", msg);
    }

    public void sendWithRoutingAndHeader(String msg, Map<String, String> header) {
        MessageProperties messageProperties = new MessageProperties();
        header.forEach(messageProperties::setHeader);
        Message message = new Message(msg.getBytes(StandardCharsets.UTF_8), messageProperties);
        rabbitTemplate.convertAndSend("test-exchange", "test-routing", message);
    }

}
