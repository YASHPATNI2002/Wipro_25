package com.wipro.customer.service.impl;

import com.wipro.customer.config.KafkaTopics;
import com.wipro.customer.dto.RideRequestMessage;
import com.wipro.customer.entity.RideRequestEntity;
import com.wipro.customer.repository.RideRequestRepository;
import com.wipro.customer.service.RideRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RideRequestServiceImpl implements RideRequestService {

    @Autowired
    private RideRequestRepository rideRequestRepository;

    @Autowired
    private KafkaTemplate<String, RideRequestMessage> kafkaTemplate;

    @Override
    public RideRequestEntity createNewRideRequest(RideRequestEntity rideRequest) {
        // Initialize booking info
        rideRequest.setBookingConfirmed(false);
        rideRequest.setBookingId(null);
        rideRequest.setRequestTimestamp(LocalDateTime.now());

        RideRequestEntity savedEntity = rideRequestRepository.save(rideRequest);

        // Build message to send via Kafka
        RideRequestMessage message = new RideRequestMessage();
        message.setId(savedEntity.getId());
        message.setCustomerName(savedEntity.getCustomerName());
        message.setFromLocation(savedEntity.getFromLocation());
        message.setToLocation(savedEntity.getToLocation());
        message.setBookingConfirmed(false);
        message.setBookingId(null);
        message.setRequestTimestamp(savedEntity.getRequestTimestamp());

        kafkaTemplate.send(KafkaTopics.CUSTOMER_TO_UBER_TOPIC, message);
        return savedEntity;
    }

    @Override
    public void processUberBookingConfirmation(RideRequestMessage message) {
        Optional<RideRequestEntity> optional = rideRequestRepository.findById(message.getId());
        if (optional.isPresent()) {
            RideRequestEntity entity = optional.get();
            entity.setBookingConfirmed(message.isBookingConfirmed());
            entity.setBookingId(message.getBookingId());
            rideRequestRepository.save(entity);
        } else {
            System.out.println("No matching ride request found with id: " + message.getId());
        }
    }
}
