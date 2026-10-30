package com.klu.service;

import java.util.List;

import com.klu.entity.Notification;

public interface NotificationService {

    Notification createNotification(
            Notification notification);

    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    List<Notification> getByTrackingNumber(
            String trackingNumber);

    List<Notification> getByRecipient(
            String recipient);

    Notification updateNotification(
            Long id,
            Notification notification);

    void deleteNotification(Long id);
}