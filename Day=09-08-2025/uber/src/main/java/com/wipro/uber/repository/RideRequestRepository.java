package com.wipro.uber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.uber.entity.RideRequestEntity;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequestEntity, Integer> {

}
