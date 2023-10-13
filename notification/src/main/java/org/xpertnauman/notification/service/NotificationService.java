package org.xpertnauman.notification.service;

import org.xpertnauman.clients.notification.request.NotificationRequest;
import org.xpertnauman.clients.notification.response.NotificationResponse;

public interface NotificationService
{
    NotificationResponse sendNotification(NotificationRequest notificationRequest);
}
