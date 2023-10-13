package org.xpertnauman.fraud.service;


import org.xpertnauman.clients.fraud.response.FraudCheckResponse;

public interface FraudCheckService
{
    FraudCheckResponse isFraudulent(Long customerId);
}
