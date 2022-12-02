package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_info")
public class DeliveryInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_info_id")
    private int deliveryInfoID;
    @Column(name = "delivery_info_time")
    private int deliveryInfoTime;
    @Column(name = "delivery_info_additional_charges")
    private double deliveryInfoAdditionalCharges;
    @Column(name = "delivery_info_created")
    private LocalDateTime deliveryInfoCreated;
    @Column(name = "delivery_info_updated")
    private LocalDateTime deliveryInfoUpdated;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private RestaurantEntity restaurantEntity;

    public DeliveryInfoEntity() {
        this.deliveryInfoCreated = LocalDateTime.now();
    }

    public int getDeliveryInfoID() {
        return deliveryInfoID;
    }

    public void setDeliveryInfoID(int deliveryInfoID) {
        this.deliveryInfoID = deliveryInfoID;
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
                "deliveryInfoID=" + deliveryInfoID +
                ", deliveryInfoTime=" + deliveryInfoTime +
                ", deliveryInfoAdditionalCharges=" + deliveryInfoAdditionalCharges +
                ", deliveryInfoCreated=" + deliveryInfoCreated +
                ", deliveryInfoUpdated=" + deliveryInfoUpdated +
                ", restaurantEntity=" + restaurantEntity +
                '}';
    }
}
