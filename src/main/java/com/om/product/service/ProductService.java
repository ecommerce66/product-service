package com.om.product.service;

import com.om.product.dto.ProductRequest;
import com.om.product.dto.ProductResponse;
import com.om.product.model.Product;
import com.om.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {

    Logger LOGGER = Logger.getLogger(ProductService.class.getName());

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        productRepository.save(product);
        LOGGER.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getProductAllProducts(){
        List<ProductResponse> productResponse = productRepository.findAll().stream().map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice())).toList();
        LOGGER.info("Product retrieved successfully");
        return productResponse;
    }
}
