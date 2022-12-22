package com.example.munchies.controller;

import com.example.munchies.ExceptionHandling.GroupOrderTimeoutException;
import com.example.munchies.ExceptionHandling.NotFoundException;
import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.dto.OrderItemCreationDTO;
import com.example.munchies.service.GroupOrderService;
import com.example.munchies.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;
    @Autowired
    GroupOrderService groupOrderService;

    @PostMapping("/restaurant/group-order/{groupOrderId}/selection")
    public String createEmployeeSelection(@PathVariable("groupOrderId") Integer id,
                                          @ModelAttribute("orderItemCreation") @Valid OrderItemCreationDTO orderItemCreationDTO,
                                          BindingResult bindingResult,
                                          RedirectAttributes redirectAttributes,
                                          Model model) throws GroupOrderTimeoutException, NotFoundException {
        GroupOrderDTO groupOrderDTO = groupOrderService.getGroupOrder(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("groupOrder", groupOrderDTO);
            model.addAttribute("orderItemCreation", orderItemCreationDTO);
            return "group_order";
        }
        redirectAttributes.addAttribute("groupOrderId", groupOrderDTO.getGroupOrderId());
        orderItemService.createEmployeeSelection(id, orderItemCreationDTO);
        return "redirect:/restaurant/group-order/{groupOrderId}";
    }
}
