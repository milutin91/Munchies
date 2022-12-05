package com.example.munchies.model.dto;

import javax.validation.constraints.PositiveOrZero;

public class DeliveryInfoRequestDTO {
    @PositiveOrZero(message = "Delivery Time must be greater than or equal to 0")
    private int deliveryInfoTime;
    @PositiveOrZero(message = "Additional Charges must be greater than or equal to 0")
    private double deliveryInfoAdditionalCharges;

    public DeliveryInfoRequestDTO() {
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
