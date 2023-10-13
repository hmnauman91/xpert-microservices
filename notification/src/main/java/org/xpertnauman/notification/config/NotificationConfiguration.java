package org.xpertnauman.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on nauman.
 * Created on 13/10/2023.
 */
@Configuration
public class NotificationConfiguration
{
    @Value("${rabbitmq.topic-exchanges.name}")
    private String topicExchangeName;

    @Value("${rabbitmq.queues.name.notification}")
    private String notificationQueueName;

    @Value("${rabbitmq.routing-keys.name.notification}")
    private String notificationRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange()
    {
        return new TopicExchange(this.topicExchangeName);
    }

    @Bean
    public Queue notificationQueue()
    {
        return new Queue(this.notificationQueueName);
    }

    @Bean
    public Binding internalToNotificationQueue()
    {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchange())
                .with(this.notificationRoutingKey);
    }

    public String getTopicExchangeName()
    {
        return topicExchangeName;
    }

    public String getNotificationQueueName()
    {
        return notificationQueueName;
    }

    public String getNotificationRoutingKey()
    {
        return notificationRoutingKey;
    }
}
