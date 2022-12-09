package com.example.munchies.model.dto;

import java.time.LocalDateTime;

public class RestaurantDTO {

    private int restaurantId;
    private String restaurantName;
    private String restaurantShortName;
    private String restaurantAddress;
    private String restaurantPhoneNumber;
    private String restaurantMenuUrl;
    private LocalDateTime restaurantCreated;
    private LocalDateTime restaurantUpdated;
    private int deliveryInfoTime;
    private double deliveryInfoAdditionalCharges;

    public RestaurantDTO() {
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantShortName() {
        return restaurantShortName;
    }

    public void setRestaurantShortName(String restaurantShortName) {
        this.restaurantShortName = restaurantShortName;
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

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantShortName='" + restaurantShortName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", restaurantMenuUrl='" + restaurantMenuUrl + '\'' +
                ", restaurantCreated=" + restaurantCreated +
                ", restaurantUpdated=" + restaurantUpdated +
                ", deliveryInfoTime=" + deliveryInfoTime +
                ", deliveryInfoAdditionalCharges=" + deliveryInfoAdditionalCharges +
                '}';
    }
}
