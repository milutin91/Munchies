package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    private String orderItemDescription;
    private int orderItemQuantity;
    private double orderItemPrice;
    private LocalDateTime orderItemCreated;
    private LocalDateTime orderItemUpdated;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

    @ManyToOne
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

    public String getOrderItemDescription() {
        return orderItemDescription;
    }

    public void setOrderItemDescription(String orderItemDescription) {
        this.orderItemDescription = orderItemDescription;
    }

    public int getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(int orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
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

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
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
                ", orderItemQuantity=" + orderItemQuantity +
                ", orderItemPrice=" + orderItemPrice +
                ", orderItemCreated=" + orderItemCreated +
                ", orderItemUpdated=" + orderItemUpdated +
                ", employeeEntity=" + employeeEntity +
                ", groupOrderEntity=" + groupOrderEntity +
                '}';
    }
}
