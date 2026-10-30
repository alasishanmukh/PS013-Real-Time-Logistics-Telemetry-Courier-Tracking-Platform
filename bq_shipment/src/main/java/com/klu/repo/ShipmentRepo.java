package com.klu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.Shipment;

public interface ShipmentRepo extends JpaRepository<Shipment, Long> {

    Shipment findByTrackingNumber(String trackingNumber);

}