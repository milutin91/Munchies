package com.example.munchies.model.entity;

import com.example.munchies.model.Enum.EmployeeRole;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeID;
    @Column(name = "employee_firstname")
    private String employeeFirstname;
    @Column(name = "employee_lastname")
    private String employeeLastname;
    @Column(name = "employee_email")
    private String employeeEmail;
    @Column(name = "employee_password")
    private String employeePassword;
    @Column(name = "employee_role")
    private EmployeeRole employeeRole;
    @Column(name = "employee_created")
    private LocalDateTime employeeCreated;
    @Column(name = "employee_updated")
    private LocalDateTime employeeUpdated;

    @OneToMany(mappedBy = "employeeEntity")
    private List<GroupOrderEntity> groupOrders;

    @OneToMany(mappedBy = "employeeEntity")
    private List<OrderItemEntity> orderItems;

    public EmployeeEntity() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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
                "employeeID=" + employeeID +
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
