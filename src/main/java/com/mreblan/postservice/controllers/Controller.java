package com.mreblan.postservice.controllers;

import com.mreblan.postservice.kafka.KafkaProducer;
import com.mreblan.postservice.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Controller {

    private final KafkaProducer kafkaProducer;
    private final PostRepository postRepository;

    @PostMapping("kafka/send")
    public String send(@RequestParam Long id) {
        var post = postRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("NOT FOUND"));

        kafkaProducer.sendMessage(post.toString());

        return "Success";
    }
}
