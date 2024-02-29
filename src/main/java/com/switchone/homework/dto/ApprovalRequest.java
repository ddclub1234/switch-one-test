package com.switchone.homework.dto;

import com.switchone.homework.constant.Currency;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
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
    @NotBlank
    private String paymentMethod;
    @NotNull
    @Valid
    private PaymentDetailRequest paymentDetails;
}
