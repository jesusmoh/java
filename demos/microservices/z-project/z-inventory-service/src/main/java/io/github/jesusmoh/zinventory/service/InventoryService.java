package io.github.jesusmoh.zinventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jesusmoh.zinventory.persistence.entities.Inventory;
import io.github.jesusmoh.zinventory.persistence.repository.IInventoryRespository;

@Service
public class InventoryService {

	@Autowired
	private IInventoryRespository iventoryRespository;

	public Inventory isInStock(String skuCode) {
		var r = iventoryRespository.findAll().stream().filter(x -> x.getSkuCode().equalsIgnoreCase(skuCode)).limit(1);
		return r.findFirst().orElse(null);
	}

}