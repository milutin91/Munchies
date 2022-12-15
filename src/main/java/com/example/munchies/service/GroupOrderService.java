package com.example.munchies.service;

import com.example.munchies.mapper.GroupOrderMapper;
import com.example.munchies.model.dto.GroupOrderCreationDTO;
import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.entity.GroupOrderEntity;
import com.example.munchies.repository.GroupOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GroupOrderService {
    @Autowired
    GroupOrderRepository groupOrderRepository;
    @Autowired
    GroupOrderMapper groupOrderMapper;

    public GroupOrderDTO createGroupOrder(Integer id, GroupOrderCreationDTO groupOrderCreationDTO) {
        GroupOrderEntity groupOrder = groupOrderMapper.mapGroupOrderCreationDtoToEntity(id, groupOrderCreationDTO);
        GroupOrderEntity groupOrderResponse = groupOrderRepository.save(groupOrder);
        return groupOrderMapper.mapGroupOrderEntityToDto(groupOrderResponse);
    }

    public GroupOrderDTO getGroupOrder(Integer groupOrderId) {
        return groupOrderMapper.mapGroupOrderEntityToDto(groupOrderRepository.findById(groupOrderId).get());
    }

    public boolean groupOrderIsActive(GroupOrderDTO groupOrderDTO) {
        return !LocalDateTime.now().isAfter(groupOrderDTO.getTimeout());
    }

    public GroupOrderDTO getLatestGroupOrderDTO(){
        return groupOrderMapper.mapGroupOrderEntityToDto(groupOrderRepository.findTopByOrderByGroupOrderIdDesc());
    }
}
