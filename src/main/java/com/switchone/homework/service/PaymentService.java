package com.switchone.homework.service;

import com.switchone.homework.dto.*;
import com.switchone.homework.entity.Merchant;
import com.switchone.homework.entity.Payment;
import com.switchone.homework.entity.PaymentDetail;
import com.switchone.homework.entity.PaymentUser;
import com.switchone.homework.repository.PaymentDetailRepository;
import com.switchone.homework.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentUserService paymentUserService;
    private final MerchantService merchantService;

    private final PaymentRepository paymentRepository;
    private final PaymentDetailRepository paymentDetailRepository;

    // 잔액 조회
    public BalanceResponse getBalance(Long userId){
       PaymentUser paymentUser = paymentUserService.getPaymentUser(userId);
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
        PaymentUser paymentUser = paymentUserService.getPaymentUser(request.getUserId());
        Merchant merchant = merchantService.getMerchant(request.getDestination());
        Double fees = (double) Math.round(merchant.getFeeRate() * request.getAmount() * 100) / 100;
        Double estimatedTotal = request.getAmount() + fees;
        return EstimateResponse.from(estimatedTotal, fees, request.getCurrency());
    }

    // 결제 승인 요청
    public ApprovalResponse registerApproval(ApprovalRequest request){
        PaymentUser paymentUser = paymentUserService.getPaymentUser(request.getUserId());
        Merchant merchant = merchantService.getMerchant(request.getMerchantId());
        Payment payment = paymentRepository.save(Payment.from(paymentUser, merchant, request));
        PaymentDetail paymentDetail = paymentDetailRepository.save(PaymentDetail.from(payment, request));
        return ApprovalResponse.from(payment);
    }
}
