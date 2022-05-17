package com.springboot.application.use_cases.product.controller;

import com.springboot.application.use_cases.product.domain.Fragrance;
import com.springboot.application.use_cases.product.domain.Product;
import com.springboot.application.use_cases.product.exposition.ProductDto;
import com.springboot.application.use_cases.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(this.productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") long productId) {
        return new ResponseEntity<>(this.productService.getProductById(productId), HttpStatus.OK);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return this.productService.getAllProducts();
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(name = "id") long productId, @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(this.productService.updateProduct(productId, productDto), HttpStatus.OK);
    }

    @GetMapping("fragrances/{fragrance}")
    public List<ProductDto> getAllProductsByFragrance(@PathVariable(name = "fragrance") String fragrance) {
        return this.productService.getAllProductsByFragrance(fragrance);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(name = "id") long productId) {
        this.productService.deleteProduct(productId);
    }

}
