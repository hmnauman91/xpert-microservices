package org.xpertnauman.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "org.xpertnauman.customer"
        }
)
//@EnableEurekaClient
@EnableFeignClients(
        basePackages = "org.xpertnauman.clients"
)
public class CustomerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CustomerApplication.class, args);
    }
}