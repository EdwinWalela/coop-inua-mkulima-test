package com.edwin.nexus_api.repository;

import com.edwin.nexus_api.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    public Optional<Payment> findByOrderId(Integer id);
}
