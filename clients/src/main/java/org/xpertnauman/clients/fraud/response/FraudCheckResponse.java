package org.xpertnauman.clients.fraud.response;

import lombok.Builder;

/**
 * Created on nauman.
 * Created on 11/10/2023.
 */
@Builder
public record FraudCheckResponse(boolean isFraudster)
{}
