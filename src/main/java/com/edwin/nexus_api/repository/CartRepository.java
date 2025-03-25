package com.edwin.nexus_api.repository;

import com.edwin.nexus_api.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    public List<Cart> findByUserId(Integer userId);
}
