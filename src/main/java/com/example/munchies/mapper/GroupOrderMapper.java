package com.example.munchies.mapper;

import com.example.munchies.model.dto.GroupOrderCreationDTO;
import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.entity.GroupOrderEntity;
import com.example.munchies.repository.GroupOrderRepository;
import com.example.munchies.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GroupOrderMapper {

    @Autowired
    GroupOrderRepository groupOrderRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

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

        return groupOrderDTO;
    }
}
