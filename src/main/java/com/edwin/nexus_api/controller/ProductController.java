package com.edwin.nexus_api.controller;

import com.edwin.nexus_api.DTO.ProductRequestDTO;
import com.edwin.nexus_api.model.Product;
import com.edwin.nexus_api.repository.ProductRepository;
import com.edwin.nexus_api.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO productRequest){
        Product product = this.productService.createProduct(productRequest);
        return ResponseEntity.ok(product);
    }

    @GetMapping("")
    ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer limit
    ){
        List<Product> products = this.productService.getAllProducts(page,limit);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Product product = this.productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
}
