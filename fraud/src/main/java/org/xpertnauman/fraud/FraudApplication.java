package org.xpertnauman.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created on nauman.
 * Created on 11/10/2023.
 */
@SpringBootApplication
        (
                scanBasePackages = {
                        "org.xpertnauman.fraud",
                        "org.xpertnauman.clients"
                }
        )
@EnableEurekaClient
public class FraudApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(FraudApplication.class, args);
    }
}
