package com.mreblan.postservice.kafka;

import com.mreblan.postservice.models.Post;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class KafkaProducerService {

    private KafkaTemplate<String, Long> kafkaTemplate;

    public void sendMessage(Post post) {
        kafkaTemplate.send("post-created-topic", "authorId", post.getAuthorId());
    }
}
