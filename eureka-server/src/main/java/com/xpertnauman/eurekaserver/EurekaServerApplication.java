package com.xpertnauman.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created on nauman.
 * Created on 11/10/2023.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
