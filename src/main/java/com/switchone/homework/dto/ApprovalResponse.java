package com.switchone.homework.dto;

import com.switchone.homework.constant.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalResponse {
    private Long paymentId;
    private String status;
    private Double amount;
    private Currency currency;
    private LocalDateTime timestamp;
}
