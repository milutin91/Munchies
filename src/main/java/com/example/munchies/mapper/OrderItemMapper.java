package com.example.munchies.mapper;

import com.example.munchies.model.dto.OrderItemCreationDTO;
import com.example.munchies.model.dto.OrderItemDTO;
import com.example.munchies.model.entity.OrderItemEntity;
import com.example.munchies.repository.GroupOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper {
    @Autowired
    GroupOrderRepository groupOrderRepository;
    public OrderItemEntity mapOrderItemCreationToEntity(OrderItemCreationDTO orderItemCreationDTO){
        OrderItemEntity orderItemEntity = new OrderItemEntity();

        orderItemEntity.setOrderItemEmployeeName(orderItemCreationDTO.getOrderItemEmployeeName());
        orderItemEntity.setOrderItemDescription(orderItemCreationDTO.getOrderItemDescription());
        orderItemEntity.setOrderItemPrice(orderItemCreationDTO.getOrderItemPrice());
        orderItemEntity.setOrderItemCreated(LocalDateTime.now());
        orderItemEntity.setGroupOrderEntity(groupOrderRepository.findTopByOrderByGroupOrderIdDesc());

        return orderItemEntity;
    }

    public OrderItemDTO mapOrderItemEntityToDto(OrderItemEntity orderItemEntity){
        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setOrderItemEmployeeName(orderItemEntity.getOrderItemEmployeeName());
        orderItemDTO.setOrderItemDescription(orderItemEntity.getOrderItemDescription());
        orderItemDTO.setOrderItemPrice(orderItemEntity.getOrderItemPrice());

        return orderItemDTO;
    }
}
