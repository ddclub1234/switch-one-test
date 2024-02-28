package com.switchone.homework.entity;

import com.switchone.homework.constant.Currency;
import com.switchone.homework.dto.ApprovalRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private PaymentUser paymentUser;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @Column(name = "approve_amount", nullable = false)
    private Double approveAmount;

    @Column(name = "approve_datetime", nullable = false)
    private LocalDateTime approveDatetime;

    public static Payment from(PaymentUser paymentUser, Merchant merchant, ApprovalRequest request){
        return Payment.builder()
                .paymentUser(paymentUser)
                .merchant(merchant)
                .currency(request.getCurrency())
                .approveAmount(request.getAmount())
                .approveDatetime(LocalDateTime.now())
                .build();
    }

}
