package com.example.munchies.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GroupOrderCreationDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 55, message = "Name must be between 1 and 55 characters")
    public String groupOrderEmployeeName;
    @Min(value = 10, message = "Minimum order timeout is 10 minutes")
    public int groupOrderTimeout;

    public GroupOrderCreationDTO() {
    }

    public String getGroupOrderEmployeeName() {
        return groupOrderEmployeeName;
    }

    public void setGroupOrderEmployeeName(String groupOrderEmployeeName) {
        this.groupOrderEmployeeName = groupOrderEmployeeName;
    }

    public int getGroupOrderTimeout() {
        return groupOrderTimeout;
    }

    public void setGroupOrderTimeout(int groupOrderTimeout) {
        this.groupOrderTimeout = groupOrderTimeout;
    }

    @Override
    public String toString() {
        return "GroupOrderCreationDTO{" +
                "employeeFirstname='" + groupOrderEmployeeName + '\'' +
                ", orderTimeout=" + groupOrderTimeout +
                '}';
    }
}
