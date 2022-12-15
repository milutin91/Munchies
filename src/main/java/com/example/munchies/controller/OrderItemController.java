package com.example.munchies.controller;

import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.dto.OrderItemCreationDTO;
import com.example.munchies.service.GroupOrderService;
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
    GroupOrderService groupOrderService;

    @PostMapping("/restaurant/group-order/selection-create")
    public String createEmployeeSelection(OrderItemCreationDTO orderItemCreationDTO, RedirectAttributes redirectAttributes){
        orderItemService.createEmployeeSelection(orderItemCreationDTO);
        GroupOrderDTO groupOrderDTO = groupOrderService.getLatestGroupOrderDTO();
        redirectAttributes.addAttribute("groupOrderId", groupOrderDTO.getGroupOrderId());
        return "redirect:/restaurant/group-order/{groupOrderId}";
    }
}
