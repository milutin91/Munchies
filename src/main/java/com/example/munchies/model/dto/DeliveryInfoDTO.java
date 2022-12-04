package com.example.munchies.model.dto;

import javax.validation.constraints.PositiveOrZero;

public class DeliveryInfoDTO {
    @PositiveOrZero
    private int deliveryInfoTime;
    @PositiveOrZero
    private double deliveryInfoAdditionalCharges;

    public DeliveryInfoDTO() {
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
}
