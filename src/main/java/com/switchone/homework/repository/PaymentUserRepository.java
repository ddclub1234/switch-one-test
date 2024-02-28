package com.switchone.homework.repository;

import com.switchone.homework.entity.PaymentUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentUserRepository extends JpaRepository<PaymentUser, Long> {
}
