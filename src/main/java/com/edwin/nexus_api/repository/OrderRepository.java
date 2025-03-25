package com.edwin.nexus_api.repository;

import com.edwin.nexus_api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
