package com.example.munchies.controller;

import com.example.munchies.model.dto.OrderItemCreationDTO;
import com.example.munchies.repository.GroupOrderRepository;
import com.example.munchies.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;
    @Autowired
    GroupOrderRepository groupOrderRepository;

    @PostMapping("/group-order/selection")
    public String createEmployeeSelection(OrderItemCreationDTO orderItemCreationDTO, RedirectAttributes redirectAttributes){
        orderItemService.createEmployeeSelection(orderItemCreationDTO);
        Integer groupOrderId = groupOrderRepository.findTopByOrderByGroupOrderIdDesc().getGroupOrderId();
        redirectAttributes.addAttribute("groupOrderId", groupOrderId);
        return "redirect:/group-order/{groupOrderId}";
    }
}
