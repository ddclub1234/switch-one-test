package com.switchone.homework.controller;

import com.switchone.homework.dto.BalanceResponse;
import com.switchone.homework.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping(value = "/balance/{userId}")
    public BalanceResponse getBalance(@PathVariable Long userId){
        return paymentService.getBalance(userId);
    }
}
