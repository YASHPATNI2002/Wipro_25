package com.wipro.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.producer.dto.Subject;
import com.wipro.producer.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private static final String TOPIC = "learn-subject";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(Subject subject) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(subject);
            kafkaTemplate.send(TOPIC, subject.getSubjectCode(), json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
}
