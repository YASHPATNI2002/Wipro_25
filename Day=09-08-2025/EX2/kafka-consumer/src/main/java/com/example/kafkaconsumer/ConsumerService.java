package com.example.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ConsumerService {

    private final List<String> messages = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        System.out.println("Received in Spring Consumer: " + message);
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
