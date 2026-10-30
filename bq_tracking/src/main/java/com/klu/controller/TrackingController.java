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

import com.klu.entity.Tracking;
import com.klu.service.TrackingService;

@RestController
@RequestMapping("/tracking")
public class TrackingController {

    private final TrackingService trackingService;


    public TrackingController(
            TrackingService trackingService) {

        this.trackingService = trackingService;
    }


    // ADD TRACKING
    @PostMapping
    public Tracking addTracking(
            @RequestBody Tracking tracking) {

        return trackingService
                .addTracking(tracking);
    }


    // GET ALL
    @GetMapping
    public List<Tracking> getAllTracking() {

        return trackingService
                .getAllTracking();
    }


    // GET BY ID
    @GetMapping("/{id}")
    public Tracking getTrackingById(
            @PathVariable Long id) {

        return trackingService
                .getTrackingById(id);
    }


    // GET BY TRACKING NUMBER
    @GetMapping("/shipment/{trackingNumber}")
    public List<Tracking> getTrackingByNumber(
            @PathVariable String trackingNumber) {

        return trackingService
                .getTrackingByNumber(
                        trackingNumber);
    }


    // UPDATE
    @PutMapping("/{id}")
    public Tracking updateTracking(
            @PathVariable Long id,
            @RequestBody Tracking tracking) {

        return trackingService
                .updateTracking(id, tracking);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public String deleteTracking(
            @PathVariable Long id) {

        trackingService.deleteTracking(id);

        return "Tracking record deleted successfully";
    }
}