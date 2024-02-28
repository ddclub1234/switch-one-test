package com.switchone.homework.service;

import com.switchone.homework.entity.Payment;
import com.switchone.homework.entity.PaymentUser;
import com.switchone.homework.repository.PaymentUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentUserService {

    private final PaymentUserRepository paymentUserRepository;

    public PaymentUser getPaymentUser(Long userId){
        return paymentUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자 ID " +userId+ "은 존재하지 않는 아이디입니다."));
    }
}
