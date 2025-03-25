package com.edwin.nexus_api.DTO;

import com.edwin.nexus_api.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Integer id;
    private String buyer;
    private Float total;
    private List<Product> products;
    private String paymentMethod;
    private Float paidAmount;
    private LocalDateTime createdAt;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, String buyer, Float total, List<Product> products, String paymentMethod, Float paidAmount, LocalDateTime createdAt) {
        this.id = id;
        this.buyer = buyer;
        this.total = total;
        this.products = products;
        this.paymentMethod = paymentMethod;
        this.paidAmount = paidAmount;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Float getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Float paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
