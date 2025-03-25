package com.edwin.nexus_api.DTO;

import com.edwin.nexus_api.model.PaymentMethod;

import java.util.List;

public class OrderRequestDTO {
    private String buyerName;
    private List<Integer> productIds;
    private PaymentMethod paymentMethod;
    private Float amount;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(String buyerName, List<Integer> productIds, PaymentMethod paymentMethod, Float amount) {
        this.buyerName = buyerName;
        this.productIds = productIds;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
