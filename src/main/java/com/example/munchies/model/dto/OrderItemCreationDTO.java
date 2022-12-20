package com.example.munchies.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class OrderItemCreationDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 55, message = "Name must be between 1 and 55 characters")
    private String orderItemEmployeeName;
    @NotBlank(message = "Item name is mandatory")
    @Size(min = 1, max = 55, message = "Item name must be between 1 and 55 characters")
    private String orderItemDescription;
    @Positive(message = "Price must be positive number")
    private double orderItemPrice;

    public OrderItemCreationDTO() {
    }

    public String getOrderItemEmployeeName() {
        return orderItemEmployeeName;
    }

    public void setOrderItemEmployeeName(String orderItemEmployeeName) {
        this.orderItemEmployeeName = orderItemEmployeeName;
    }

    public String getOrderItemDescription() {
        return orderItemDescription;
    }

    public void setOrderItemDescription(String orderItemDescription) {
        this.orderItemDescription = orderItemDescription;
    }

    public double getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(double orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    @Override
    public String toString() {
        return "OrderItemCreationDTO{" +
                "orderItemEmployeeName='" + orderItemEmployeeName + '\'' +
                ", orderItemDescription='" + orderItemDescription + '\'' +
                ", orderItemPrice='" + orderItemPrice + '\'' +
                '}';
    }
}
