package org.xpertnauman.fraud.controller;

import org.xpertnauman.fraud.api.FraudCheckApi;
import org.xpertnauman.fraud.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xpertnauman.clients.fraud.response.FraudCheckResponse;

@RestController
@RequestMapping("v1/fraud")
@Slf4j
public record FraudCheckHistoryController(
        FraudCheckService fraudCheckService) implements FraudCheckApi
{
    @Override
    public FraudCheckResponse checkIsFraudster(Long customerId)
    {
        log.info("check fraudster request {}", customerId);
        return fraudCheckService.isFraudulent(customerId);
    }
}
