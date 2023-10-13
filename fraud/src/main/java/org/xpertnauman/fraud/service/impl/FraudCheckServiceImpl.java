package org.xpertnauman.fraud.service.impl;

import org.xpertnauman.fraud.entity.FraudCheckHistory;
import org.xpertnauman.fraud.repository.FraudCheckHistoryRepository;
import org.xpertnauman.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xpertnauman.clients.fraud.response.FraudCheckResponse;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created on nauman.
 * Created on 11/10/2023.
 */
@Service
@AllArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService
{
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    @Override
    @Transactional
    public FraudCheckResponse isFraudulent(Long customerId)
    {
        final FraudCheckHistory fraudCheckHistory;
        Optional<FraudCheckHistory> fraudCheckHistoryOptional = fraudCheckHistoryRepository.findByCustomerId(customerId);
        if(fraudCheckHistoryOptional.isPresent())
        {
            fraudCheckHistory = fraudCheckHistoryOptional.get();
        }
        else
        {
            fraudCheckHistory = FraudCheckHistory.builder()
                    .customerId(customerId)
                    .isFraudster(false)
                    .createdAt(LocalDateTime.now())
                    .build();

            fraudCheckHistoryRepository.save(fraudCheckHistory);
        }

        return FraudCheckResponse.builder().isFraudster(fraudCheckHistory.isFraudster()).build();
    }
}
