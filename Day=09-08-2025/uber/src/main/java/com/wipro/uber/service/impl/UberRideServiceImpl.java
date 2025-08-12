package com.wipro.uber.service.impl;

import com.wipro.customer.dto.RideRequestMessage;
import com.wipro.uber.entity.RideRequestEntity;
import com.wipro.uber.repository.RideRequestRepository;
import com.wipro.uber.service.UberRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UberRideServiceImpl implements UberRideService {

    @Autowired
    private RideRequestRepository rideRequestRepository;

    @Autowired
    private KafkaTemplate<String, RideRequestMessage> kafkaTemplate;

    @Override
    public void processIncomingRideRequest(RideRequestMessage rideRequestMessage) {
        // Use the same ID from the incoming message
        RideRequestEntity entity = new RideRequestEntity();
        
        entity.setId(rideRequestMessage.getId());  // <-- set same ID here
        
        entity.setCustomerName(rideRequestMessage.getCustomerName());
        entity.setFromLocation(rideRequestMessage.getFromLocation());
        entity.setToLocation(rideRequestMessage.getToLocation());
        entity.setBookingConfirmed(false);
        entity.setBookingId(null);
        entity.setRequestTimestamp(rideRequestMessage.getRequestTimestamp());

        // Save entity with the same ID (you must remove @GeneratedValue from UberRideEntity id)
        RideRequestEntity savedEntity = rideRequestRepository.save(entity);

        // Simulate booking confirmation
        String bookingId = "UBERBOOKING-" + java.util.UUID.randomUUID();
        savedEntity.setBookingId(bookingId);
        savedEntity.setBookingConfirmed(true);

        rideRequestRepository.save(savedEntity);

        // Send confirmation message back with the same ID
        RideRequestMessage confirmationMessage = new RideRequestMessage();
        confirmationMessage.setId(savedEntity.getId());
        confirmationMessage.setCustomerName(savedEntity.getCustomerName());
        confirmationMessage.setFromLocation(savedEntity.getFromLocation());
        confirmationMessage.setToLocation(savedEntity.getToLocation());
        confirmationMessage.setBookingId(savedEntity.getBookingId());
        confirmationMessage.setBookingConfirmed(savedEntity.isBookingConfirmed());
        confirmationMessage.setRequestTimestamp(savedEntity.getRequestTimestamp());

        kafkaTemplate.send("UBER_TO_CUSTOMER", confirmationMessage);

    }
}
