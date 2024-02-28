package com.switchone.homework.dto;

import com.switchone.homework.constant.Currency;
import com.switchone.homework.constant.Status;
import com.switchone.homework.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalResponse {
    private Long paymentId;
    private String status;
    private Double amount;
    private Currency currency;
    private LocalDateTime timestamp;

    public static ApprovalResponse from(Payment payment){
        return ApprovalResponse.builder()
                .paymentId(payment.getId())
                .status(Status.APPROVED.getDesc())
                .amount(payment.getApproveAmount())
                .currency(payment.getCurrency())
                .timestamp(payment.getApproveDatetime())
                .build();
    }
}
