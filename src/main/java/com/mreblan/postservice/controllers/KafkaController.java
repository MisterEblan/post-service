package com.mreblan.postservice.controllers;

import com.mreblan.postservice.kafka.KafkaProducerService;
import com.mreblan.postservice.models.Post;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaProducerService producerService;

    @PostMapping("/message")
    public void sendMessageToKafka(@RequestBody Post post) {
        producerService.sendMessage(post);
    }
}
