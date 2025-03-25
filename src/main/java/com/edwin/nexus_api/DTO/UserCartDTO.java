package com.edwin.nexus_api.DTO;

import java.util.List;

public class UserCartDTO {
    private List<CartItemDTO> items;
    private Float totalAmount;

    public UserCartDTO() {
    }

    public UserCartDTO(List<CartItemDTO> items, Float totalAmount) {
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
