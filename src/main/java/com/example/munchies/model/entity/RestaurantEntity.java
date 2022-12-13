package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int restaurantId;
    private String restaurantName;
    private String restaurantShortName;
    private String restaurantAddress;
    private String restaurantPhoneNumber;
    private String restaurantMenuUrl;
    private LocalDateTime restaurantCreated;
    private LocalDateTime restaurantUpdated;

    @OneToOne(mappedBy = "restaurantEntity", cascade = CascadeType.ALL)
    private DeliveryInfoEntity deliveryInfoEntity;

    @OneToMany(mappedBy = "restaurantEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupOrderEntity> groupOrders;

    public RestaurantEntity() {
        this.restaurantCreated = LocalDateTime.now();
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

    public String getRestaurantShortName() {
        return restaurantShortName;
    }

    public void setRestaurantShortName(String restaurantShortName) {
        this.restaurantShortName = restaurantShortName;
    }

    public DeliveryInfoEntity getDeliveryInfoEntity() {
        return deliveryInfoEntity;
    }

    public void setDeliveryInfoEntity(DeliveryInfoEntity deliveryInfoEntity) {
        this.deliveryInfoEntity = deliveryInfoEntity;
    }

    public List<GroupOrderEntity> getGroupOrders() {
        return groupOrders;
    }

    public void setGroupOrders(List<GroupOrderEntity> groupOrders) {
        this.groupOrders = groupOrders;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhoneNumber='" + restaurantPhoneNumber + '\'' +
                ", restaurantMenuUrl='" + restaurantMenuUrl + '\'' +
                ", deliveryInfoCreated=" + restaurantCreated +
                ", deliveryInfoUpdated=" + restaurantUpdated +
                '}';
    }
}

