package com.wipro.uber.consumer;

import com.wipro.customer.dto.RideRequestMessage;  // Use customer DTO here
import com.wipro.uber.service.UberRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerRideRequestListener {

    @Autowired
    private UberRideService uberRideService;

    @KafkaListener(topics = "CUSTOMER_TO_UBER", groupId = "uber_group")
    public void listenRideRequest(RideRequestMessage rideRequestMessage) {
        System.out.println("Received ride request from customer: " + rideRequestMessage);
        uberRideService.processIncomingRideRequest(rideRequestMessage);  // UberRideService must accept customer DTO
    }
}
