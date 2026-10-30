package com.klu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.Tracking;

public interface TrackingRepo
        extends JpaRepository<Tracking, Long> {

    List<Tracking> findByTrackingNumber(
            String trackingNumber);

}