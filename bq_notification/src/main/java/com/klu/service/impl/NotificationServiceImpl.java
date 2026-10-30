package com.klu.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.entity.Notification;
import com.klu.repo.NotificationRepo;
import com.klu.service.NotificationService;

@Service
public class NotificationServiceImpl
        implements NotificationService {

    private final NotificationRepo notificationRepo;


    public NotificationServiceImpl(
            NotificationRepo notificationRepo) {

        this.notificationRepo = notificationRepo;
    }


    @Override
    public Notification createNotification(
            Notification notification) {

        if (notification.getStatus() == null ||
            notification.getStatus().isEmpty()) {

            notification.setStatus("PENDING");
        }

        if (notification.getType() == null ||
            notification.getType().isEmpty()) {

            notification.setType("SMS");
        }

        if (notification.getCreatedAt() == null) {

            notification.setCreatedAt(
                    LocalDateTime.now());
        }

        return notificationRepo.save(notification);
    }


    @Override
    public List<Notification> getAllNotifications() {

        return notificationRepo.findAll();
    }


    @Override
    public Notification getNotificationById(
            Long id) {

        return notificationRepo
                .findById(id)
                .orElse(null);
    }


    @Override
    public List<Notification> getByTrackingNumber(
            String trackingNumber) {

        return notificationRepo
                .findByTrackingNumber(trackingNumber);
    }


    @Override
    public List<Notification> getByRecipient(
            String recipient) {

        return notificationRepo
                .findByRecipient(recipient);
    }


    @Override
    public Notification updateNotification(
            Long id,
            Notification notification) {

        Notification existing =
                notificationRepo
                .findById(id)
                .orElse(null);

        if (existing != null) {

            existing.setTrackingNumber(
                    notification.getTrackingNumber());

            existing.setRecipient(
                    notification.getRecipient());

            existing.setMessage(
                    notification.getMessage());

            existing.setType(
                    notification.getType());

            existing.setStatus(
                    notification.getStatus());

            return notificationRepo.save(existing);
        }

        return null;
    }


    @Override
    public void deleteNotification(Long id) {

        notificationRepo.deleteById(id);
    }
}