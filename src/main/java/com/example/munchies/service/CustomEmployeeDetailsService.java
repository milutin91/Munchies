package com.example.munchies.service;

import com.example.munchies.model.CustomEmployeeDetails;
import com.example.munchies.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public CustomEmployeeDetailsService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

        var employee = employeeRepository.findOneByEmployeeEmail(email).orElseThrow(IllegalArgumentException::new);

        return new CustomEmployeeDetails(employee);
    }
}
