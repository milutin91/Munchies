package com.example.munchies.controller;

import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.dto.OrderItemCreationDTO;
import com.example.munchies.service.GroupOrderService;
import com.example.munchies.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;
    @Autowired
    GroupOrderService groupOrderService;

    // TODO: 12/20/2022 fix not displaying validation messages
    @PostMapping("/restaurant/group-order/selection-create")
    public String createEmployeeSelection(@ModelAttribute("orderItemCreation") @Valid OrderItemCreationDTO orderItemCreationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        GroupOrderDTO groupOrderDTO = groupOrderService.getLatestGroupOrderDTO();
        redirectAttributes.addAttribute("groupOrderId", groupOrderDTO.getGroupOrderId());
        if(bindingResult.hasErrors()){
            return "redirect:/restaurant/group-order/{groupOrderId}";
        }

                orderItemService.createEmployeeSelection(orderItemCreationDTO);
        return "redirect:/restaurant/group-order/{groupOrderId}";
    }
}
