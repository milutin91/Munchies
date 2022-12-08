package com.example.munchies.repository;

import com.example.munchies.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findOneByEmployeeEmail(String email);
}
