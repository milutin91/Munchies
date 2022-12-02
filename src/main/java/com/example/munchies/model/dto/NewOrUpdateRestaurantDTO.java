package com.example.munchies.model.dto;

public class NewRestaurantDTO {
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhoneNumber;
    private String restaurantMenuUrl;
    private DeliveryInfoDTO deliveryInfoDTO;

    public NewRestaurantDTO() {
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

    public DeliveryInfoDTO getDeliveryInfoDTO() {
        return deliveryInfoDTO;
    }

    public void setDeliveryInfoDTO(DeliveryInfoDTO deliveryInfoDTO) {
        this.deliveryInfoDTO = deliveryInfoDTO;
    }

    public String getRestaurantMenuUrl() {
        return restaurantMenuUrl;
    }

    public void setRestaurantMenuUrl(String restaurantMenuUrl) {
        this.restaurantMenuUrl = restaurantMenuUrl;
    }


    @Override
    public String toString() {
        return "NewRestaurantDTO{" +
                "restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", restaurantMenuUrl='" + restaurantMenuUrl + '\'' +
                ", deliveryInfoDTO=" + deliveryInfoDTO +
                '}';
    }
}
