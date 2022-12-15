package com.example.munchies.mapper;

import com.example.munchies.model.dto.GroupOrderCreationDTO;
import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.entity.GroupOrderEntity;
import com.example.munchies.repository.RestaurantRepository;
import com.example.munchies.service.GroupOrderService;
import com.example.munchies.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GroupOrderMapper {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    GroupOrderService groupOrderService;
    @Autowired
    OrderItemService orderItemService;
    public GroupOrderEntity mapGroupOrderCreationDtoToEntity(Integer id, GroupOrderCreationDTO groupOrderCreationDTO){
        GroupOrderEntity groupOrder = new GroupOrderEntity();

        groupOrder.setGroupOrderEmployeeName(groupOrderCreationDTO.getGroupOrderEmployeeName());
        groupOrder.setGroupOrderTimeout(groupOrderCreationDTO.getGroupOrderTimeout());
        groupOrder.setGroupOrderCreated(LocalDateTime.now());
        groupOrder.setRestaurantEntity(restaurantRepository.findById(id).get());

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
        groupOrderDTO.setOrderItemDTOs(orderItemService.getOrderItemDtoList(groupOrderEntity.getOrderItems()));
        groupOrderDTO.setTotal(orderItemService.getTotal(groupOrderDTO.getOrderItemDTOs(), groupOrderEntity.getGroupOrderId()));
        groupOrderDTO.setActive(groupOrderService.groupOrderIsActive(groupOrderDTO));

        return groupOrderDTO;
    }

}
