package io.github.jesusmoh.zorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.jesusmoh.zorder.model.record.InventoryProductDTO;

@FeignClient(value = "inventory", url = "http://localhost:8083")
public interface IInventoryClient {

    @RequestMapping(value = "api/inventory/inStock", method = RequestMethod.GET)
    public InventoryProductDTO isInStock(@PathVariable("skuCode") String skuCode);
}
