package io.github.jesusmoh.zorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jesusmoh.zorder.model.record.OrderPlacedDTO;
import io.github.jesusmoh.zorder.model.record.OrderRequestDTO;
import io.github.jesusmoh.zorder.service.IOrderService;

@RestController
@RequestMapping("api/orders")
public class OrderRestController {

    @Autowired
    private IOrderService orderService;

    @PostMapping()
    public OrderPlacedDTO placeOrder(@RequestBody OrderRequestDTO dto) {
        return orderService.placeOrder(dto);
    }
}
