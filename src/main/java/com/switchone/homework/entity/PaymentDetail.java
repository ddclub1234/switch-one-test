package com.switchone.homework.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_detail")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "expiry_date", nullable = false)
    private String expiryDate;

    @Column(name = "cvv", nullable = false)
    private String cvv;

}
