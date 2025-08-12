package com.wipro.customer.controller;

import com.wipro.customer.entity.RideRequestEntity;
import com.wipro.customer.service.RideRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideRequestController {

    @Autowired
    private RideRequestService rideRequestService;

    @PostMapping("/request")
    public RideRequestEntity createRideRequest(@RequestBody RideRequestEntity rideRequest) {
        return rideRequestService.createNewRideRequest(rideRequest);
    }
}
