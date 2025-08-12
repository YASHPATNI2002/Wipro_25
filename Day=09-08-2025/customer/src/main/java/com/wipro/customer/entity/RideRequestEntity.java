package com.wipro.customer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ride_requests")
@Data
public class RideRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "from_location")
    private String fromLocation;

    @Column(name = "to_location")
    private String toLocation;

    @Column(name = "booking_id")
    private String bookingId;  // null when request sent

    @Column(name = "booking_confirmed")
    private boolean bookingConfirmed; // false when request sent

    @Column(name = "request_timestamp")
    private LocalDateTime requestTimestamp;
}
