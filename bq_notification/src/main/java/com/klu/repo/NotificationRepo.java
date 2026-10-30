package com.klu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.Notification;

public interface NotificationRepo
        extends JpaRepository<Notification, Long> {

    List<Notification> findByTrackingNumber(
            String trackingNumber);

    List<Notification> findByRecipient(
            String recipient);
}