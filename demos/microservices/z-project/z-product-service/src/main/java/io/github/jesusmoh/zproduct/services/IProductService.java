package io.github.jesusmoh.zproduct.services;

import java.util.List;

import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import io.github.jesusmoh.zproduct.persistence.entity.Product;

public interface IProductService {

    public Product createProduct(ProductDTO dto);

    public void readProduct();

    public Product updateProduct(ProductDTO dto);

    public Product deleteProduct(ProductDTO dto);

    public List<Product> listProducts();

    public void searchProduct();

}
