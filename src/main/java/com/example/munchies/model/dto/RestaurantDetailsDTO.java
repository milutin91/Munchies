package com.example.munchies.model.dto;

public class RestaurantDetailsDTO {
    private String restaurantName;
    private String restaurantShortName;
    private String restaurantAddress;
    private String restaurantPhoneNumber;
    private String restaurantMenuUrl;
    private int deliveryInfoTime;
    private double deliveryInfoAdditionalCharges;

    public RestaurantDetailsDTO() {
    }

    public RestaurantDetailsDTO(String restaurantName,
                                String restaurantShortName,
                                String restaurantAddress,
                                String restaurantPhoneNumber,
                                String restaurantMenuUrl,
                                int deliveryInfoTime,
                                double deliveryInfoAdditionalCharges) {
        this.restaurantName = restaurantName;
        this.restaurantShortName = restaurantShortName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
        this.restaurantMenuUrl = restaurantMenuUrl;
        this.deliveryInfoTime = deliveryInfoTime;
        this.deliveryInfoAdditionalCharges = deliveryInfoAdditionalCharges;
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
        return "RestaurantDetailsDTO{" +
                "restaurantName='" + restaurantName + '\'' +
                ", restaurantShortName='" + restaurantShortName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", restaurantMenuUrl='" + restaurantMenuUrl + '\'' +
                ", deliveryInfoTime=" + deliveryInfoTime +
                ", deliveryInfoAdditionalCharges=" + deliveryInfoAdditionalCharges +
                '}';
    }
}
