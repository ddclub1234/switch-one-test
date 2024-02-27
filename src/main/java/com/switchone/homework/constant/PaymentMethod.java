package com.switchone.homework.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {

    CREDIT_CARD("creditCard");

    private final String code;
}
