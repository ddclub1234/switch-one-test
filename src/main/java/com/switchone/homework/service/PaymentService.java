package com.switchone.homework.service;

import com.switchone.homework.dto.BalanceResponse;
import com.switchone.homework.dto.EstimateRequest;
import com.switchone.homework.dto.EstimateResponse;
import com.switchone.homework.entity.Merchant;
import com.switchone.homework.entity.Payment;
import com.switchone.homework.entity.PaymentUser;
import com.switchone.homework.repository.MerchantRepository;
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
    private final MerchantRepository merchantRepository;

    // 잔액 조회
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

    // 결제 예상 결과 조회
    public EstimateResponse getEstimate(EstimateRequest request){
        PaymentUser paymentUser = paymentUserRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자 ID " +request.getUserId()+ "은 존재하지 않는 아이디입니다."));
        Merchant merchant = merchantRepository.findById(request.getDestination())
                .orElseThrow(() -> new RuntimeException("상점 ID " +request.getDestination()+ "은 존재하지 않는 아이디입니다."));
        Double fees = (double) Math.round(merchant.getFeeRate() * request.getAmount() * 100) / 100;
        Double estimatedTotal = request.getAmount() + fees;

        return EstimateResponse.from(estimatedTotal, fees, request.getCurrency());
    }

}
