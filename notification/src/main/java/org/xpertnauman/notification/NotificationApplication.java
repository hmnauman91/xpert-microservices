package org.xpertnauman.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
        (
                scanBasePackages = {
                        "org.xpertnauman.notification"

                }
        )
//@EnableEurekaClient
@EnableFeignClients(
        basePackages = "org.xpertnauman.clients"
)
@ConfigurationPropertiesScan
public class NotificationApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(NotificationApplication.class, args);
    }

    /*@Bean
    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
                                        NotificationConfiguration notificationConfiguration) {
        return args -> {
            producer.publish("foo",
                    notificationConfiguration.getTopicExchangeName(),
                    notificationConfiguration.getNotificationRoutingKey());
        };
    }*/
}