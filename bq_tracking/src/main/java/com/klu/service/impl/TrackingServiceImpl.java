package com.klu.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.entity.Tracking;
import com.klu.repo.TrackingRepo;
import com.klu.service.TrackingService;

@Service
public class TrackingServiceImpl
        implements TrackingService {

    private final TrackingRepo trackingRepo;


    public TrackingServiceImpl(
            TrackingRepo trackingRepo) {

        this.trackingRepo = trackingRepo;
    }


    @Override
    public Tracking addTracking(
            Tracking tracking) {

        if (tracking.getStatus() == null ||
            tracking.getStatus().isEmpty()) {

            tracking.setStatus("IN_TRANSIT");
        }

        if (tracking.getTimestamp() == null) {

            tracking.setTimestamp(
                    LocalDateTime.now());
        }

        return trackingRepo.save(tracking);
    }


    @Override
    public List<Tracking> getAllTracking() {

        return trackingRepo.findAll();
    }


    @Override
    public Tracking getTrackingById(Long id) {

        return trackingRepo
                .findById(id)
                .orElse(null);
    }


    @Override
    public List<Tracking> getTrackingByNumber(
            String trackingNumber) {

        return trackingRepo
                .findByTrackingNumber(trackingNumber);
    }


    @Override
    public Tracking updateTracking(
            Long id,
            Tracking tracking) {

        Tracking existing =
                trackingRepo
                .findById(id)
                .orElse(null);

        if (existing != null) {

            existing.setTrackingNumber(
                    tracking.getTrackingNumber());

            existing.setLocation(
                    tracking.getLocation());

            existing.setStatus(
                    tracking.getStatus());

            existing.setLatitude(
                    tracking.getLatitude());

            existing.setLongitude(
                    tracking.getLongitude());

            existing.setTimestamp(
                    tracking.getTimestamp());

            return trackingRepo.save(existing);
        }

        return null;
    }


    @Override
    public void deleteTracking(Long id) {

        trackingRepo.deleteById(id);
    }
}