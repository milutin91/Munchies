package com.example.munchies.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class GroupOrderDTO {
    private int groupOrderId;
    private int groupOrderTimeout;
    private LocalDateTime timeout;
    private String groupOrderEmployeeName;
    private boolean isActive;
    private int restaurantId;
    private String restaurantName;
    private String restaurantPhoneNumber;
    private String restaurantMenuUrl;
    private List<OrderItemDTO> orderItemDTOs;
    private double total;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public List<OrderItemDTO> getOrderItemDTOs() {
        return orderItemDTOs;
    }

    public void setOrderItemDTOs(List<OrderItemDTO> orderItemDTOs) {
        this.orderItemDTOs = orderItemDTOs;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
