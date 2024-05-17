package io.github.jesusmoh.zorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jesusmoh.zorder.client.IInventoryClient;
import io.github.jesusmoh.zorder.model.record.OrderPlacedDTO;
import io.github.jesusmoh.zorder.model.record.OrderRequestDTO;
import io.github.jesusmoh.zorder.persistence.entities.Order;
import io.github.jesusmoh.zorder.persistence.repository.IOrderRespository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements IOrderService {

	@Autowired
	private IOrderRespository orderRepository;
	private final IInventoryClient inventoryClient;

	@Override
	public OrderPlacedDTO placeOrder(OrderRequestDTO dto) {
		var r = inventoryClient.isInStock(dto.skuCode());

		int availableStock = r.stock();
		int requestedQuantity = dto.quantity();
		int finalQuantity = availableStock > requestedQuantity ? requestedQuantity : availableStock;

		Order order = new Order();
		order.setOrderNumber(dto.orderNumber());
		if (finalQuantity > 0) {
			order.setSkuCode(dto.skuCode());
			order.setQuantity(finalQuantity);
			order.setTotal(dto.price() * finalQuantity);
			order.setStatus("PLACED");
			orderRepository.save(order);
			return new OrderPlacedDTO(order.getTotal(), order.getOrderNumber());
		}
		return new OrderPlacedDTO(-1, order.getOrderNumber());

	}

}