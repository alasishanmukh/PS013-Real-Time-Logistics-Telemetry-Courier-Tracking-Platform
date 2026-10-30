package com.klu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Shipment;
import com.klu.service.ShipmentService;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;


    public ShipmentController(
            ShipmentService shipmentService) {

        this.shipmentService = shipmentService;
    }


    // CREATE
    @PostMapping
    public Shipment createShipment(
            @RequestBody Shipment shipment) {

        return shipmentService
                .createShipment(shipment);
    }


    // GET ALL
    @GetMapping
    public List<Shipment> getAllShipments() {

        return shipmentService
                .getAllShipments();
    }


    // GET BY ID
    @GetMapping("/{id}")
    public Shipment getShipmentById(
            @PathVariable Long id) {

        return shipmentService
                .getShipmentById(id);
    }


    // GET BY TRACKING NUMBER
    @GetMapping("/track/{trackingNumber}")
    public Shipment getShipmentByTrackingNumber(
            @PathVariable String trackingNumber) {

        return shipmentService
                .getShipmentByTrackingNumber(
                        trackingNumber);
    }


    // UPDATE
    @PutMapping("/{id}")
    public Shipment updateShipment(
            @PathVariable Long id,
            @RequestBody Shipment shipment) {

        return shipmentService
                .updateShipment(id, shipment);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public String deleteShipment(
            @PathVariable Long id) {

        shipmentService.deleteShipment(id);

        return "Shipment deleted successfully";
    }

}