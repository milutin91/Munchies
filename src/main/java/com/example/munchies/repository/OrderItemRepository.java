package com.example.munchies.repository;

import com.example.munchies.model.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
}
