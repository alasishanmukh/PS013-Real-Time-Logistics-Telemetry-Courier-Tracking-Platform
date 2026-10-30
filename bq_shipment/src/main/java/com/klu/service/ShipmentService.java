package com.klu.service;

import java.util.List;

import com.klu.entity.Shipment;

public interface ShipmentService {

    Shipment createShipment(Shipment shipment);

    List<Shipment> getAllShipments();

    Shipment getShipmentById(Long id);

    Shipment getShipmentByTrackingNumber(String trackingNumber);

    Shipment updateShipment(Long id, Shipment shipment);

    void deleteShipment(Long id);

}