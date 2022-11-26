package com.example.munchies.model;

import com.example.munchies.model.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


public class CustomEmployeeDetails implements UserDetails {

    @Autowired
    private final EmployeeEntity employee;

    public CustomEmployeeDetails(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(employee.getEmployeeRole().name()));
    }

    @Override
    public String getPassword() {
        return employee.getEmployeePassword();
    }

    @Override
    public String getUsername() {
        return employee.getEmployeeEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
