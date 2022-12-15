package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "group_order")
public class GroupOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupOrderId;
    private int groupOrderTimeout;
    private String groupOrderEmployeeName;
    private LocalDateTime groupOrderCreated;
    private LocalDateTime groupOrderUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;

    @OneToMany(mappedBy = "groupOrderEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> orderItems;

    public GroupOrderEntity() {
    }

    public int getGroupOrderId() {
        return groupOrderId;
    }

    public void setGroupOrderId(int groupOrderId) {
        this.groupOrderId = groupOrderId;
    }

    public int getGroupOrderTimeout() {
        return groupOrderTimeout;
    }

    public void setGroupOrderTimeout(int groupOrderTimeout) {
        this.groupOrderTimeout = groupOrderTimeout;
    }


    public String getGroupOrderEmployeeName() {
        return groupOrderEmployeeName;
    }

    public void setGroupOrderEmployeeName(String groupOrderEmployeeName) {
        this.groupOrderEmployeeName = groupOrderEmployeeName;
    }

    public LocalDateTime getGroupOrderCreated() {
        return groupOrderCreated;
    }

    public void setGroupOrderCreated(LocalDateTime groupOrderCreated) {
        this.groupOrderCreated = groupOrderCreated;
    }

    public LocalDateTime getGroupOrderUpdated() {
        return groupOrderUpdated;
    }

    public void setGroupOrderUpdated(LocalDateTime groupOrderUpdated) {
        this.groupOrderUpdated = groupOrderUpdated;
    }

    public RestaurantEntity getRestaurantEntity() {
        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
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
                "groupOrderId=" + groupOrderId +
                ", groupOrderTimeout=" + groupOrderTimeout +
                ", groupOrderEmployeeName='" + groupOrderEmployeeName + '\'' +
                ", groupOrderCreated=" + groupOrderCreated +
                ", groupOrderUpdated=" + groupOrderUpdated +
                ", restaurantEntity=" + restaurantEntity +
                ", orderItems=" + orderItems +
                '}';
    }
}
