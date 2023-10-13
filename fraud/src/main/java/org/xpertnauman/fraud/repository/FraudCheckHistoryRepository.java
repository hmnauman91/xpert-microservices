package org.xpertnauman.fraud.repository;

import org.xpertnauman.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer>
{
    Optional<FraudCheckHistory> findByCustomerId(Long customerId);
}
