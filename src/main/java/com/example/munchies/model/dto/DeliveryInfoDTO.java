package com.example.munchies.model.dto;

import javax.validation.constraints.PositiveOrZero;

public class DeliveryInfoDTO {
    @PositiveOrZero(message = "Delivery Time must be greater than or equal to 0")
    private int deliveryInfoTime;
    @PositiveOrZero(message = "Additional Charges must be greater than or equal to 0")
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
