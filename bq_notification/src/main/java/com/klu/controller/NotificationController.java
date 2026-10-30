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

import com.klu.entity.Notification;
import com.klu.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;


    public NotificationController(
            NotificationService notificationService) {

        this.notificationService = notificationService;
    }


    // CREATE
    @PostMapping
    public Notification createNotification(
            @RequestBody Notification notification) {

        return notificationService
                .createNotification(notification);
    }


    // GET ALL
    @GetMapping
    public List<Notification> getAllNotifications() {

        return notificationService
                .getAllNotifications();
    }


    // GET BY ID
    @GetMapping("/{id}")
    public Notification getNotificationById(
            @PathVariable Long id) {

        return notificationService
                .getNotificationById(id);
    }


    // GET BY TRACKING NUMBER
    @GetMapping("/tracking/{trackingNumber}")
    public List<Notification> getByTrackingNumber(
            @PathVariable String trackingNumber) {

        return notificationService
                .getByTrackingNumber(trackingNumber);
    }


    // GET BY RECIPIENT
    @GetMapping("/recipient/{recipient}")
    public List<Notification> getByRecipient(
            @PathVariable String recipient) {

        return notificationService
                .getByRecipient(recipient);
    }


    // UPDATE
    @PutMapping("/{id}")
    public Notification updateNotification(
            @PathVariable Long id,
            @RequestBody Notification notification) {

        return notificationService
                .updateNotification(id, notification);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public String deleteNotification(
            @PathVariable Long id) {

        notificationService
                .deleteNotification(id);

        return "Notification deleted successfully";
    }
}