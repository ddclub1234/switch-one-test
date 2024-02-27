package com.switchone.homework.dto;

import com.switchone.homework.constant.Currency;
import com.switchone.homework.constant.PaymentMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Double amount;
    @NotNull
    private Currency currency;
    @NotNull
    private Long merchantId;
    @NotNull
    private PaymentMethod paymentMethod;
    @NotNull
    @Valid
    private PaymentDetailRequest paymentDetails;
}
