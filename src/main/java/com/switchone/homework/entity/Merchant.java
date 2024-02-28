package com.switchone.homework.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "merchant")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fee_rate", nullable = false)
    private Float feeRate;
}
