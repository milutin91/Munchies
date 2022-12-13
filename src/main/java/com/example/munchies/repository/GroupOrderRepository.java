package com.example.munchies.repository;

import com.example.munchies.model.entity.GroupOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupOrderRepository extends JpaRepository<GroupOrderEntity, Integer> {
    GroupOrderEntity findTopByOrderByGroupOrderIdDesc();
}
