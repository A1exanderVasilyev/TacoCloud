package ru.vasilyev.tacocloud.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.vasilyev.tacocloud.repositories.OrderRepository;
import ru.vasilyev.tacocloud.tacos.TacoOrder;
import ru.vasilyev.tacocloud.tacos.User;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        order.setUser(user);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping("/current")
    public String orderForm(Model model,
                            @AuthenticationPrincipal User user) {
        TacoOrder order = orderRepository.findTacoOrderByUser(user)
                .orElse(new TacoOrder());

        order.setUser(user);
        model.addAttribute("tacoOrder", order);

        order.setDeliveryName(user.getUsername());
        order.setDeliveryCity(user.getCity());
        order.setDeliveryState(user.getState());
        order.setDeliveryZip(user.getZip());
        order.setDeliveryStreet(user.getStreet());

        return "orderForm";
    }
}
