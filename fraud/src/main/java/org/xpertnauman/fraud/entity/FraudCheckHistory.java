package org.xpertnauman.fraud.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

/**
 * Created on nauman.
 * Created on 11/10/2023.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory
{
    @Id
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
    private Integer id;
    private Long customerId;
    private boolean isFraudster;
    private LocalDateTime createdAt;
}
