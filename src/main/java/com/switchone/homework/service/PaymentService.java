package com.switchone.homework.service;

import com.switchone.homework.dto.BalanceResponse;
import com.switchone.homework.entity.Payment;
import com.switchone.homework.entity.PaymentUser;
import com.switchone.homework.repository.PaymentRepository;
import com.switchone.homework.repository.PaymentUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentUserRepository paymentUserRepository;
    private final PaymentRepository paymentRepository;

    //잔액 조회
    public BalanceResponse getBalance(Long userId){
       PaymentUser paymentUser = paymentUserRepository.findById(userId).orElseThrow(() -> new RuntimeException("사용자 ID " +userId+ "은 존재하지 않는 아이디입니다."));
       List<Payment> payments = paymentRepository.findByPaymentUser(paymentUser);
       Double balance = paymentUser.getLimitAmount();
       // 한도액에서 결제가 완료된 거래들을 조회하여 잔액을 계산한다.
       if(!CollectionUtils.isEmpty(payments)){
           for(Payment payment : payments){
               balance -= payment.getApproveAmount();
           }
       }
       return BalanceResponse.from(paymentUser, balance);
    }
}
