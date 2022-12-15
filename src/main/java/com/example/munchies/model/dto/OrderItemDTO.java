package com.example.munchies.model.dto;

import com.example.munchies.model.entity.GroupOrderEntity;

public class OrderItemDTO {
    private String orderItemEmployeeName;
    private String orderItemDescription;
    private double orderItemPrice;
    private GroupOrderEntity groupOrderEntity;

    public OrderItemDTO() {
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

    public GroupOrderEntity getGroupOrderEntity() {
        return groupOrderEntity;
    }

    public void setGroupOrderEntity(GroupOrderEntity groupOrderEntity) {
        this.groupOrderEntity = groupOrderEntity;
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
