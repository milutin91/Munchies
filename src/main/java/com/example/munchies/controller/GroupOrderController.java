package com.example.munchies.controller;

import com.example.munchies.model.dto.GroupOrderCreationDTO;
import com.example.munchies.model.dto.OrderItemCreationDTO;
import com.example.munchies.model.dto.OrderItemDTO;
import com.example.munchies.service.GroupOrderService;
import com.example.munchies.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GroupOrderController {

    @Autowired
    GroupOrderService groupOrderService;
    @Autowired
    OrderItemService orderItemService;

    //CREATE (form)
    @GetMapping("/restaurant/{restaurantId}/group-order/create")
    public String createOrderForm(@PathVariable("restaurantId") Integer id, GroupOrderCreationDTO groupOrderCreationDTO, Model model) {
        model.addAttribute("restaurantId", id);
        model.addAttribute("newGroupOrder", groupOrderCreationDTO);
        return "create_group_order";
    }

    //CREATE
    @PostMapping("/restaurant/{restaurantId}/group-order/create")
    public String createOrder(@PathVariable("restaurantId") Integer id,
                              @ModelAttribute("newGroupOrder") GroupOrderCreationDTO groupOrderCreationDTO,
                              RedirectAttributes redirectAttributes) {
        Integer groupOrderId = groupOrderService.createGroupOrder(id, groupOrderCreationDTO).getGroupOrderId();
        redirectAttributes.addAttribute("groupOrderId", groupOrderId);
        return "redirect:/restaurant/{restaurantId}/group-order/create/{groupOrderId}";
    }

    //current group order
    @GetMapping("/restaurant/{restaurantId}/group-order/create/{groupOrderId}")
    public String groupOrderPage(OrderItemCreationDTO orderItemCreationDTO, Model model) {
        model.addAttribute("groupOrder", groupOrderService.getGroupOrder());
        model.addAttribute("orderItemCreation", orderItemCreationDTO);
        model.addAttribute("orderItemsResponse", orderItemService.getOrderItemSelectionsLastGroupOrderId());
        model.addAttribute("total", orderItemService.getTotal(orderItemService.getOrderItemSelectionsLastGroupOrderId()));
        model.addAttribute("isActive", groupOrderService.groupOrderIsActive(groupOrderService.getGroupOrder()));
        return "group_order";
    }
}
