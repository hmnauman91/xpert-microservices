package org.xpertnauman.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig
{

    @Value("${rabbitmq.topic-exchanges.name}")
    private String topicExchangeName;

    @Value("${rabbitmq.routing-keys.name.notification}")
    private String notificationRoutingKey;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getTopicExchangeName()
    {
        return topicExchangeName;
    }

    public String getNotificationRoutingKey()
    {
        return notificationRoutingKey;
    }
}
