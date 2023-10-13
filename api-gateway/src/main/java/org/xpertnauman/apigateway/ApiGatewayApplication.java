package org.xpertnauman.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created on nauman.
 * Created on 12/10/2023.
 */
@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
