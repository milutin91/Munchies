package com.example.munchies.service;

import com.example.munchies.ExceptionHandling.NotFoundException;
import com.example.munchies.ExceptionHandling.GroupOrderTimeoutException;
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

    public GroupOrderDTO createGroupOrder(Integer id, GroupOrderCreationDTO groupOrderCreationDTO) throws NotFoundException {
        GroupOrderEntity groupOrder = groupOrderMapper.mapGroupOrderCreationDtoToEntity(id, groupOrderCreationDTO);
        GroupOrderEntity groupOrderResponse = groupOrderRepository.save(groupOrder);
        return groupOrderMapper.mapGroupOrderEntityToDto(groupOrderResponse);
    }

    public GroupOrderDTO getGroupOrder(Integer groupOrderId) throws GroupOrderTimeoutException, NotFoundException {
        GroupOrderDTO groupOrderDTO = groupOrderMapper.mapGroupOrderEntityToDto(groupOrderRepository.findById(groupOrderId)
                .orElseThrow(() -> new NotFoundException("Group order doesn't exist")));
        if (!groupOrderDTO.isActive()) throw new GroupOrderTimeoutException("Time is up for this group order");
        return groupOrderDTO;
    }

    public boolean groupOrderIsActive(GroupOrderDTO groupOrderDTO) {
        return !LocalDateTime.now().isAfter(groupOrderDTO.getTimeout());
    }

    public GroupOrderDTO getLatestGroupOrderDTO() {
        return groupOrderMapper.mapGroupOrderEntityToDto(groupOrderRepository.findTopByOrderByGroupOrderIdDesc());
    }
}
