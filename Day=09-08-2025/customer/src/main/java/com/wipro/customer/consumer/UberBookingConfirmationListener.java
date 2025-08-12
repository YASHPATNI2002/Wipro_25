package com.wipro.customer.consumer;

import com.wipro.customer.config.KafkaTopics;
import com.wipro.customer.dto.RideRequestMessage;
import com.wipro.customer.service.RideRequestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UberBookingConfirmationListener {

    private static final Logger logger = LoggerFactory.getLogger(UberBookingConfirmationListener.class);

    @Autowired
    private RideRequestService rideRequestService;

    @KafkaListener(topics = KafkaTopics.UBER_TO_CUSTOMER_TOPIC, groupId = "customer_group")
    public void listenBookingConfirmation(RideRequestMessage message) {
        logger.info("Listener started processing message: {}", message);
        System.out.println("Received booking confirmation from Uber: " + message);
        System.out.flush();

        rideRequestService.processUberBookingConfirmation(message);

        logger.info("Listener finished processing message.");
        System.out.println("DEBUG: Processed booking confirmation");
        System.out.flush();
    }
}

