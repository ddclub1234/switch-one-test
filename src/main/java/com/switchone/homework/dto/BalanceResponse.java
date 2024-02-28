package com.switchone.homework.dto;

import com.switchone.homework.constant.Currency;
import com.switchone.homework.entity.PaymentUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceResponse {
    private Long userId;
    private Double balance;
    private Currency currency;

    public static BalanceResponse from(PaymentUser paymentUser, Double balance){
        return BalanceResponse.builder()
                .userId(paymentUser.getId())
                .balance(balance)
                .currency(paymentUser.getCurrency())
                .build();
    }
}
