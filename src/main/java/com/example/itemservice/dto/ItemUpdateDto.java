package com.example.itemservice.dto;

import jakarta.validation.constraints.Min;

public class ItemUpdateDto {

    @Min(value = 0, message = "Quantity must be zero or greater")
    private int quantity;

    public ItemUpdateDto(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

