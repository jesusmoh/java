package io.github.jesusmoh.zinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.jesusmoh.zinventory.persistence.entities.Inventory;
import io.github.jesusmoh.zinventory.service.InventoryService;

@RestController
@RequestMapping("api/inventory/inStock")
public class InventoyRestController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping()
    public Inventory getMethodName(@RequestBody Inventory dto) {
        return inventoryService.isInStock(dto.getSkuCode());
    }

    @GetMapping()
    public Inventory getMethodName2(@RequestParam String skuCode) {
        return inventoryService.isInStock(skuCode);
    }

}
