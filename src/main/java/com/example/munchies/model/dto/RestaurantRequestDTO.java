package com.example.munchies.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RestaurantRequestDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 55, message = "Name must be between 1 and 55 characters")
    private String restaurantName;
    @NotBlank(message = "Address is mandatory")
    @Size(min = 1, max = 55, message = "Address must be between 1 and 55 characters")
    private String restaurantAddress;
    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10, max = 13, message = "Phone number must be between 10 and 13 characters")
    @Pattern(regexp = "^[0-9]*$", message = "Only numbers are allowed")
    private String restaurantPhoneNumber;
    @NotBlank(message = "Menu URL is mandatory")
    @Pattern(regexp = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)",
            message = "Not valid entry (Enter url without http/https)")
    private String restaurantMenuUrl;
    private DeliveryInfoRequestDTO deliveryInfoRequestDTO;

    public RestaurantRequestDTO() {
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

    public DeliveryInfoRequestDTO getDeliveryInfoDTO() {
        return deliveryInfoRequestDTO;
    }

    public void setDeliveryInfoDTO(DeliveryInfoRequestDTO deliveryInfoRequestDTO) {
        this.deliveryInfoRequestDTO = deliveryInfoRequestDTO;
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
                ", deliveryInfoDTO=" + deliveryInfoRequestDTO +
                '}';
    }
}
