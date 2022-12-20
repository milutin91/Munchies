package com.example.munchies.mapper;

import com.example.munchies.model.dto.GroupOrderCreationDTO;
import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.dto.OrderItemDTO;
import com.example.munchies.model.entity.GroupOrderEntity;
import com.example.munchies.model.entity.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class GroupOrderMapper {

    @Autowired
    OrderItemMapper orderItemMapper;
    public GroupOrderEntity mapGroupOrderCreationDtoToEntity(RestaurantEntity restaurantEntity, GroupOrderCreationDTO groupOrderCreationDTO) {
        GroupOrderEntity groupOrder = new GroupOrderEntity();

        groupOrder.setGroupOrderEmployeeName(groupOrderCreationDTO.getGroupOrderEmployeeName());
        groupOrder.setGroupOrderTimeout(groupOrderCreationDTO.getGroupOrderTimeout());
        groupOrder.setGroupOrderCreated(LocalDateTime.now());
        groupOrder.setRestaurantEntity(restaurantEntity);

        return groupOrder;
    }

    public GroupOrderDTO mapGroupOrderEntityToDto(GroupOrderEntity groupOrderEntity) {
        GroupOrderDTO groupOrderDTO = new GroupOrderDTO();

        groupOrderDTO.setGroupOrderId(groupOrderEntity.getGroupOrderId());
        groupOrderDTO.setGroupOrderTimeout(groupOrderEntity.getGroupOrderTimeout());
        groupOrderDTO.setTimeout(groupOrderEntity.getGroupOrderCreated().plusMinutes(groupOrderEntity.getGroupOrderTimeout()));
        groupOrderDTO.setGroupOrderEmployeeName(groupOrderEntity.getGroupOrderEmployeeName());
        groupOrderDTO.setRestaurantId(groupOrderEntity.getRestaurantEntity().getRestaurantId());
        groupOrderDTO.setRestaurantName(groupOrderEntity.getRestaurantEntity().getRestaurantName());
        groupOrderDTO.setRestaurantPhoneNumber(groupOrderEntity.getRestaurantEntity().getRestaurantPhoneNumber());
        groupOrderDTO.setRestaurantMenuUrl(groupOrderEntity.getRestaurantEntity().getRestaurantMenuUrl());
        groupOrderDTO.setOrderItemDTOs(orderItemMapper.mapOrderItemEntityToDto(groupOrderEntity.getOrderItems()));
        groupOrderDTO.setTotal(getTotal(groupOrderDTO.getOrderItemDTOs(), groupOrderEntity));
        groupOrderDTO.setActive(groupOrderIsActive(groupOrderDTO));

        return groupOrderDTO;
    }

    public double getTotal(List<OrderItemDTO> orderItems, GroupOrderEntity groupOrderEntity) {
        double total = 0;
        for (var orderItem : orderItems) {
            total += orderItem.getOrderItemPrice();
        }
        double restaurantAdditionalCharges = groupOrderEntity
                .getRestaurantEntity()
                .getDeliveryInfoEntity()
                .getDeliveryInfoAdditionalCharges();

        total += restaurantAdditionalCharges;
        return total;
    }

    public boolean groupOrderIsActive(GroupOrderDTO groupOrderDTO) {
        return !LocalDateTime.now().isAfter(groupOrderDTO.getTimeout());
    }
}
