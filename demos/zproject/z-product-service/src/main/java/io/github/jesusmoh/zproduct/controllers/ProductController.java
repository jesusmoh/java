package io.github.jesusmoh.zproduct.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import io.github.jesusmoh.zproduct.services.IProductService;
import io.github.jesusmoh.zproduct.services.mappers.IMapperProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IMapperProductService mapperProductService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            var n = productService.listProducts();
            return new ResponseEntity<>(n, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ProductDTO dto) {
        var n = productService.createProduct(dto);
        return new ResponseEntity<>(mapperProductService.toDto(n), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody ProductDTO dto) {
        try {
            var n = productService.updateProduct(dto);
            return new ResponseEntity<>(mapperProductService.toDto(n), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestBody ProductDTO dto) {
        try {
            var n = productService.deleteProduct(dto);
            return new ResponseEntity<>(mapperProductService.toDto(n), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
