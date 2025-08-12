package com.wipro.uber.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ride_requests")
@Data
public class RideRequestEntity {

    @Id
    private Integer id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "from_location")
    private String fromLocation;

    @Column(name = "to_location")
    private String toLocation;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "booking_confirmed")
    private boolean bookingConfirmed;

    @Column(name = "request_timestamp")
    private LocalDateTime requestTimestamp;
}
