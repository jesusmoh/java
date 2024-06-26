package io.github.jesusmoh.zproduct.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jesusmoh.zproduct.exeptions.AppException;
import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import io.github.jesusmoh.zproduct.persistence.entity.Product;
import io.github.jesusmoh.zproduct.persistence.repository.IProductRespository;
import io.github.jesusmoh.zproduct.services.mappers.IMapperProductService;
import io.github.jesusmoh.zproduct.services.validations.ProductValidatorServiceImp;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProductService implements IProductService {

    /*
     * In this example, the orderRepository field is still final, ensuring
     * immutability and security. The @Autowired annotation is used on the
     * constructor, which allows Spring to inject an instance of IOrderRepository
     * when creating an object of type MyService.
     * 
     * This approach provides a good balance between performance, security, and
     * flexibility.
     */

    private final IProductRespository productRepository;
    private final IMapperProductService mapperProductService;
    private final ProductValidatorServiceImp productValidatorService;

    @Autowired
    public ProductService(IProductRespository productRepository, ProductValidatorServiceImp productValidatorService,
            IMapperProductService mapperProductService) {
        this.productRepository = productRepository;
        this.productValidatorService = productValidatorService;
        this.mapperProductService = mapperProductService;
    }

    // @NewSpan("createProduct")
    @Override
    public Product createProduct(ProductDTO dto) {
        var v = productValidatorService.validate(dto);
        if (!v.isValid()) {
            log.error("Product not created: {}", v.getResult());
            throw new AppException(v.getResult(), true);
        }
        var p = mapperProductService.toProduct(dto);
        var r = productRepository.save(p);
        log.info("Product created: {}", r);
        return r;
    }

    @Override
    public void readProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readProduct'");
    }

    @Override
    public Product updateProduct(ProductDTO dto) {
        var v = productValidatorService.validate(dto);
        if (!v.isValid()) {
            log.error("Product not updated: {}", v.getResult());
            throw new AppException(v.getResult(), true);
        }
        var p = mapperProductService.toProduct(dto);
        var r = productRepository.save(p);
        log.info("Product updated: {}", r);
        return r;
    }

    @Override
    public Product deleteProduct(ProductDTO dto) {
        var v = productValidatorService.validate(dto);
        if (!v.isValid()) {
            log.error("Product not deleted: {}", v.getResult());
            throw new AppException(v.getResult(), true);
        }
        var p = mapperProductService.toProduct(dto);
        p.setDelete(1);
        var r = productRepository.save(p);
        log.info("Product delete: {}", r);
        return r;
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public void searchProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchProduct'");
    }

}
