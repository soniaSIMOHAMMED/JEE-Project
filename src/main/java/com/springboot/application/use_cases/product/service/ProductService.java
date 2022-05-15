package com.springboot.application.use_cases.product.service;

import com.springboot.application.use_cases.product.domain.Fragrance;
import com.springboot.application.use_cases.product.exposition.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);
    ProductDto updateProduct(long id, ProductDto product);
    ProductDto getProductById(long productId);
    List<ProductDto> getAllProducts();
    List<ProductDto> getAllProductsByFragrance(Fragrance fragrance);
    void deleteProduct(long productId);

}
