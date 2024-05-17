package io.github.jesusmoh.zorder.service;

import io.github.jesusmoh.zorder.model.record.OrderPlacedDTO;
import io.github.jesusmoh.zorder.model.record.OrderRequestDTO;

public interface IOrderService {

    public OrderPlacedDTO placeOrder(OrderRequestDTO dto);
}
