package io.github.jesusmoh.zproduct.services.mappers;

import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import io.github.jesusmoh.zproduct.persistence.entity.Product;

public interface IMapperProductService {

    Product toProduct(ProductDTO dto);

    ProductDTO toDto(Product p);
}
