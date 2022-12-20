package com.example.munchies.service;

import com.example.munchies.ExceptionHandling.NotFoundException;
import com.example.munchies.mapper.OrderItemMapper;
import com.example.munchies.model.dto.OrderItemCreationDTO;
import com.example.munchies.model.dto.OrderItemDTO;
import com.example.munchies.model.entity.GroupOrderEntity;
import com.example.munchies.model.entity.OrderItemEntity;
import com.example.munchies.repository.GroupOrderRepository;
import com.example.munchies.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    GroupOrderRepository groupOrderRepository;
    @Autowired
    OrderItemMapper orderItemMapper;

    public OrderItemDTO createEmployeeSelection(Integer id, OrderItemCreationDTO orderItemCreationDTO) throws NotFoundException {
        GroupOrderEntity groupOrder = groupOrderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Group order doesn't exist"));
        OrderItemEntity orderItemEntity = orderItemMapper.mapOrderItemCreationToEntity(groupOrder, orderItemCreationDTO);
        OrderItemEntity orderItemResponse = orderItemRepository.save(orderItemEntity);
        return orderItemMapper.mapOrderItemEntityToDto(orderItemResponse);
    }
}
