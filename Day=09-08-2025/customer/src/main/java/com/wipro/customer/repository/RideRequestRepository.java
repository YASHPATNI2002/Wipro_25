package com.wipro.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customer.entity.RideRequestEntity;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequestEntity, Integer> {

}
