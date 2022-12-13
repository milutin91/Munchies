package com.example.munchies.service;

import com.example.munchies.mapper.OrderItemMapper;
import com.example.munchies.model.dto.OrderItemCreationDTO;
import com.example.munchies.model.dto.OrderItemDTO;
import com.example.munchies.model.entity.OrderItemEntity;
import com.example.munchies.repository.GroupOrderRepository;
import com.example.munchies.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    GroupOrderRepository groupOrderRepository;
    @Autowired
    OrderItemMapper orderItemMapper;

    public OrderItemDTO createEmployeeSelection(OrderItemCreationDTO orderItemCreationDTO) {
        OrderItemEntity orderItemEntity = orderItemMapper.mapOrderItemCreationToEntity(orderItemCreationDTO);
        OrderItemEntity orderItemResponse = orderItemRepository.save(orderItemEntity);
        return orderItemMapper.mapOrderItemEntityToDto(orderItemResponse);
    }

    public List<OrderItemDTO> getOrderItemSelectionsLastGroupOrderId() {
        List<OrderItemEntity> orderItemEntities = orderItemRepository.findAll();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        var groupOrder = groupOrderRepository.findTopByOrderByGroupOrderIdDesc();

        for (var orderItem : orderItemEntities) {
            if (orderItem.getGroupOrderEntity().getGroupOrderId() == groupOrder.getGroupOrderId())
                orderItemDTOS.add(orderItemMapper.mapOrderItemEntityToDto(orderItem));
        }

        return orderItemDTOS;
    }

    public double getTotal(List<OrderItemDTO> orderItemDTOS) {
        double total = 0;
        for (var orderItem : orderItemDTOS) {
            total += orderItem.getOrderItemPrice();
        }
        double restaurantAdditionalCharges = groupOrderRepository.findTopByOrderByGroupOrderIdDesc()
                .getRestaurantEntity()
                .getDeliveryInfoEntity()
                .getDeliveryInfoAdditionalCharges();
        total += restaurantAdditionalCharges;
        return total;
    }
}
