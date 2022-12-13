package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    private String orderItemEmployeeName;
    private String orderItemDescription;
    private double orderItemPrice;
    private LocalDateTime orderItemCreated;
    private LocalDateTime orderItemUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_order_id")
    private GroupOrderEntity groupOrderEntity;

    public OrderItemEntity() {
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
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

    public LocalDateTime getOrderItemCreated() {
        return orderItemCreated;
    }

    public void setOrderItemCreated(LocalDateTime orderItemCreated) {
        this.orderItemCreated = orderItemCreated;
    }

    public LocalDateTime getOrderItemUpdated() {
        return orderItemUpdated;
    }

    public void setOrderItemUpdated(LocalDateTime orderItemUpdated) {
        this.orderItemUpdated = orderItemUpdated;
    }

    public GroupOrderEntity getGroupOrderEntity() {
        return groupOrderEntity;
    }

    public void setGroupOrderEntity(GroupOrderEntity groupOrderEntity) {
        this.groupOrderEntity = groupOrderEntity;
    }

    @Override
    public String toString() {
        return "OrderItemEntity{" +
                "orderItemID=" + orderItemId +
                ", orderItemDescription='" + orderItemDescription + '\'' +
                ", orderItemPrice=" + orderItemPrice +
                ", orderItemCreated=" + orderItemCreated +
                ", orderItemUpdated=" + orderItemUpdated +
                ", groupOrderEntity=" + groupOrderEntity +
                '}';
    }
}
