package com.example.munchies.model.dto;

public class RestaurantViewDTO {
    private String restaurantName;
    private String restaurantShortName;
    private String restaurantAddress;
    private String restaurantPhoneNumber;
    private String restaurantMenuUrl;

    public RestaurantViewDTO() {
    }

    public RestaurantViewDTO(String restaurantName, String restaurantShortName, String restaurantAddress, String restaurantPhoneNumber, String restaurantMenuUrl) {
        this.restaurantName = restaurantName;
        this.restaurantShortName = restaurantShortName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
        this.restaurantMenuUrl = restaurantMenuUrl;
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

    @Override
    public String toString() {
        return "RestaurantViewDTO{" +
                "restaurantName='" + restaurantName + '\'' +
                ", restaurantShortName='" + restaurantShortName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", restaurantMenuUrl='" + restaurantMenuUrl + '\'' +
                '}';
    }
}

