package com.wipro.customer.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RideRequestMessage {
    private Integer id;
    private String customerName;
    private String fromLocation;
    private String toLocation;
    private String bookingId;       
    private boolean bookingConfirmed; 
    private LocalDateTime requestTimestamp;
}
