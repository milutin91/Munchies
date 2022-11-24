package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private int orderItemID;
    @Column(name = "order_item_description")
    private String orderItemDescription;
    @Column(name = "order_item_quantity")
    private int orderItemQuantity;
    @Column(name = "order_item_price")
    private double orderItemPrice;
    @Column(name = "order_item_created")
    private LocalDateTime orderItemCreated;
    @Column(name = "order_item_updated")
    private LocalDateTime orderItemUpdated;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

    @ManyToOne
    @JoinColumn(name = "group_order_id")
    private GroupOrderEntity groupOrderEntity;

    public OrderItemEntity() {
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
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

    @Override
    public String toString() {
        return "OrderItemEntity{" +
                "orderItemID=" + orderItemID +
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
