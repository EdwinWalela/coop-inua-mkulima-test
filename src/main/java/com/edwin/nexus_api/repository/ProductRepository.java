package com.edwin.nexus_api.repository;

import com.edwin.nexus_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByIdIn(List<Integer> ids);
}
