package com.klu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.entity.Shipment;
import com.klu.repo.ShipmentRepo;
import com.klu.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepo shipmentRepo;


    public ShipmentServiceImpl(ShipmentRepo shipmentRepo) {

        this.shipmentRepo = shipmentRepo;
    }


    @Override
    public Shipment createShipment(Shipment shipment) {

        if (shipment.getStatus() == null ||
            shipment.getStatus().isEmpty()) {

            shipment.setStatus("BOOKED");
        }

        return shipmentRepo.save(shipment);
    }


    @Override
    public List<Shipment> getAllShipments() {

        return shipmentRepo.findAll();
    }


    @Override
    public Shipment getShipmentById(Long id) {

        return shipmentRepo.findById(id).orElse(null);
    }


    @Override
    public Shipment getShipmentByTrackingNumber(
            String trackingNumber) {

        return shipmentRepo
                .findByTrackingNumber(trackingNumber);
    }


    @Override
    public Shipment updateShipment(
            Long id,
            Shipment shipment) {

        Shipment existingShipment =
                shipmentRepo.findById(id).orElse(null);

        if (existingShipment != null) {

            existingShipment.setSenderName(
                    shipment.getSenderName());

            existingShipment.setReceiverName(
                    shipment.getReceiverName());

            existingShipment.setPickupLocation(
                    shipment.getPickupLocation());

            existingShipment.setDeliveryLocation(
                    shipment.getDeliveryLocation());

            existingShipment.setStatus(
                    shipment.getStatus());

            existingShipment.setCurrentLocation(
                    shipment.getCurrentLocation());

            return shipmentRepo.save(existingShipment);
        }

        return null;
    }


    @Override
    public void deleteShipment(Long id) {

        shipmentRepo.deleteById(id);
    }

}