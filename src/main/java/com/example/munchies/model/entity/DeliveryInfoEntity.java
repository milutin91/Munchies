package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_info")
public class DeliveryInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryInfoId;
    private int deliveryInfoTime;
    private double deliveryInfoAdditionalCharges;
    private LocalDateTime deliveryInfoCreated;
    private LocalDateTime deliveryInfoUpdated;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private RestaurantEntity restaurantEntity;

    public DeliveryInfoEntity() {
        this.deliveryInfoCreated = LocalDateTime.now();
    }

    public int getDeliveryInfoId() {
        return deliveryInfoId;
    }

    public void setDeliveryInfoId(int deliveryInfoId) {
        this.deliveryInfoId = deliveryInfoId;
    }


    public int getDeliveryInfoTime() {
        return deliveryInfoTime;
    }

    public void setDeliveryInfoTime(int deliveryInfoTime) {
        this.deliveryInfoTime = deliveryInfoTime;
    }

    public double getDeliveryInfoAdditionalCharges() {
        return deliveryInfoAdditionalCharges;
    }

    public void setDeliveryInfoAdditionalCharges(double deliveryInfoAdditionalCharges) {
        this.deliveryInfoAdditionalCharges = deliveryInfoAdditionalCharges;
    }

    public LocalDateTime getDeliveryInfoCreated() {
        return deliveryInfoCreated;
    }

    public void setDeliveryInfoCreated(LocalDateTime deliveryInfoCreated) {
        this.deliveryInfoCreated = deliveryInfoCreated;
    }

    public LocalDateTime getDeliveryInfoUpdated() {
        return deliveryInfoUpdated;
    }

    public void setDeliveryInfoUpdated(LocalDateTime deliveryInfoUpdated) {
        this.deliveryInfoUpdated = deliveryInfoUpdated;
    }

    public RestaurantEntity getRestaurantEntity() {
        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
    }

    @Override
    public String toString() {
        return "DeliveryInfoEntity{" +
                "deliveryInfoID=" + deliveryInfoId +
                ", deliveryInfoTime=" + deliveryInfoTime +
                ", deliveryInfoAdditionalCharges=" + deliveryInfoAdditionalCharges +
                ", deliveryInfoCreated=" + deliveryInfoCreated +
                ", deliveryInfoUpdated=" + deliveryInfoUpdated +
                ", restaurantEntity=" + restaurantEntity +
                '}';
    }
}
