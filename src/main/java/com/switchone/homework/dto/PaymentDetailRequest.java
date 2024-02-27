package com.switchone.homework.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailRequest {
    @NotNull
    @Pattern(regexp = "/^[0-9]{4}[-\\s\\.]?[0-9]{4}[-\\s\\.]?[0-9]{4}[-\\s\\.]?[0-9]{4}$/")
    private String cardNumber;
    @NotNull
    @Pattern(regexp = "/^(0[1-9]|1[012])\\/\\d{2}$/")
    private String expireDate;
    @NotNull
    @Pattern(regexp = "/^[0-9]{3}$/")
    private String cvv;
}
