package com.example.itemservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ItemDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 0, message = "Quantity must be zero or greater")
    private int quantity;

    @NotBlank(message = "Unity is required")
    private String unity;

    public ItemDto(String name, int quantity, String unity) {
        this.name = name;
        this.quantity = quantity;
        this.unity = unity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
}
