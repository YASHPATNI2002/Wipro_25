package com.wipro.consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.consumer.dto.Subject;

@Component
public class StockConsumer {

	@KafkaListener(topics = "learn-subject", groupId = "my-group")
    public void consume(String message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Subject subject = mapper.readValue(message, Subject.class);
            System.out.println("Consumed Subject: " + subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
