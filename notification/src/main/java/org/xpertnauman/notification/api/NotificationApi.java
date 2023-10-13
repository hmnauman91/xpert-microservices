package org.xpertnauman.notification.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xpertnauman.clients.notification.request.NotificationRequest;
import org.xpertnauman.clients.notification.response.NotificationResponse;

public interface NotificationApi
{
    @PostMapping(value = "send",
            produces = "application/json",
            consumes = "application/json")
    NotificationResponse sendNotification(@RequestBody NotificationRequest request);
}
