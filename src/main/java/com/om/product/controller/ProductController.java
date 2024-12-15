package com.om.product.controller;

import com.om.product.dto.ProductRequest;
import com.om.product.dto.ProductResponse;
import com.om.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> getProduct(@RequestBody ProductRequest productRequest) {
       return new ResponseEntity<>(productService.createProduct(productRequest),HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<ProductResponse>> getProduct() {
        return new ResponseEntity<>(productService.getProductAllProducts(),HttpStatus.CREATED);
    }
}
