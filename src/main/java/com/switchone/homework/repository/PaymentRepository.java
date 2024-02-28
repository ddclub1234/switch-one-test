package com.switchone.homework.repository;

import com.switchone.homework.entity.Payment;
import com.switchone.homework.entity.PaymentUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPaymentUser(PaymentUser paymentUser);
}
