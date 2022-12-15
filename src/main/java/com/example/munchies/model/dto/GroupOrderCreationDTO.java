package com.example.munchies.model.dto;

public class GroupOrderCreationDTO {
    public String groupOrderEmployeeName;
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
