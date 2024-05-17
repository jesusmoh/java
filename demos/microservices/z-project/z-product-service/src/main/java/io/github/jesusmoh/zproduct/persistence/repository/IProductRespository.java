package io.github.jesusmoh.zproduct.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.jesusmoh.zproduct.persistence.entity.Product;

public interface IProductRespository extends MongoRepository<Product, String> {
}