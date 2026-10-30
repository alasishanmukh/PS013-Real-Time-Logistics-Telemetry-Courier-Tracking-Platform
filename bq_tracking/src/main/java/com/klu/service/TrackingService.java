package com.klu.service;

import java.util.List;

import com.klu.entity.Tracking;

public interface TrackingService {

    Tracking addTracking(Tracking tracking);

    List<Tracking> getAllTracking();

    Tracking getTrackingById(Long id);

    List<Tracking> getTrackingByNumber(
            String trackingNumber);

    Tracking updateTracking(
            Long id,
            Tracking tracking);

    void deleteTracking(Long id);
}