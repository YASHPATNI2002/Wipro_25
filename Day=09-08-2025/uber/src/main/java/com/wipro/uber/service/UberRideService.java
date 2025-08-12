// UberRideService.java
package com.wipro.uber.service;

import com.wipro.customer.dto.RideRequestMessage;

public interface UberRideService {
    void processIncomingRideRequest(RideRequestMessage rideRequestMessage);  // Accept customer DTO
}
