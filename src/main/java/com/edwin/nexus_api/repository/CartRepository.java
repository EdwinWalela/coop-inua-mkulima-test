package com.edwin.nexus_api.repository;

import com.edwin.nexus_api.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
