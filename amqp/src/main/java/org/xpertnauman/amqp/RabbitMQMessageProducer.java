package org.xpertnauman.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * Created on nauman.
 * Created on 13/10/2023.
 */
@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQMessageProducer
{
    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey)
    {
        log.info("Publishing {}, with routing key: {} and payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published {}, with routing key: {} and payload: {}", exchange, routingKey, payload);
    }

}
