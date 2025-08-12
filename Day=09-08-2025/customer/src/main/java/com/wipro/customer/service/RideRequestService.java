package com.wipro.customer.service;

import com.wipro.customer.dto.RideRequestMessage;
import com.wipro.customer.entity.RideRequestEntity;

public interface RideRequestService {

    RideRequestEntity createNewRideRequest(RideRequestEntity rideRequest);

    void processUberBookingConfirmation(RideRequestMessage message);
}
