package org.xpertnauman.notification.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xpertnauman.clients.notification.request.NotificationRequest;
import org.xpertnauman.clients.notification.response.NotificationResponse;
import org.xpertnauman.notification.api.NotificationApi;
import org.xpertnauman.notification.service.NotificationService;

/**
 * Created on nauman.
 * Created on 12/10/2023.
 */
@Slf4j
@RestController
@RequestMapping("v1/notification")
public record NotificationController(NotificationService notificationService) implements NotificationApi
{
    @Override
    public NotificationResponse sendNotification(NotificationRequest request)
    {
        log.info("Received request for send notification: {}", request.toString());
        return notificationService.sendNotification(request);
    }
}
