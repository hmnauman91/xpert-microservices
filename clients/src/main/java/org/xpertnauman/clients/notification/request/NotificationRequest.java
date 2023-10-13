package org.xpertnauman.clients.notification.request;

import lombok.Builder;

@Builder
public record NotificationRequest(
        String message,
        String sender,
        String toCustomerEmail,
        Long toCustomerId
)
{
}
