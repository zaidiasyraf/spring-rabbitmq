package com.zaidi.springrabbitmq;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private final QueueSender queueSender;

    public QueueController(final QueueSender queueSender) {
        this.queueSender = queueSender;
    }

    @PostMapping()
    public void send(@RequestParam String msg) {
        queueSender.send(msg);
    }

}
