package com.example.munchies.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeFirstname;
    private String employeeLastname;
    private String employeeEmail;
    private String employeePassword;
    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;
    private LocalDateTime employeeCreated;
    private LocalDateTime employeeUpdated;

    public EmployeeEntity() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstname() {
        return employeeFirstname;
    }

    public void setEmployeeFirstname(String employeeFirstname) {
        this.employeeFirstname = employeeFirstname;
    }

    public String getEmployeeLastname() {
        return employeeLastname;
    }

    public void setEmployeeLastname(String employeeLastname) {
        this.employeeLastname = employeeLastname;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public LocalDateTime getEmployeeCreated() {
        return employeeCreated;
    }

    public void setEmployeeCreated(LocalDateTime employeeCreated) {
        this.employeeCreated = employeeCreated;
    }

    public LocalDateTime getEmployeeUpdated() {
        return employeeUpdated;
    }

    public void setEmployeeUpdated(LocalDateTime employeeUpdated) {
        this.employeeUpdated = employeeUpdated;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeID=" + employeeId +
                ", employeeFirstname='" + employeeFirstname + '\'' +
                ", employeeLastname='" + employeeLastname + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", employeeRole=" + employeeRole +
                ", employeeCreated=" + employeeCreated +
                ", employeeUpdated=" + employeeUpdated +
                '}';
    }
}
