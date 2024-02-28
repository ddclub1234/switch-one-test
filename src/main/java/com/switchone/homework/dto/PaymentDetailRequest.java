package com.switchone.homework.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailRequest {
    @NotNull
    private String cardNumber;
    @NotNull
    private String expireDate;
    @NotNull
    private String cvv;
}
