package com.example.kafkaproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean; // ✅ Import added
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    private String topic;

    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public String publish(@RequestParam String message) {
        kafkaTemplate.send(topic, message);
        return "Published: " + message;
    }

    // Optional: send two messages on startup
    @Bean
    public CommandLineRunner sendOnStart() {
        return args -> {
            kafkaTemplate.send(topic, "Spring Boot");
            kafkaTemplate.send(topic, "Angular");
        };
    }
}
