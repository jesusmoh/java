package io.github.jesusmoh.zinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping()
    public ResponseEntity<Inventory> getMethodName(@RequestParam String skuCode) {
        var r = inventoryService.isInStock(skuCode);
        if (r == null) {
            return new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(r, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<Inventory> getMethodName23(@RequestParam String skuCode) {
        var r = inventoryService.isInStock(skuCode);
        if (r == null) {
            return new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(r, HttpStatus.OK);
        }
    }

}
