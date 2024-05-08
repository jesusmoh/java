package io.github.jesusmoh.zproduct.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String skuCode;
    private Double price;
    private String status;
    private int delete;
}
