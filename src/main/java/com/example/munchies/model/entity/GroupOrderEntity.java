package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "group_order")
public class GroupOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_order_id")
    private int groupOrderID;
    @Column(name = "group_order_created")
    private LocalDateTime groupOrderCreated;
    @Column(name = "group_order_updated")
    private LocalDateTime groupOrderUpdate;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

    @OneToMany(mappedBy = "groupOrderEntity")
    private List<OrderItemEntity> orderItems;

    public GroupOrderEntity() {
    }

    public int getGroupOrderID() {
        return groupOrderID;
    }

    public void setGroupOrderID(int groupOrderID) {
        this.groupOrderID = groupOrderID;
    }

    public LocalDateTime getGroupOrderCreated() {
        return groupOrderCreated;
    }

    public void setGroupOrderCreated(LocalDateTime groupOrderCreated) {
        this.groupOrderCreated = groupOrderCreated;
    }

    public LocalDateTime getGroupOrderUpdate() {
        return groupOrderUpdate;
    }

    public void setGroupOrderUpdate(LocalDateTime groupOrderUpdate) {
        this.groupOrderUpdate = groupOrderUpdate;
    }

    public RestaurantEntity getRestaurantEntity() {
        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "GroupOrderEntity{" +
                "groupOrderID=" + groupOrderID +
                ", groupOrderCreated=" + groupOrderCreated +
                ", groupOrderUpdate=" + groupOrderUpdate +
                ", restaurantEntity=" + restaurantEntity +
                ", employeeEntity=" + employeeEntity +
                '}';
    }
}
