package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int restaurantID;
    @Column(name = "restaurant_name")
    private String restaurantName;
    @Column(name = "restaurant_address")
    private String restaurantAddress;
    @Column(name = "restaurant_phone_number")
    private String restaurantPhoneNumber;
    @Column(name = "restaurant_menu_url")
    private String restaurantMenuUrl;
    private LocalDateTime restaurantCreated;
    private LocalDateTime restaurantUpdated;

    public RestaurantEntity() {
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

    public LocalDateTime getRestaurantCreated() {
        return restaurantCreated;
    }

    public void setRestaurantCreated(LocalDateTime restaurantCreated) {
        this.restaurantCreated = restaurantCreated;
    }

    public LocalDateTime getRestaurantUpdated() {
        return restaurantUpdated;
    }

    public void setRestaurantUpdated(LocalDateTime restaurantUpdated) {
        this.restaurantUpdated = restaurantUpdated;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID=" + restaurantID +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", restaurantMenuUrl='" + restaurantMenuUrl + '\'' +
                ", deliveryInfoCreated=" + restaurantCreated +
                ", deliveryInfoUpdated=" + restaurantUpdated +
                '}';
    }
}

