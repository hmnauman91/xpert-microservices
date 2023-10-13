package org.xpertnauman.notification.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xpertnauman.clients.notification.request.NotificationRequest;
import org.xpertnauman.clients.notification.response.NotificationResponse;
import org.xpertnauman.notification.entity.Notification;
import org.xpertnauman.notification.repository.NotificationRepository;
import org.xpertnauman.notification.service.NotificationService;

import java.time.LocalDateTime;

/**
 * Created on nauman.
 * Created on 12/10/2023.
 */
@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService
{
    private final NotificationRepository notificationRepository;
    @Override
    public NotificationResponse sendNotification(NotificationRequest notificationRequest) {

        Notification notification = Notification.builder()
                .message(notificationRequest.message())
                .sender(notificationRequest.sender())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .toCustomerId(notificationRequest.toCustomerId())
                .sentAt(LocalDateTime.now())
                .build();

        notificationRepository.save(notification);
        log.info("notification sent successfully: {}", notification);
        return NotificationResponse.builder()
                .isSent(true)
                .build();
    }
}
