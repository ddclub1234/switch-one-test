package com.switchone.homework.controller;

import com.switchone.homework.dto.*;
import com.switchone.homework.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping(value = "/balance/{userId}")
    public BalanceResponse getBalance(@PathVariable Long userId){
        return paymentService.getBalance(userId);
    }

    @PostMapping(value = "/estimate")
    public EstimateResponse getEstimate(@Valid @RequestBody EstimateRequest request){
        return paymentService.getEstimate(request);
    }

    @PostMapping(value = "/approval")
    public ApprovalResponse registerApproval(@Valid @RequestBody ApprovalRequest request){
        return paymentService.registerApproval(request);
    }
}
