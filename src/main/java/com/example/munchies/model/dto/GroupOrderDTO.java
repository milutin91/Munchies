package com.example.munchies.model.dto;

import java.time.LocalDateTime;

public class GroupOrderDTO {
    private int groupOrderId;
    private int groupOrderTimeout;
    private LocalDateTime timeout;
    private String groupOrderEmployeeName;
    private int restaurantId;
    private String restaurantName;
    private String restaurantPhoneNumber;
    private String restaurantMenuUrl;

    public GroupOrderDTO() {
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

    public LocalDateTime getTimeout() {
        return timeout;
    }

    public void setTimeout(LocalDateTime timeout) {
        this.timeout = timeout;
    }

    public String getGroupOrderEmployeeName() {
        return groupOrderEmployeeName;
    }

    public void setGroupOrderEmployeeName(String groupOrderEmployeeName) {
        this.groupOrderEmployeeName = groupOrderEmployeeName;
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
        return "GroupOrderDTO{" +
                "groupOrderId=" + groupOrderId +
                ", groupOrderTimeout=" + groupOrderTimeout +
                ", timeout=" + timeout +
                ", groupOrderEmployeeName='" + groupOrderEmployeeName + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", restaurantMenuUrl='" + restaurantMenuUrl + '\'' +
                '}';
    }
}
