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

    public double getTotal(List<OrderItemDTO> orderItems, Integer groupOrderId) {
        double total = 0;
        for (var orderItem : orderItems) {
            total += orderItem.getOrderItemPrice();
        }
        double restaurantAdditionalCharges = groupOrderRepository.findById(groupOrderId).get()
                .getRestaurantEntity()
                .getDeliveryInfoEntity()
                .getDeliveryInfoAdditionalCharges();
        total += restaurantAdditionalCharges;
        return total;
    }

    public List<OrderItemDTO> getOrderItemDtoList(List<OrderItemEntity> orderItemEntityList) {
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
        if (orderItemEntityList == null) {
            return orderItemDTOList;
        }
        for (var orderItemEntity : orderItemEntityList) {
            orderItemDTOList.add(orderItemMapper.mapOrderItemEntityToDto(orderItemEntity));
        }
        return orderItemDTOList;
    }
}
