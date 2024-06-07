package io.github.jesusmoh.zorder.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.jesusmoh.zorder.model.record.InventoryProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(value = "inventory", url = "http://lenovopc-local:8083/")
public interface IInventoryClient {

    Logger log = LoggerFactory.getLogger(IInventoryClient.class);

    @RequestMapping(value = "api/inventory/inStock", method = RequestMethod.GET)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    public InventoryProductDTO isInStock(@RequestParam("skuCode") String skuCode);

    default InventoryProductDTO fallbackMethod(String skuCode, Throwable throwable) {
        log.info("Cannot get inventory for skucode " + skuCode + " " + throwable.getMessage());
        return new InventoryProductDTO(0, skuCode, 0);
    }
}
