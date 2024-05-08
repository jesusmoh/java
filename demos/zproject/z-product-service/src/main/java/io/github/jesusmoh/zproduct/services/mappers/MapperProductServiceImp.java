package io.github.jesusmoh.zproduct.services.mappers;

import org.springframework.stereotype.Service;

import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import io.github.jesusmoh.zproduct.persistence.entity.Product;

@Service
public class MapperProductServiceImp implements IMapperProductService {

    @Override
    public Product toProduct(ProductDTO dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .skuCode(dto.getSkuCode())
                .price(dto.getPrice())
                .status(dto.getStatus())
                .description(dto.getDescription())
                .build();
    }

    @Override
    public ProductDTO toDto(Product p) {
        return ProductDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getPrice())
                .skuCode(p.getSkuCode())
                .status(p.getStatus())
                .description(p.getDescription())
                .build();
    }
}
