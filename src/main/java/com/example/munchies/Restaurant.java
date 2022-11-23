package com.example.munchies;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantID;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhoneNumber;
    private String restaurantMenuUrl;
    private LocalDateTime deliveryInfoCreated;
    private LocalDateTime deliveryInfoUpdated;

    public Restaurant() {
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantPhoneNumber() {
        return restaurantPhoneNumber;
    }

    public void setRestaurantPhoneNumber(String restaurantPhoneNumber) {
        this.restaurantPhoneNumber = restaurantPhoneNumber;
    }

    public String getRestaurantMenuUrl() {
        return restaurantMenuUrl;
    }

    public void setRestaurantMenuUrl(String restaurantMenuUrl) {
        this.restaurantMenuUrl = restaurantMenuUrl;
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID=" + restaurantID +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", restaurantMenuUrl='" + restaurantMenuUrl + '\'' +
                ", deliveryInfoCreated=" + deliveryInfoCreated +
                ", deliveryInfoUpdated=" + deliveryInfoUpdated +
                '}';
    }
}

