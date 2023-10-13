package org.xpertnauman.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xpertnauman.customer.api.CustomerApi;
import org.xpertnauman.customer.model.request.CustomerRegistrationRequest;
import org.xpertnauman.customer.service.CustomerService;

/**
 * Created on nauman.
 * Created on 08/10/2023.
 */
@RestController
@RequestMapping("/v1/customer")
@Slf4j
public record CustomerController(CustomerService customerService) implements CustomerApi
{
    @Override
    public ResponseEntity<CustomerRegistrationRequest> register(CustomerRegistrationRequest request)
    {
        log.info("customer register request {}", request.toString());
        customerService.registerCustomer(request);
        return null;
    }
}
