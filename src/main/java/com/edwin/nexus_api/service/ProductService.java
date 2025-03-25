package com.edwin.nexus_api.service;

import com.edwin.nexus_api.DTO.ProductRequestDTO;
import com.edwin.nexus_api.model.Product;
import com.edwin.nexus_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductRequestDTO productRequest){
        Product product = new Product(
                null,
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getQuantity(),
                productRequest.getPrice(),
                null
        );
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts(Integer page, Integer limit){
        Pageable pageable = PageRequest.of(page,limit);
        return this.productRepository.findAll(pageable).getContent();
    }

    public Product getProductById(Integer productId){
        return this.productRepository.findById(productId).orElseThrow();
    }

    public List<Product> findByIds(List<Integer> ids){
        return this.productRepository.findByIdIn(ids);
    }
}
