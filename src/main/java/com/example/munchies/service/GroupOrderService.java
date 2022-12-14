package com.example.munchies.service;

import com.example.munchies.mapper.GroupOrderMapper;
import com.example.munchies.model.dto.GroupOrderCreationDTO;
import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.entity.GroupOrderEntity;
import com.example.munchies.repository.GroupOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<GroupOrderDTO> getAllActiveGroupOrders() {
        List<GroupOrderEntity> groupOrderEntities = groupOrderRepository.findAll();
        List<GroupOrderDTO> groupOrderDTOS = new ArrayList<>();
        for (var groupOrder : groupOrderEntities) {
            if (groupOrder.getGroupOrderCreated().plusMinutes(groupOrder.getGroupOrderTimeout()).isBefore(LocalDateTime.now())) {
                groupOrderDTOS.add(groupOrderMapper.mapGroupOrderEntityToDto(groupOrder));
            }
        }
        return groupOrderDTOS;
    }

    public GroupOrderDTO getGroupOrder() {
        return groupOrderMapper.mapGroupOrderEntityToDto(groupOrderRepository.findTopByOrderByGroupOrderIdDesc());
    }

    public boolean groupOrderIsActive(GroupOrderDTO groupOrderDTO) {
        return !LocalDateTime.now().isAfter(groupOrderDTO.getTimeout());
    }

    public GroupOrderEntity getLatestGroupOrder(){
        return groupOrderRepository.findTopByOrderByGroupOrderIdDesc();
    }
}
