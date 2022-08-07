package com.zaidi.springrabbitmq;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/route")
    public void sendWithRouting(@RequestParam String msg) {
        queueSender.sendWithRouting(msg);
    }

    @PostMapping("/route/header")
    public void sendWithRoutingWithHeader(@RequestParam String msg, @RequestBody Map<String, String> header) {
        queueSender.sendWithRoutingAndHeader(msg, header);
    }


}
