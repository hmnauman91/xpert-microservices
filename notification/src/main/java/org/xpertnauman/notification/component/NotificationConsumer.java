package org.xpertnauman.notification.component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.xpertnauman.clients.notification.request.NotificationRequest;
import org.xpertnauman.notification.service.NotificationService;

/**
 * Created on nauman.
 * Created on 13/10/2023.
 */
@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer
{
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.name.notification}")
    public void consume(NotificationRequest notificationRequest)
    {
        log.info("Received Notification..");
        notificationService.sendNotification(notificationRequest);
    }
}
