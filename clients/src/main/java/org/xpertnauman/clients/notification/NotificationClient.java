package org.xpertnauman.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xpertnauman.clients.notification.request.NotificationRequest;
import org.xpertnauman.clients.notification.response.NotificationResponse;

/**
 * Created on nauman.
 * Created on 12/10/2023.
 */
@FeignClient(
        name = "notification",
        path = "v1/notification"
)
public interface NotificationClient
{
    @PostMapping(value = "send",
            produces = "application/json",
            consumes = "application/json")
    NotificationResponse sendNotification(@RequestBody NotificationRequest request);
}
