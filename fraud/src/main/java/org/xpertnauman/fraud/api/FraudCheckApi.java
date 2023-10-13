package org.xpertnauman.fraud.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.xpertnauman.clients.fraud.response.FraudCheckResponse;

public interface FraudCheckApi
{
    @GetMapping(value = "check/{customerId}")
    FraudCheckResponse checkIsFraudster(@PathVariable Long customerId);
}
