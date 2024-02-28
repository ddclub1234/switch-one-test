package com.switchone.homework.entity;

import com.switchone.homework.constant.Currency;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @Column(name = "limit_amount", nullable = false)
    private Double limitAmount;
}
