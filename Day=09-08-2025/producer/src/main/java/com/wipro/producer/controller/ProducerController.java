package com.wipro.producer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.producer.dto.Subject;
import com.wipro.producer.service.MessageService;

@RestController
public class ProducerController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public String sendSubject(@RequestBody Subject subject) {
        messageService.sendMessage(subject);
        return "Subject sent: " + subject.toString();
    }
}
