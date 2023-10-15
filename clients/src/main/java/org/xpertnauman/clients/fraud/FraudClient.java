package org.xpertnauman.clients.fraud;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.xpertnauman.clients.fraud.response.FraudCheckResponse;

@FeignClient(
        url = "${FRAUD_SERVICE_URL:http://localhost:8081}",
        value = "fraud",
        path = "v1/fraud")
public interface FraudClient
{
    @GetMapping(value = "check/{customerId}")
    FraudCheckResponse  checkIsFraudster(@PathVariable("customerId") Long customerId);
}
