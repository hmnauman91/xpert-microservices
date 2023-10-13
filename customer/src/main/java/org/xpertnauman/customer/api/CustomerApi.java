package org.xpertnauman.customer.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xpertnauman.customer.model.request.CustomerRegistrationRequest;

public interface CustomerApi
{
    @PostMapping(value = "/register",
            produces = "application/json",
            consumes = "application/json")
    ResponseEntity<CustomerRegistrationRequest> register(@RequestBody CustomerRegistrationRequest model);
}
